package com.ccut.fragment;


import com.ccut.fratoact.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment1 extends Fragment {

	private TextView tv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment1, null);
		tv = (TextView) view.findViewById(R.id.et_f1);
		return view;
	}
	
	public void setText(String text){
		tv.setText(text);
	}
}
