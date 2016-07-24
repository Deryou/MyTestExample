package com.ccut;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*
 * InetAddress类
 */
public class Test_01 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress adress = InetAddress.getLocalHost();
		System.out.println("主机名："+adress.getHostName());
		System.out.println("IP地址"+adress.getHostAddress());
		byte[] bytes = adress.getAddress();//获取字节数组形式的IP地址
		System.out.println("直接数组形式的IP"+Arrays.toString(bytes));
		System.out.println(adress);
	}
}
