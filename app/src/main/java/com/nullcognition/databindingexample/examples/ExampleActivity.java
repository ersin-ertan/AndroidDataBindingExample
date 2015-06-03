package com.nullcognition.databindingexample.examples;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nullcognition.databindingexample.R;
import com.nullcognition.databindingexample.databinding.Example01LayoutVariableBindBinding;
import com.nullcognition.databindingexample.databinding.Example02ImportMethodBinding;
import com.nullcognition.databindingexample.databinding.Example03DataobjectObservableBinding;
import com.nullcognition.databindingexample.examples.model.User;

// show the project dependencies, and the app module plugin

/* be sure to have the launcher action/category set for this activity in the manifest
*  <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
   </intent-filter>
* */

public class ExampleActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		// setContentView(R.layout.example01_layout_variable_bind); // not needed

//		layoutAndVariableBinding();
//		importAndStaticMethodCalls();
//		dataObjectsAndBaseObservable();

	}
	private void layoutAndVariableBinding(){
		// class is generated
		Example01LayoutVariableBindBinding binding = DataBindingUtil.setContentView(this, R.layout.example01_layout_variable_bind);

		User.FirstLastName userFL = new User.FirstLastName("Johnnie", "Walker");

		// method is generated to bind to the user variable
		binding.setUserFL(userFL);
	}

	User.Gender userG = new User.Gender(false); // show example of button switching field value
	private void importAndStaticMethodCalls(){
		Example02ImportMethodBinding binding = DataBindingUtil.setContentView(this, R.layout.example02_import_method);
		binding.setUserG(userG);
	}

	public void switchGender(final View v){
		Toast.makeText(ExampleActivity.this, "gender switched", Toast.LENGTH_SHORT).show();
		userG.setMale(true);
	}


	private int date = 420;
	private void dataObjectsAndBaseObservable(){
		Example03DataobjectObservableBinding binding = DataBindingUtil.setContentView(this, R.layout.example03_dataobject_observable);
		User.DataFieldObservable userDFO = new User.DataFieldObservable();

		binding.setUserDFO(userDFO);

		userDFO.firstName.set("Jack");
		userDFO.lastName.set("Herer");
		userDFO.age.set(date);

	}

	public void incBoundVariable(final View v){
		//Toast.makeText(ExampleActivity.this, "date pre-change:" + userDFO.age.get(), Toast.LENGTH_SHORT).show();
		++date;
		//userDFO.age.set(++date);
	}


}
