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
        
        //使用xml pull 解析器去解析xml文件的内容
        
        XmlPullParser pullParser = Xml.newPullParser();
        try {
			InputStream in = getAssets().open("result.xml");
			
			//解析的源是什么   result.xml
			pullParser.setInput(in, "gbk");
			
			//获得一个事件的类型
			int type = pullParser.getEventType();
			
			Product p = null;
			while (type!=XmlPullParser.END_DOCUMENT) {
				if(type==XmlPullParser.START_TAG){
					//判断是否是元素的开始，只要是某个元素的开始位置，那么就会进入这里
					//获得当前解析到的元素的名称
					if("product".equals(pullParser.getName())){
						p = new Product();
						//sax解析
						//准备product类的一个实例，去封装数据
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
