package com.nullcognition.databindingexample.model;// Created by ersin on 01/06/15

public class UserWithGender{

	public boolean isMale;

	public static final String male = "John";
	public static final String female = "Jane";

	public UserWithGender(boolean isMale){
		this.isMale = isMale;
	}

	public static class Capitalizer{

		public static String capitalize(String inputString){
			return inputString.toUpperCase();
		}
	}

}
