package com.nullcognition.databindingexamples.examples;// Created by ersin on 04/06/15

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;

import com.nullcognition.databindingexamples.BR;
import com.nullcognition.databindingexamples.R;
import com.nullcognition.databindingexamples.databinding.Example04Binding;

import java.util.Date;
import java.util.Random;

public class Example04{
	User user;
	Activity activity;
	public Example04(Activity activity){
		this.activity = activity;
		Example04Binding binding = DataBindingUtil.setContentView(activity, R.layout.example04);
		user = new User();
		binding.setUser(user);

		user.setFirstName("example04");
	}
	public void changeValues(){
		user.setFirstName(new Date().toString());
	}

	public static class User extends BaseObservable{
		private String firstName;
		@Bindable
		public String getFirstName(){return this.firstName;}

		public void setFirstName(String firstName){
			this.firstName = firstName;
			notifyPropertyChanged(BR.firstName); // sometimes does not generate
		}
	}

}
