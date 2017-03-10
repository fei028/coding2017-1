package com.codersing.download;

import java.io.IOException;

import com.codersing.download.api.Connection;

public class DownloadThread extends Thread{

	Connection conn;
	int startPos;
	int endPos;

	public DownloadThread(Connection conn, int startPos, int endPos){
		
		this.conn = conn;		
		this.startPos = startPos;
		this.endPos = endPos;
	}
	public void run(){	
		try {
			byte[] b = conn.read(startPos, endPos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
