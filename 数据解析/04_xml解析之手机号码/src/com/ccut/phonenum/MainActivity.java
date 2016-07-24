package com.ccut.phonenum;

import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Xml;

import com.ccut.phonenum.domain.Product;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //ʹ��xml pull ������ȥ����xml�ļ�������
        
        XmlPullParser pullParser = Xml.newPullParser();
        try {
			InputStream in = getAssets().open("result.xml");
			
			//������Դ��ʲô   result.xml
			pullParser.setInput(in, "gbk");
			
			//���һ���¼�������
			int type = pullParser.getEventType();
			
			Product p = null;
			while (type!=XmlPullParser.END_DOCUMENT) {
				if(type==XmlPullParser.START_TAG){
					//�ж��Ƿ���Ԫ�صĿ�ʼ��ֻҪ��ĳ��Ԫ�صĿ�ʼλ�ã���ô�ͻ��������
					//��õ�ǰ��������Ԫ�ص�����
					if("product".equals(pullParser.getName())){
						p = new Product();
						//sax����
						//׼��product���һ��ʵ����ȥ��װ����
						String tp = pullParser.getAttributeValue(0);
						p.setType(tp);
					} else if("phonenum".equals(pullParser.getName())){
						String phonenum = pullParser.nextText();
						p.setPhonenum(phonenum);
					} else if("location".equals(pullParser.getName())){
						String location = pullParser.nextText();
						p.setPhonenum(location);
					} else if("phoneJx".equals(pullParser.getName())){
						String phoneJx = pullParser.nextText();
						p.setPhoneJx(phoneJx);
					}
					type = pullParser.next();
				}
				if(p!=null){
					System.out.println(p.toString());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

}
