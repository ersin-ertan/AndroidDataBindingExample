//package com.nullcognition.databindingexample.model;// Created by ersin on 01/06/15
// creating class did not work
//
//import android.databinding.BaseObservable;
//import android.databinding.Bindable;
//
//public class User02 extends BaseObservable{
//
//	private String firstName;
//	private String lastName;
//	// BR class is generated in the module package
//	// annotation generates an entry in the BR class file during compilation
//
//	@Bindable
//	public String getFirstName(){ return this.firstName;}
//
//	@Bindable
//	public String getLastName(){return this.lastName;} // submitted bug report for error in documentation
//
//	public void setFirstName(String firstName){
//		this.firstName = firstName;
//		notifyPropertyChanged(BR.firstName);
//	}
//	public void setLastName(String lastName){
//		this.lastName = lastName;
//		notifyPropertyChanged(BR.lastName);
//	}
//}
