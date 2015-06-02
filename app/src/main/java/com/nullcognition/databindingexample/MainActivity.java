package com.nullcognition.databindingexample;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nullcognition.databindingexample.databinding.ActivityMainImportBinding;
import com.nullcognition.databindingexample.databinding.ActivityMainLayoutNameBinding;
import com.nullcognition.databindingexample.databinding.CustomDataBindingName;
import com.nullcognition.databindingexample.model.User;
import com.nullcognition.databindingexample.model.UserWithGender;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main_layout_name); // not needed

		// binding data
//		bindData();
//		bindDataWithGenderColorMatching();
//		customBind();
		dataObjectsObservables();
	}
	private void dataObjectsObservables(){


		User_ObservableField user_observableField = new User_ObservableField();
		binding.setUser(user_observableField);

	}

	private static class User_ObservableField extends BaseObservable{
		public final ObservableField<String> firstName = new ObservableField<>();
		public final ObservableField<String> lastName = new ObservableField<>();
		public final ObservableInt age = new ObservableInt();
	}

	public void accessObservableField(){

		user_observableField.firstName.set("Google");
		int age = user_observableField.age.get();
		Toast.makeText(MainActivity.this, age, Toast.LENGTH_SHORT).show();
	}

	private void customBind(){

		CustomDataBindingName customDataBindingName = DataBindingUtil.setContentView(this, R.layout.activity_main_custom_bind);
		User user = new User("Included firstName", "wont be seen");
		customDataBindingName.setUser(user);

	}
	final UserWithGender userWithGender = new UserWithGender(true); // toggle this to see blue/john and magenta/jane
	ActivityMainImportBinding binding;

	private void bindDataWithGenderColorMatching(){

		// also uses static properties like color and static innerclass as a util to capitalize the input

		binding = DataBindingUtil.setContentView(this, R.layout.activity_main_import);
		binding.setUserWithGender(userWithGender);

		Button b = (Button) findViewById(R.id.button);
		b.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(final View v){
				userWithGender.switchGender();
				binding.setUserWithGender(userWithGender);

			}
		});
	}

	public void onClick(final View v){
		userWithGender.switchGender();
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

	private static class User_ObservableObject extends BaseObservable{

		private String firstName;
		private String lastName;
		// BR class is generated in the module package
		// annotation generates an entry in the BR class file during compilation

		@Bindable
		public String getFirstName(){ return this.firstName;}

		@Bindable
		public String getLastName(){return this.lastName;} // submitted bug report for error in documentation
		// of repeated method name getFirstName()

		public void setFirstName(String firstName){
			this.firstName = firstName;
			notifyPropertyChanged(BR.firstName);
		}
		public void setLastName(String lastName){
			this.lastName = lastName;
			notifyPropertyChanged(BR.lastName);
		}
	}

}

