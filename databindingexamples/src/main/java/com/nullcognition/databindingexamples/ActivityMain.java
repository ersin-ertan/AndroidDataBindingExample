package com.nullcognition.databindingexamples;

import android.app.Activity;
import android.os.Bundle;

import com.nullcognition.databindingexamples.examples.Example01;
import com.nullcognition.databindingexamples.examples.Example02;
import com.nullcognition.databindingexamples.examples.Example03;
import com.nullcognition.databindingexamples.examples.Example04;

public class ActivityMain extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

//		ex01();
//		ex02();
//		ex03();
//		ex04();

//		show: Collections syntax in example04.xml,  BaseObserver class

	}
	private void ex04(){
		final Example04 example04 = new Example04(this);

		new Thread(new Runnable(){
			@Override
			public void run(){
				try{ Thread.sleep(1000);}
				catch(InterruptedException e){e.printStackTrace();}
				for(int i = 0; i < 5; i++){
					try{ Thread.sleep(1000);}
					catch(InterruptedException e){e.printStackTrace();}
					example04.changeValues();
				}
			}
		}).start();
	}
	private void ex03(){
		final Example03 example03 = new Example03(this);

		new Thread(new Runnable(){
			@Override
			public void run(){
				try{ Thread.sleep(1000);}
				catch(InterruptedException e){e.printStackTrace();}
				for(int i = 0; i < 5; i++){
					try{ Thread.sleep(1000);}
					catch(InterruptedException e){e.printStackTrace();}
					example03.changeValues();
				}
			}
		}).start();
	}
	private void ex02(){Example02 example02 = new Example02(this);}
	private void ex01(){Example01 example01 = new Example01(this);}

}

