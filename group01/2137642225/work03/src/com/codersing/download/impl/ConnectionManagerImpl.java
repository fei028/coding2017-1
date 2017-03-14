package com.codersing.download.impl;

import java.io.File;
import java.io.RandomAccessFile;

import com.codersing.download.DownloadThread;
import com.codersing.download.FileDownloadThread;
import com.codersing.download.api.Connection;
import com.codersing.download.api.ConnectionException;
import com.codersing.download.api.ConnectionManager;

public class ConnectionManagerImpl implements ConnectionManager {

	@Override
	public Connection open(String url) throws ConnectionException {
		Connection conn = new ConnectionImpl(url);
		return conn;
	}
	
	public static void main(String[] args) throws Exception {
		File f = new File("G://极限编程.doc");
		RandomAccessFile destFile = new RandomAccessFile(f, "r");
		File file = new File("G://tt.doc");
		if(!file.exists()){
			file.createNewFile();
		}
		long length = f.length();	
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		rf.setLength(length);
		int downloadThreadNum = 10;
		long startPos = 0;
		long endPos = -1;
		long size = (length / downloadThreadNum);
		for(int i = 0; i < downloadThreadNum; i++){
			startPos = endPos + 1;
			endPos += size;
			if(i == (downloadThreadNum - 1)){
				endPos = length;
			}
			System.out.println(startPos + "--" + endPos);
			new Thread(new FileDownloadThread(f.getAbsolutePath(), file.getAbsolutePath(), startPos, endPos)).start();;
		}
	}
	
 
}
