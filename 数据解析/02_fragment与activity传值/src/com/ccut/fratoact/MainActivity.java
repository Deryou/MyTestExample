package com.ccut.fratoact;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.ccut.fragment.Fragment1;
import com.ccut.fragment.Fragment2;

public class MainActivity extends FragmentActivity {

    private Fragment1 fg1;
	private EditText et;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fg1 = new Fragment1();
		et = (EditText) findViewById(R.id.et_main);
		
        FragmentManager fm = getSupportFragmentManager();
    	FragmentTransaction ft = fm.beginTransaction();
    	ft.replace(R.id.fl, fg1);
    	ft.commit();
    }

    public void click1(View v){
    	FragmentManager fm = getSupportFragmentManager();
    	FragmentTransaction ft = fm.beginTransaction();
    	ft.replace(R.id.fl, fg1);
    	ft.commit();
    	
    }
    public void click2(View v){
    	Fragment2 fg2 = new Fragment2();
    	FragmentManager fm = getSupportFragmentManager();
    	FragmentTransaction ft = fm.beginTransaction();
    	ft.replace(R.id.fl, fg2);
    	ft.commit();
    }
    
    public void click3(View v){
    	String text = et.getText().toString();
    	fg1.setText(text);
    }
    
    public void setText(String text){
    	et.setText(text);
    }
}
