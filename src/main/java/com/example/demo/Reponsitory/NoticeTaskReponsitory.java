package com.example.demo.Reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NoticeTask;

@Repository
public interface NoticeTaskReponsitory extends JpaRepository<NoticeTask, Long>{

	@Query(value  = "SELECT n.* from notice n, task_member t, user u where n.taskmember_id = t.id and t.user_id = u.id and u.id = ?1"
			, nativeQuery = true)
	List<NoticeTask> getNoticeOfUser(long id);

//	List<Notice> getNoticeOfUser(long id);

}
