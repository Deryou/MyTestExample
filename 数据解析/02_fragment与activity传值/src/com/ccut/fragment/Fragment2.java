package com.ccut.fragment;

import com.ccut.fratoact.MainActivity;
import com.ccut.fratoact.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment2 extends Fragment {

	private EditText et_fg2;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment2, null);
		et_fg2 = (EditText) view.findViewById(R.id.et_f2);
		Button bt = (Button) view.findViewById(R.id.bt);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String text = et_fg2.getText().toString();
				((MainActivity) getActivity()).setText(text);
			}
		});
		return view;
	}
//	public void click(View v){
//		String text = et_fg2.getText().toString();
//		((MainActivity) getActivity()).setText(text);
//	}
}
