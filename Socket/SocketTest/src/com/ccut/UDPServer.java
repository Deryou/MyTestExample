package com.ccut;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * �������ˣ�ʵ�ֻ���UDP���û���¼
 */
public class UDPServer {

	public static void main(String[] args) throws IOException {
		/*
		 * ���տͻ��˵�����
		 */
		//������������DatagramSocket,ָ���˿�
		DatagramSocket socket = new DatagramSocket(8800);
		//�������ݱ������ڽ��տͻ��˷��͵���Ϣ
		byte[] data = new byte[1024];//�����ֽ����飬ָ������ �����ݰ��Ĵ�С
		DatagramPacket packet = new DatagramPacket(data,data.length);
		System.out.println("*******���������Ѿ�����******");
		//���տͻ��˷��͵�����
		socket.receive(packet);//�˷����ڽ��յ����ݱ�֮ǰ��һֱ����
		//��ȡ����
		String info = new String(data,0,packet.getLength());
		System.out.println("���Ƿ��������ͻ���˵��"+info);
		/*
		 * ��ͻ�����Ӧ����
		 */
		//����ͻ��˵ĵ�ַ���˿�����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ��".getBytes();
		//�������ݱ���������Ӧ��������Ϣ
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
		//��Ӧ�ͻ���
		socket.send(packet2);
		//�ر���Դ
		socket.close();
	}
}
