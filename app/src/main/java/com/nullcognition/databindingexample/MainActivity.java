package com.nullcognition.databindingexample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nullcognition.databindingexample.databinding.ActivityMainImportBinding;
import com.nullcognition.databindingexample.databinding.ActivityMainLayoutNameBinding;
import com.nullcognition.databindingexample.model.User;
import com.nullcognition.databindingexample.model.UserWithGender;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main_layout_name); // not needed

		// binding data
//		bindData();
		bindDataWithGenderColorMatching();
	}
	private void bindDataWithGenderColorMatching(){

		// also uses static properties like color and static innerclass as a util to capitalize the input
		ActivityMainImportBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main_import);

		UserWithGender userWithGender = new UserWithGender(true); // toggle this to see blue/john and magenta/jane
		binding.setUserWithGender(userWithGender);
	}

	private void bindData(){
		// binding class is generated based on layout file's name
		ActivityMainLayoutNameBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main_layout_name);
		// required a clean due to error: cannot find symbol variable activity_main, referring to old layout name

		String firstName = "User firstName";
		String lastName = "User lastName";

		User user = new User(firstName, lastName);
		binding.setUser(user);
		// removing findViewById() or setText()
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		int id = item.getItemId();
		if(id == R.id.action_settings){return true;}
		return super.onOptionsItemSelected(item);
	}
}
