package com.ccut;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * URL���÷���
 */
public class Test_02 {

	public static void main(String[] args) {
		try {
			//����һ��URLʵ��
			URL ccut = new URL("http://www.imooc.com");
			//?����Ϊ����   #����Ϊê��
			URL url = new URL(ccut,"/index.html?username=tom#test");
			System.out.println("Э��"+url.getProtocol());
			System.out.println("����"+url.getHost());
			System.out.println("�˿�"+url.getPort());
			System.out.println("�ļ�·��"+url.getPath());
			System.out.println("�ļ���"+url.getFile());
			System.out.println("���·��"+url.getRef());
			System.out.println("��ѯ�ַ���"+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
