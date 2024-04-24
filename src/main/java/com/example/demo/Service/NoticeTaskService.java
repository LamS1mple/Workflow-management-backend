package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Reponsitory.NoticeTaskReponsitory;
import com.example.demo.model.NoticeTask;

@Service
public class NoticeTaskService {

	@Autowired
	private NoticeTaskReponsitory noticeReponsitory;

	public NoticeTask saveNotice(NoticeTask notice) {
		return noticeReponsitory.save(notice);
	}

	public List<NoticeTask> getAllNotice(long id) {
		// TODO Auto-generated method stub
		
		return noticeReponsitory.getNoticeOfUser(id);
	}
	
	
}
