package com.nullcognition.databindingexamples.examples;// Created by ersin on 03/06/15

import android.app.Activity;
import android.databinding.DataBindingUtil;

import com.nullcognition.databindingexamples.R;
import com.nullcognition.databindingexamples.databinding.Example02Binding;

public class Example02{
	User user;
	Activity activity;
	public Example02(Activity activity){
		this.activity = activity;
		Example02Binding binding = DataBindingUtil.setContentView(activity, R.layout.example02);
		user = new User("example02"); // toggle this to see the new color
		binding.setUser(user);
	}

	public static class User{
		private String firstName;
		public User(String firstName){this.firstName = firstName;}
		public String getFirstName(){ return firstName;}
		public void setFirstName(final String firstName){ this.firstName = firstName;}
	}

	public static class Capi{
		public static String talize(String input){return input.toUpperCase();}
	}
}
