package com.nullcognition.databindingexamples.examples;// Created by ersin on 04/06/15

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;

import com.nullcognition.databindingexamples.BR;
import com.nullcognition.databindingexamples.R;
import com.nullcognition.databindingexamples.databinding.Example04Binding;

import java.util.Date;

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
	public void changeValues(){user.setFirstName(new Date().toString());}

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

//
//collection syntax
//<data>
//<import type="android.databinding.ObservableMap"/>
//<variable name="user" type="ObservableMap&lt;String, Object>"/>
//</data>
//<TextView
//android:text='@{user["lastName"]}'
//		android:layout_width="wrap_content"
//		android:layout_height="wrap_content"/>
//<TextView
//android:text='@{String.valueOf(1 + (Integer)user["age"])}'
//		android:layout_width="wrap_content"
//		android:layout_height="wrap_content"/>
