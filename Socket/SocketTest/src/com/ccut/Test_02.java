package com.ccut;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL常用方法
 */
public class Test_02 {

	public static void main(String[] args) {
		try {
			//创建一个URL实例
			URL ccut = new URL("http://www.imooc.com");
			//?后面为参数   #后面为锚点
			URL url = new URL(ccut,"/index.html?username=tom#test");
			System.out.println("协议"+url.getProtocol());
			System.out.println("主机"+url.getHost());
			System.out.println("端口"+url.getPort());
			System.out.println("文件路径"+url.getPath());
			System.out.println("文件名"+url.getFile());
			System.out.println("相对路径"+url.getRef());
			System.out.println("查询字符串"+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
