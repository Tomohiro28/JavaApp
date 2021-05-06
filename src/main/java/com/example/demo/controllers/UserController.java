package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	//メソッドの引数にModel型の値を設定,Modelのインスタンスが自動的に渡される
	public String index(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users",users);	
		return "users/index";
	}
	
	@GetMapping("new")
	public String newUser(Model model) {
		return "users/new";
	}
	
	@GetMapping("{id}/edit")
	//@PathVariableを設定するとURL上の値を取得
	public String edit(@PathVariable Integer id,Model model) {
		User user = userService.findOne(id);
		model.addAttribute("user",user);
		return "users/edit";
	}
	
	@GetMapping("{id}")
	public String show(@PathVariable Integer id,Model model) {
		User user = userService.findOne(id);
		model.addAttribute("user",user);
		return "users/show";
	}
	
	@PostMapping
	//@ModelAttributeをつけると送信されたリクエストのbodyの情報を取得できる
	public String create(@ModelAttribute User user) {
		userService.save(user);
		//createメソッドの処理が終わった後indexに戻る
		return "redirect:/users";
	}
	
	@PutMapping("{id}")
	public String Update(@PathVariable Integer id,@ModelAttribute User user) {
		user.setId(id);
		userService.save(user);
		return "redirect:/users";
	}
	
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Integer id) {
		userService.delete(id);
		return	"redirect:/users";
	}
}
