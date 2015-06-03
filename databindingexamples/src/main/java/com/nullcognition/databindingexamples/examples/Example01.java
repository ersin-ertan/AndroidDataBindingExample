package com.nullcognition.databindingexamples.examples;// Created by ersin on 03/06/15

import android.app.Activity;
import android.databinding.DataBindingUtil;

import com.nullcognition.databindingexamples.R;
import com.nullcognition.databindingexamples.databinding.Example01Binding;

public class Example01{
	User user;
	Activity activity;
	public Example01(Activity activity){
		this.activity = activity;
		Example01Binding binding = DataBindingUtil.setContentView(activity, R.layout.example01);
		user = new User("example01");
		binding.setUser(user);
	}

	public static class User{
		private String firstName;
		public User(String firstName){this.firstName = firstName;}
		public String getFirstName(){ return firstName;}
		public void setFirstName(final String firstName){ this.firstName = firstName;}
	}
}
