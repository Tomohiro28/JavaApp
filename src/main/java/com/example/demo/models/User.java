package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity//DBに登録、更新、保持

public class User {

  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)//主キーの自動生成(id)
  @Column(name="id")//カラムの指定
  private Integer id;
  
  
  @Column(name="nickname")
  private String nickname;
  
  @Column(name="age")
  private Integer age;
  
  @Column(name="hobby")
  private String hobby;

  	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "User [id="+ id +",nickname="+ nickname +",age="+ age +",hobby="+ hobby +"]";
	}
}
