package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 private String name;
	 private int age;
	 private String email;
	 private String password;
	 private long mobile;
	 @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
	 private List<Notes> notesList;
	 
			
	}

