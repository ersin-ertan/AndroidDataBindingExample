package com.nullcognition.databindingexample;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nullcognition.databindingexample.databinding.ActivityMainImportBinding;
import com.nullcognition.databindingexample.databinding.ActivityMainLayoutNameBinding;
import com.nullcognition.databindingexample.databinding.ActivityMainObservableBinding;
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
//		dataObjectsObservables();
	}

	private void dataObjectsObservables(){
//		final User_ObservableObject user_observableObject = new User_ObservableObject();
//		ActivityMainObservableBinding activityMainObservableBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_observable);
//		activityMainObservableBinding.setUserObservableObject(user_observableObject);
//
//		user_observableObject.firstName = "Google";
//		user_observableObject.setLastName("Test");
//		String lastName = user_observableObject.getLastName();
//		Toast.makeText(MainActivity.this, lastName, Toast.LENGTH_SHORT).show();
//

		// --------------------------------------------------

//		// setting the observable field
//		final User_ObservableField user_observableField = new User_ObservableField();
//		activityMainObservableBinding.setUserObservableField(user_observableField);
//		user_observableField.firstName.set("field set first name");
//		user_observableField.lastName.set("field set last name");
////		user_observableField.numericalValue.set("numerical default");
//
//		Button button = (Button) findViewById(R.id.button3);
//		button.setOnClickListener(new View.OnClickListener(){
//			int i = 0;
//
//			@Override
//			public void onClick(final View v){
//				user_observableObject.setLastName("Button press event update" + ++i);
////				user_observableField.age.set(i);
//			}
//		});
//
//		user_observableField.age.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback(){
//			@Override
//			public void onPropertyChanged(final Observable sender, final int propertyId){
//				Toast.makeText(MainActivity.this, "sender observable:"+ sender.toString() + "\npropertyid:"+propertyId, Toast.LENGTH_SHORT).show();
//			}
//		});
	}

	public static class User_ObservableField extends BaseObservable{
		public final ObservableField<String> firstName = new ObservableField<>();
		public final ObservableField<String> lastName = new ObservableField<>(); // only last and first name
		// work which means that some other configuration of ObservableField<> is overriding a should not have been initialization

		// which is why any other type or variable name won't work
//		public final ObservableField<String> numericalValue = new ObservableField<>();
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

//	public static class User_ObservableObject extends BaseObservable{
//
//		private String firstName;
//		private String lastName;
//		// BR class is generated in the module package
//		// annotation generates an entry in the BR class file during compilation
//
//		@Bindable
//		public String getFirstName(){ return this.firstName;}
//
//		@Bindable
//		public String getLastName(){return this.lastName;} // submitted bug report for error in documentation
//		// of repeated method name getFirstName()
//
//		public void setFirstName(String firstName){
//			this.firstName = firstName;
//			notifyPropertyChanged(BR.firstName);
//		}
//		public void setLastName(String lastName){
//			this.lastName = lastName;
//			notifyPropertyChanged(BR.lastName);
//		}
//	}

}

