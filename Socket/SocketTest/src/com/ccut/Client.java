package com.ccut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 基于TCP协议的Socket通信，实现用用户登录
 * 客户端端
 */
public class Client {

	public static void main(String[] args) {
		try {
			//创建客户端Socket，指定服务器地址和端口
			Socket socket = new Socket("localhost",8888);
			//获取输入流，向服务器端发送信息
			OutputStream os = socket.getOutputStream();//字节输出流
			PrintWriter pw = new PrintWriter(os);
			pw.write("用户名：tom;密码：123");
			pw.flush();
			socket.shutdownOutput();//关闭输出流
			
			//获取输入流，并读取服务器端的响应信息
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("我是客户端，服务器端说："+info);
			}
			
			//关闭资源
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
