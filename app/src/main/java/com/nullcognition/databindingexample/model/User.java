package com.nullcognition.databindingexample.model;// Created by ersin on 31/05/15

// the data object

public class User{

	public final String firstName; // public vs private with getters both work POJO vs Java Beans
	public final String lastName; // @{user.lastName} direct variable access or with public getter method
	// based on variable access scope, this is a property reference

	public User(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

// or

class User01{

	private final String firstName;
	private final String lastName;

	public User01(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName(){return firstName;}
	public String getLastName(){return lastName;}
}
