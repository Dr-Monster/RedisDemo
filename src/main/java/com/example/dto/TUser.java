package com.example.dto;
import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class TUser implements Serializable {

	/****/
	private Integer id;

	/****/
	private String name;

	/****/
	private Integer age;

	/****/
	private String gender;



	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setAge(Integer age){
		this.age = age;
	}

	public Integer getAge(){
		return this.age;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return this.gender;
	}

}
