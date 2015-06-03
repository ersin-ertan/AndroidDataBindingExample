package com.nullcognition.databindingexample.examples.model;// Created by ersin on 02/06/15

// java beans also work

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.nullcognition.databindingexample.BR;

public class User{

	// --------------------------------------------------
	public static class FirstLastName{

		public final String firstName;
		public final String lastName;

		public FirstLastName(String firstName, String lastName){

			this.firstName = firstName;
			this.lastName = lastName;
		}
	}

	// --------------------------------------------------
	public static class Gender{

		public static final String jane = "jane";
		private boolean isMale;

		public Gender(boolean isMale){
			this.isMale = isMale;
		}
		public boolean getMale(){return isMale;}
		public void setMale(boolean input){isMale = input;}
	}

	public static class MyTextUtil{
		public static String toUpper(String input){ return input.toUpperCase();}
	}

	// --------------------------------------------------
	public static class DataFieldObservable extends BaseObservable{
		public final ObservableField<String> firstName = new ObservableField<>();
		public final ObservableField<String> lastName = new ObservableField<>();
		public final ObservableInt age = new ObservableInt();

		public int getAgeInt(){return age.get();} // requires String.valueOf() from within the layout
		public String getAgeString(){return String.valueOf(age.get());}
	}
	// Observable field can do direct access in the layout file
	// Observable primitive requires .get()
	// Observable primitives and collections

	// --------------------------------------------------
	public static class DataObjectObservable extends BaseObservable{
		private String firstName;
		private String lastName;
		private int age;
		@Bindable
		public String getFirstName(){ return this.firstName;}
		@Bindable
		public String getLastName(){ return this.lastName;}
		@Bindable
		public int getAge(){return this.age;}
		public void setFirstName(String firstName){
			this.firstName = firstName;
			notifyPropertyChanged(BR.firstName); // sometimes this works/sometimes it doesn't
		}
		public void setLastName(String lastName){
			this.lastName = lastName;
			notifyPropertyChanged(BR.lastName);
		}
		public void setAge(int age){
			this.age = age;
			notifyPropertyChanged(BR.age);
		}
	}

}
