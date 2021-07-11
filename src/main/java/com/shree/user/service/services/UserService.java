package com.shree.user.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shree.user.service.RestTemplateVO.Department;
import com.shree.user.service.RestTemplateVO.RestTemplateVo;
import com.shree.user.service.entity.User;
import com.shree.user.service.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RestTemplate restTemplate;
	
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
	public RestTemplateVo getUserWithDepartment(Long id) {
		RestTemplateVo restvo=new RestTemplateVo();
		
		User user=userRepository.getById(id);
		Department department = restTemplate.getForObject("http://localhost:9909/department/"+user.getDepartmentId(), Department.class);
		restvo.setDepartment(department);
		restvo.setUser(user);
		return restvo;
		
	}
	

}
