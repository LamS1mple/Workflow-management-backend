package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Reponsitory.GroupReponsitory;
import com.example.demo.model.Group;

@Service
public class GroupService {

	@Autowired
	private GroupReponsitory groupReponsitory;
	
	public List<Group> getGroup(long idUser) {
		List<Group> list = groupReponsitory.getGroupOfUser(idUser);
		ArrayList<Group> list2 = new ArrayList<Group>();
		list.stream().forEach(item ->{
			item.getHostGroup().setImg(null);
			item.setListMembers(null);
			list2.add(item);
		});
		return list2;
	}

	public Group getGroupById(long id) {
		// TODO Auto-generated method stub
		Group group = groupReponsitory.findById(id).get();
		if (group.getPassZoom() == null || group.getPassZoom() == "") {
			UUID uuid = UUID.randomUUID();
			group.setPassZoom(uuid.toString());
			group = groupReponsitory.save(group);
		}
		group.getHostGroup().setImg(null);
		group.setListMembers(null);
		return group;
	}

	
}
