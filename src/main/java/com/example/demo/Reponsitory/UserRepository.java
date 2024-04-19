package com.example.demo.Reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value = "select id, img, name, pass_word, user_name from user where user_name = ?1"
			, nativeQuery = true)
	User findByUserNameAndPassWord(String userName, String passWord);

}
