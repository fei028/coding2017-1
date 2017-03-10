package com.codersing.download.impl;

import java.io.File;
import java.io.RandomAccessFile;

import com.codersing.download.FileDownloadThread;
import com.codersing.download.api.Connection;
import com.codersing.download.api.ConnectionException;
import com.codersing.download.api.ConnectionManager;

public class ConnectionManagerImpl implements ConnectionManager {

	@Override
	public Connection open(String url) throws ConnectionException {
		new ConnectionImpl(url);
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		File f = new File("E://W3School离线电子书2013.09.chm");
		File file = new File("E://download//" + f.getName());
		if(!file.exists()){
			file.createNewFile();
		}
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		long length = f.length();
		rf.setLength(length);
		rf.close();
		System.out.println(length);
		long middlePos = length / 2;
		
		new Thread(new FileDownloadThread(f.getAbsolutePath(), 0, 100)).start();
		new Thread(new FileDownloadThread(f.getAbsolutePath(), 101, 1000)).start();
		new Thread(new FileDownloadThread(f.getAbsolutePath(), 1001, length)).start();
	}
	
 
}
