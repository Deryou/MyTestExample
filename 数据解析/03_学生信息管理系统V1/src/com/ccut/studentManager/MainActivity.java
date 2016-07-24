package com.ccut.studentManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Xml;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	

    private EditText ed_ssname;
	private EditText ed_ssnumber;
	private RadioGroup rgb;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ed_ssname = (EditText) findViewById(R.id.stname_et);
        ed_ssnumber = (EditText) findViewById(R.id.stnumber_et);
        rgb = (RadioGroup) findViewById(R.id.radiogb);
    }

	public void save(View v){
		String studentName = ed_ssname.getText().toString().trim();
		String studentNumber = ed_ssnumber.getText().toString().trim();
		
		if(TextUtils.isEmpty(studentNumber) || TextUtils.isEmpty(studentName)){
			Toast.makeText(getApplicationContext(), "ѧ����������ѧ�Ų���Ϊ��", Toast.LENGTH_LONG).show();
			return;
		}
		
		//���ѧ���Ա�
		int id = rgb.getCheckedRadioButtonId();
		String sex = "��";
		if(id==R.id.male){
			sex="��";
		}else if(id==R.id.female){
			sex="Ů";
		}
		
		//��������Ϣ��������
		try {
			File file = new File(getFilesDir(),studentName+".xml");
			OutputStream out = new FileOutputStream(file);
			/*StringBuilder sb = new StringBuilder();
			sb.append("<?xml version='1.0' encoding='utf-8'?>");
			sb.append("<student>");
			sb.append("<name>");
			sb.append(studentName);
			sb.append("</name>");
			sb.append("<number>");
			sb.append(studentNumber);
			sb.append("</number>");
			sb.append("<sex>");
			sb.append(sex);
			sb.append("</sex>");
			sb.append("</student>");
			
			OutputStream out = new FileOutputStream(file);
			
			out.write(sb.toString().getBytes());*/
			//ר������xml�ļ������л���
			XmlSerializer serializer = Xml.newSerializer();
			serializer.setOutput(out, "UTF-8");
			
			serializer.startDocument("UTF-8", true);
			
			serializer.startTag(null, "student");
			serializer.startTag(null, "name");
			serializer.text(studentName);
			serializer.endTag(null, "name");
			
			serializer.startTag(null, "number");
			serializer.text(studentName);
			serializer.endTag(null, "number");
			
			serializer.startTag(null, "sex");
			serializer.text(studentName);
			serializer.endTag(null, "sex");
			serializer.endTag(null, "student");
			serializer.endDocument();
			
			out.close();
			
			Toast.makeText(this, "����"+studentName+"��Ϣ�ɹ���������", Toast.LENGTH_LONG).show();
			
			XmlPullParser newPullParser = Xml.newPullParser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(this, "����"+studentName+"��Ϣʧ�ܡ�������", Toast.LENGTH_LONG).show();
		}
		
	}
}
