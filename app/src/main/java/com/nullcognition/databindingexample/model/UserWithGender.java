package com.nullcognition.databindingexample.model;// Created by ersin on 01/06/15

import android.view.View;

public class UserWithGender{

	public static boolean isMale = true;

	public static final String male = "John";
	public static final String female = "Jane";

	public UserWithGender(boolean isMale){
		this.isMale = isMale;
	}

	public static void switchGender(){
		isMale = !isMale;
	}

	public static class Capitalizer{

		public static String capitalize(String inputString){
			return inputString.toUpperCase();
		}

	}


}
