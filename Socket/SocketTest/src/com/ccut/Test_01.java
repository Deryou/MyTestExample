package com.ccut;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*
 * InetAddress��
 */
public class Test_01 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress adress = InetAddress.getLocalHost();
		System.out.println("��������"+adress.getHostName());
		System.out.println("IP��ַ"+adress.getHostAddress());
		byte[] bytes = adress.getAddress();//��ȡ�ֽ�������ʽ��IP��ַ
		System.out.println("ֱ��������ʽ��IP"+Arrays.toString(bytes));
		System.out.println(adress);
	}
}
