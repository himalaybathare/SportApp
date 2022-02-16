package com.dbproject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
 
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long age;
    private String created_at;
    private String updated_at;
    private Long team_id;
     
   

	public Player(Long id, String name, Long age, String created_at, String updated_at, Long team_id) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.team_id = team_id;
	}


	protected Player() {
    }
 
 
    // getters and setters are hidden for brevity
	
 

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getAge() {
		return age;
	}


	public void setAge(Long age) {
		this.age = age;
	}


	public String getCreated_at() {
		return created_at;
	}


	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}


	public String getUpdated_at() {
		return updated_at;
	}


	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}


	public Long getTeam_id() {
		return team_id;
	}


	public void setTeam_id(Long team_id) {
		this.team_id = team_id;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", age=" + age + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", team_id=" + team_id + "]";
	}


  
}
