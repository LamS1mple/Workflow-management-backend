package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.NoticeTaskService;
import com.example.demo.model.NoticeTask;


@RestController
@CrossOrigin(value = "*")
public class NoticeController {
	
	@Autowired
	private NoticeTaskService noticeService;
	
	@PostMapping("/notice/save-notice")
	public NoticeTask saveNotice(@RequestBody NoticeTask notice) {
		return noticeService.saveNotice(notice);
	}
	
	@GetMapping("/notice/get-notice-{id}")
	public List<NoticeTask> getAllNotices(@PathVariable("id")long id){
		return noticeService.getAllNotice(id);
	}
	
}
