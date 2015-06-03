package com.nullcognition.databindingexamples.examples;// Created by ersin on 03/06/15

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableChar;
import android.databinding.ObservableField;

import com.nullcognition.databindingexamples.R;
import com.nullcognition.databindingexamples.databinding.Example03Binding;

import java.util.Date;
import java.util.Random;

public class Example03{
	User user;
	Activity activity;
	public Example03(Activity activity){
		this.activity = activity;
		Example03Binding binding = DataBindingUtil.setContentView(activity, R.layout.example03);
		user = new User();
		binding.setUser(user);

		user.firstName.set("example03");
		user.observableChar.set('a');
	}
	public void changeValues(){
		user.firstName.set(new Date().toString());
		user.observableChar.set((char) (new Random().nextInt(26) + 'a'));
	}


	public static class User{
		public final String changeValues = "Change Values";
		public final ObservableField<String> firstName = new ObservableField<>();
		public final ObservableChar observableChar = new ObservableChar();
	}
}
