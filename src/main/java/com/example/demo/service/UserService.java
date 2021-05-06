package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositries.UserRepository;
@Service
//サーバ処理を実装
public class UserService {

	@Autowired
	//Beanをインジェクトしてnewしなくても使える
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findOne(Integer id) {
		Optional<User> user = userRepository.findById(id);
		 if(user.isPresent()) {
		       return user.get();//get()で値を返す
		    }else {
		       return null;
		    }
//		return userRepository.findById(id);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void  delete(Integer id) {
		userRepository.deleteById(id);
	}
}
