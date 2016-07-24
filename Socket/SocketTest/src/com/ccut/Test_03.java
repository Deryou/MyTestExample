package com.ccut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * 使用URL读取页面内容
 */
public class Test_03 {

	public static void main(String[] args) {
		try {
			//创建一个URL实例
			URL url = new URL("http://www.baidu.com");
			//通过URL的openStream方法获取URL对象所表示的资源的字节输入流
			//此句与url.openConnection().getInputStream()相同
			InputStream is = url.openStream();
			//将字节输入流转换为字符输入流
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			//为字符输入流添加缓冲
			BufferedReader br = new BufferedReader(isr);
			//读取数据
			String data = br.readLine();
			//循环读取数据
			while(data!=null){
				System.out.println(data);
				data = br.readLine();
			}
			is.close();
			isr.close();
			br.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
