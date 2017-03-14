package com.codersing.download;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.codersing.download.api.Connection;

public class DownloadThread extends Thread{

	Connection conn;
	long startPos;
	long endPos;
	
	private RandomAccessFile destFile;//下载的目标文件

	public DownloadThread(Connection conn, long startPos, long endPos, String destFile){
		
		this.conn = conn;		
		this.startPos = startPos;
		this.endPos = endPos;
		try {
			this.destFile = new RandomAccessFile(destFile, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void run(){	
		try {
			byte[] b = conn.read(startPos, endPos);
			destFile.seek(startPos);
			destFile.write(b, 0, b.length);
			destFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
