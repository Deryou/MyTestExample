package com.ccut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * ʹ��URL��ȡҳ������
 */
public class Test_03 {

	public static void main(String[] args) {
		try {
			//����һ��URLʵ��
			URL url = new URL("http://www.baidu.com");
			//ͨ��URL��openStream������ȡURL��������ʾ����Դ���ֽ�������
			//�˾���url.openConnection().getInputStream()��ͬ
			InputStream is = url.openStream();
			//���ֽ�������ת��Ϊ�ַ�������
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			//Ϊ�ַ���������ӻ���
			BufferedReader br = new BufferedReader(isr);
			//��ȡ����
			String data = br.readLine();
			//ѭ����ȡ����
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
