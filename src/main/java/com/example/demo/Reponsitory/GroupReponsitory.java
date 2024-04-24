package com.example.demo.Reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Group;

@Repository
public interface GroupReponsitory extends JpaRepository<Group, Long>{

	@Query(value =  "SELECT distinct  t.* FROM team t, group_member gm, user u "
			+ "where ((t.host_id = ?1 ) or( gm.user_id = u.id and gm.group_id = t.id  and u.id = ?1))", nativeQuery= true)
	List<Group> getGroupOfUser(long idUser);

}
