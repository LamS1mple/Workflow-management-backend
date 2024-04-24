package com.example.demo.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Reponsitory.DetailTaskMemberReponsitory;
import com.example.demo.Reponsitory.TaskMemberRepository;
import com.example.demo.Reponsitory.TaskReponsitory;
import com.example.demo.dto.request.TaskMemberRequest;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.model.DetailTaskMember;
import com.example.demo.model.Task;
import com.example.demo.model.TaskMember;
import com.example.demo.model.User;

@Service
public class TaskMemberService {

	@Autowired
	private TaskMemberRepository taskMemberRepository;
	
	@Autowired
	private DetailTaskMemberReponsitory detailTaskMemberReponsitory;
	
	@Autowired
	private TaskReponsitory taskReponsitory;
	
	public List<TaskMember> findTaskByUser(User user){
		List<TaskMember> listTaskMembers = taskMemberRepository.findByUser(user);
		if (listTaskMembers == null) throw new NullPointerException("Current, You have not task");
		return listTaskMembers;
	}

	public ApiResponse getAllTaskOfUser(long idUser, boolean check) {
		User user = new User();
		user.setId(idUser);
		List<TaskMember> list = taskMemberRepository.findByUserAndIsFinish(user, check);
		ApiResponse apiResponse = ApiResponse.builder().code(1000).result(list).build();
		return apiResponse; 
	}

	public ApiResponse getTaskAhead(long id) {
		User user = new User();
		user.setId(id);
		System.out.println(new Date());
		List<TaskMember> taskMembers = taskMemberRepository.findByUserAndDateFinishAfter(user, new Date() );
		ApiResponse apiResponse = ApiResponse.builder().code(1000).result(taskMembers).build();
		return apiResponse;
	}

	public ApiResponse getTaskAfter(long id) {
		User user = new User();
		user.setId(id);
		List<TaskMember> taskMembers = taskMemberRepository.findByUserAndDateFinishBefore(user, new Date() );
		ApiResponse apiResponse = ApiResponse.builder().code(1000).result(taskMembers).build();
		return apiResponse;
	}

	public ApiResponse saveTaskmember(TaskMemberRequest taskMember) {
		// TODO Auto-generated method stub
		Task task =  taskReponsitory.save(taskMember.getTask());
		task.setPostDate(new Date());
		System.out.println(taskMember.toString());
		TaskMember taskMember2 = TaskMember.builder().contentTask(taskMember.getContentTask())
				.dateFinish(taskMember.getDateFinish())
				.task(task)
				.user(taskMember.getUser())
				.build();
		TaskMember taskMember3 =  taskMemberRepository.save(taskMember2);
		
		taskMember.getListDetalDetailTaskMember().stream().forEach(item ->{
			item.setTaskMember(taskMember3);
			detailTaskMemberReponsitory.save(item);
		});
		ApiResponse apiResponse = new ApiResponse();
		
		
		return apiResponse;
	}
	
	public void updateTaskMember(TaskMember taskMember) {
		
//        taskReponsitory.save(taskMember.getTask());
		List<DetailTaskMember> list = taskMember.getListDetalDetailTaskMember();
		

//	    taskMember.getListDetalDetailTaskMember().stream().forEach(item -> {
//	        DetailTaskMember detailTaskMember = detailTaskMemberReponsitory.findById(item.getId()).orElse(null);
//	        if (detailTaskMember != null) {
//	            detailTaskMember.setDateFinish(item.getDateFinish());
//	            detailTaskMember.setTitleTask(item.getTitleTask());
//	            detailTaskMember.setContentTask(item.getContentTask());
//	            detailTaskMember.setTaskMember(savedTaskMember);
//	            detailTaskMemberReponsitory.save(detailTaskMember);
//	        }else {
//	        	System.out.println(item.toString());
//	        	
//	        	item.setTaskMember(savedTaskMember);
//	            detailTaskMemberReponsitory.save(item);
//	        }
//	    });
	    
	}

	public TaskMember getTaskId(long id) {
		TaskMember taskMember = taskMemberRepository.findById(id).get();
		taskMember.getTask().setGroup(null);
		return taskMember;
	}

	public void deleteDetail(long id) {
		detailTaskMemberReponsitory.deleteById(id);
		
	}

	public void saveUpdateTask(TaskMember taskMember) {
		System.out.println(taskMember.toString());
		// TODO Auto-generated method stub
		for (DetailTaskMember i : taskMember.getListDetalDetailTaskMember()) {
	    	System.out.println(i.toString());
	    	TaskMember taskMember3 = TaskMember.builder().id(taskMember.getId()).build();
	    	i.setTaskMember(taskMember3);
            detailTaskMemberReponsitory.save(i);
	    }
		try {
			TaskMember taskMember2 = taskMemberRepository.findById( taskMember.getId() ).get();
			if (taskMember2 == null) {
				System.out.println("null");
			}
			
			taskMember2.setContentTask(taskMember.getContentTask());
			taskMember2.setDateFinish(taskMember.getDateFinish());
			taskMember2.setListDetalDetailTaskMember(taskMember.getListDetalDetailTaskMember());
			Task task = taskMember2.getTask();
			task.setTitle(taskMember.getTask().getTitle());
			taskMember2.setTask(task);
			
		    TaskMember savedTaskMember = taskMemberRepository.save(taskMember2);
		    
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}

	
}
