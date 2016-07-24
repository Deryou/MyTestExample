package com.ccut;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*
 * �ͻ���
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		/*
		 * ��������˷�������
		 */
		//����������ĵ�ַ���˿ںš�����
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "�û�����admin�����룺123".getBytes();
		//�������ݱ����������� ������Ϣ
		DatagramPacket packet = new DatagramPacket(data, data.length, address,port);
		//����DatagramSocket����
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		
		/*
		 * ���շ���������Ӧ������
		 */
		//�������ݱ������ڽ��շ���������Ӧ������
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length);
		//���շ�������Ӧ������
		socket.receive(packet2);
		//��ȡ����
		String reply = new String(data2,0,packet2.getLength());
		System.out.println("���ǿͻ��ˣ�������˵��"+reply);
		//�ر���Դ
		socket.close();
	}
}
