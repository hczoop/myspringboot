package com.example.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class NIOServer {
   //根据 Sam的文档来  这里定义组成部分
   private  ServerSocketChannel server; 
   int port = 8080;
   //注册器  ---> 银行大厅业务叫号排队一体机
   private Selector selector;
   //缓冲区   ----->就是在听课的人 它去等待时候 是不是有一个集中区域
   //服务类读数据 存放的地方
   ByteBuffer recBuffer = ByteBuffer.allocate(1024);
   //服务类写数据 存放的地方
   ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
   //勾引事件的标签  对应  事件内容的一种关系
   Map<SelectionKey, String> sessionMsg = new HashMap<SelectionKey, String>();

   //构造方法初始化
   public NIOServer(int port) throws IOException{
	   this.port = port;
	   server = ServerSocketChannel.open();
	   //服务绑定端口
	   server.socket().bind(new InetSocketAddress(port));
	   //server设定非阻塞式  默认是true是为了兼容bio的模式
	   server.configureBlocking(false);
	   // 初始化注册器
	   selector=Selector.open();
	   //准备接待客户端连接
	   server.register(selector, SelectionKey.OP_ACCEPT);
	   System.out.println("NIO服务端已经启动，监听端口是：" +this.port);
   }

   //剩下业务我们拆分到这个方法 去监听
   public void listener() throws IOException{
	    while(true){
	    	int eventCount =selector.select();
	    	//代表没有人
	    	if(eventCount == 0){
	    		continue;
	    	}
	    	//等于是拿到所有事件的标签
	    	Set<SelectionKey> keys=selector.selectedKeys();
	    	Iterator<SelectionKey> iterator =keys.iterator();
	    	while(iterator.hasNext()){
	    		//处理事件
	    		process(iterator.next());
	    		//处理完之后 注册器移除客户端
	    		iterator.remove();
	    	}
	    }
   }

   //处理客户端（在座的各位去银行办业务的人）事件的具体方法
	private void process(SelectionKey key) {
		SocketChannel client = null;
		try {
			if(key.isValid() && key.isAcceptable()){
			client= server.accept();
			client.configureBlocking(false); //设定非阻塞式
			client.register(selector,SelectionKey.OP_READ);
			}else if(key.isValid() && key.isReadable()){
				recBuffer.clear();
				client=(SocketChannel)key.channel();
			  //把数据读到缓冲区
				int len=client.read(recBuffer);
				if(len>0){
					String msg = new String(recBuffer.array(),0,len);
				   //msg  聊天记录 维护一个对应的key msg
					sessionMsg.put(key, msg);
					System.out.println("获取到客户端发送来的信息: "+msg);
					client.register(selector,SelectionKey.OP_WRITE);
				}
			}else if(key.isValid() && key.isWritable()){
				if(!sessionMsg.containsKey(key)){
					return;
				}
				client=(SocketChannel)key.channel();
				sendBuffer.clear();
				sendBuffer.put(new String(sessionMsg.get(key)+ "，你好，你的请求已经处理完成。").getBytes());
				sendBuffer.flip(); //切换读写模式
				client.write(sendBuffer);
				client.register(selector, SelectionKey.OP_READ);
			}
		} catch (IOException e) {
	       //容错代码  客户端异常关闭
			try {
				key.cancel();
				client.socket().close();
				client.close();
				return;
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
}

	public static void main(String[] args) {
		try {
			new NIOServer(8080).listener();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
