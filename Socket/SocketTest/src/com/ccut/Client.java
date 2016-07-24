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
 * ����TCPЭ���Socketͨ�ţ�ʵ�����û���¼
 * �ͻ��˶�
 */
public class Client {

	public static void main(String[] args) {
		try {
			//�����ͻ���Socket��ָ����������ַ�Ͷ˿�
			Socket socket = new Socket("localhost",8888);
			//��ȡ����������������˷�����Ϣ
			OutputStream os = socket.getOutputStream();//�ֽ������
			PrintWriter pw = new PrintWriter(os);
			pw.write("�û�����tom;���룺123");
			pw.flush();
			socket.shutdownOutput();//�ر������
			
			//��ȡ������������ȡ�������˵���Ӧ��Ϣ
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("���ǿͻ��ˣ���������˵��"+info);
			}
			
			//�ر���Դ
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
