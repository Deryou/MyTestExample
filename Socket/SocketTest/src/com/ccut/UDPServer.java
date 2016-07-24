package com.ccut;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 服务器端，实现基于UDP的用户登录
 */
public class UDPServer {

	public static void main(String[] args) throws IOException {
		/*
		 * 接收客户端的数据
		 */
		//创建服务器端DatagramSocket,指定端口
		DatagramSocket socket = new DatagramSocket(8800);
		//创建数据报，用于接收客户端发送的消息
		byte[] data = new byte[1024];//创建字节数组，指定接收 的数据包的大小
		DatagramPacket packet = new DatagramPacket(data,data.length);
		System.out.println("*******服务器端已经启动******");
		//接收客户端发送的数据
		socket.receive(packet);//此方法在接收到数据报之前会一直阻塞
		//读取数据
		String info = new String(data,0,packet.getLength());
		System.out.println("我是服务器，客户端说："+info);
		/*
		 * 向客户端响应数据
		 */
		//定义客户端的地址，端口数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "欢迎您".getBytes();
		//创建数据报，包含响应的数据信息
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
		//响应客户端
		socket.send(packet2);
		//关闭资源
		socket.close();
	}
}
