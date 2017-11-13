package com.example.demo;

import com.example.demo.bean.User;
import com.example.demo.repository.UserMongoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class redisTests {
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Resource
	protected RedisTemplate<String, Object> redisTemplate;
	
	@Resource
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private UserMongoRepository userMongoRepository;
	
	@Before
	public void setUp() {
		System.out.println("执行前。。");
	}
	
	@Test
	@Rollback
	public void redisTest() throws Exception {
		/*User user = new User(2l, "张胜男", 22);
		// 保存字符串
		stringRedisTemplate.opsForValue().set("key1", "6666666");
		stringRedisTemplate.expire("key1", 1, TimeUnit.HOURS);
		redisTemplate.opsForValue().set("user", user);
		redisTemplate.expire("user", 5, TimeUnit.HOURS);
		
		String key1 = stringRedisTemplate.opsForValue().get("key1");
		System.out.println("============"+key1);
		
		User keyuser = (User)redisTemplate.opsForValue().get("user");
		System.out.println("============"+keyuser);*/

        try {
            ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
            //计数前打印
            System.out.println("###########################"+opsForValue.get("test1"));
            for (int i = 0; i < 100; i++) {
                //计数，第一个参数为key值，第二个参数为每次增加计数的单位
                opsForValue.increment("test1", 1);
            }
            //计数后打印
            System.out.println("========================="+opsForValue.get("test1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@Test
	@Rollback
	public void mogTest() throws Exception {
		User user = new User(5l, "张胜男", 24);
		// 保存字符串
		mongoTemplate.save(user);
		
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(5));
		User keyuser = mongoTemplate.findOne(query, User.class);
		System.out.println("============"+keyuser);
		
		//mongoTemplate.dropCollection(User.class);
		
		long count = userMongoRepository.count();
		User user1 = new User(2l, "lisi李四", 25);
		userMongoRepository.save(user1);
		User u = userMongoRepository.findOne(2L);
		System.out.println("============"+u);
		userMongoRepository.delete(u);
		
	}
}
