package com.example.demo.repository;

import com.example.demo.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by xing on 2017/6/16.
 */
public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("select u.id,u.name,u.age from User u where u.name=:name")
    User findUser(@Param("name") String name);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.name =:name where u.id =:id")
    int updateUser(@Param("name")String name, @Param("id")Long id);

    //原生sql语句
    @Query(value="SELECT * FROM t_user t WHERE t.age >?1",nativeQuery=true)
    List<User> findUserByAge(Integer age);

    /**
     * 原生sql分页语句
     * ORDER BY ?#{#pageable}
     * ORDER BY a.id \n#pageable\n
     * @param age
     * @param pageable
     * @return
     */
    @Query(value="SELECT * FROM t_user t WHERE t.age >?1 ORDER BY ?#{#pageable}",
            countQuery="SELECT count(*) FROM t_user t WHERE t.age >?1",
            nativeQuery=true)
    Page<User> findUserPage(Integer age, Pageable pageable);

}
