package com.ccut;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ����TCPЭ���Socketͨ�ţ�ʵ�����û���¼
 * �����
 */
public class Server {

	public static void main(String[] args) {
		try {
			//1.����һ����������Socket����ServerSocket���ƶ��� �Ķ˿ڣ��������˶˿�
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			//��¼�ͻ��˵�����
			int count =0;
			System.out.println("***�������˼����������ȴ��ͻ��˵�����***");
			while(true){
				//2.����accept����������ʼ�������ȴ��ͻ��˵�����
				socket = serverSocket.accept();
				//����һ���µ��߳�
				ServerThread serverThread = new ServerThread(socket);
				//�����߳�
				serverThread.start();
				count++;//ͳ�ƿͻ��˵�����
				System.out.println("�ͻ��˵�������"+count);
				InetAddress address = socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP:"+address.getHostAddress());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
