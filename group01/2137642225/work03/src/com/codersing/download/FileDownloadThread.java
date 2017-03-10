package com.codersing.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class FileDownloadThread implements Runnable{

	private File f;
	private long startPos;
	private long endPos;
	
	public FileDownloadThread(String f, long startPos, long endPos) {
		super();
		this.f = new File(f);
		this.startPos = startPos;
		this.endPos = endPos;
		
	}

	@Override
	public void run() {
		try {
			RandomAccessFile rf = new RandomAccessFile("E://download//W3School离线电子书2013.09.chm", "rw");
			rf.seek(startPos);
			RandomAccessFile _rf = new RandomAccessFile(f, "r");
			byte[] b = new byte[1024];
			int len = 0;
			while((len = _rf.read(b)) != -1){
				
				if((rf.getFilePointer() + b.length) >= endPos){
					rf.write(b, 0, (int) (endPos - rf.getFilePointer()));
					break;
				}
				rf.write(b, 0, len);
			}
			
			System.out.println("end -> " + startPos + " -> " + rf.getFilePointer() + " -> " + endPos);
			_rf.close();
			rf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

