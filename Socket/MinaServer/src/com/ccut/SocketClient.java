package com.ccut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) {
		SocketClient client = new SocketClient();
		client.start();
	}

	public void start() {
		BufferedReader inputReader = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9898);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			inputReader = new BufferedReader(new InputStreamReader(System.in));
			startServerReplyListener(reader);
			String inputContent;
			int count = 0;
			while(!(inputContent = inputReader.readLine()).equals("bye")){
				writer.write(inputContent);
				if(count % 2 ==0){
					writer.write("\n");
				}
				count++;
				writer.flush();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				reader.close();
				writer.close();
				inputReader.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void startServerReplyListener(final BufferedReader reader){
		new Thread(new Runnable(){

			@Override
			public void run() {
				String response;
				try {
					while((response = reader.readLine())!=null){
						System.out.println(response);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}).start();
	}
}
