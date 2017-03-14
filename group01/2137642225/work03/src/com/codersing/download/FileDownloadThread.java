package com.codersing.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import com.codersing.download.api.ConnectionManager;
import com.codersing.download.api.DownloadListener;
import com.codersing.download.impl.ConnectionManagerImpl;

public class FileDownloadThread implements Runnable{

	private RandomAccessFile sourceFile;
	private RandomAccessFile destFile;
	private long startPos;
	private long endPos;
	
	public FileDownloadThread(String sourceFile, String destFile, long startPos, long endPos) {
		super();
		this.startPos = startPos;
		this.endPos = endPos;
		try {
			this.sourceFile = new RandomAccessFile(sourceFile, "r");
			this.destFile = new RandomAccessFile(destFile, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			sourceFile.seek(startPos);
			destFile.seek(startPos);
			byte[] b = new byte[1024];
			int len = 0;
			while((len = sourceFile.read(b)) != -1){
				if((destFile.getFilePointer() + b.length) >= endPos){
					destFile.write(b, 0, (int) (endPos - destFile.getFilePointer()));
					break;
				}
				destFile.write(b, 0, len);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static boolean downloadFinished = false;
	
	public static void main(String[] args) {
		String url = "http://localhost:8080/examples/jsp/test.txt";
				//"http://localhost:8080/examples/jsp/TIM1.0.4.exe";
				//"http://pic2.ooopic.com/12/42/25/02bOOOPIC95_1024.jpg";
				//"http://dldir1.qq.com/qqfile/qq/TIM1.0.5/20300/TIM1.0.5.exe";
		
		FileDownloader downloader = new FileDownloader(url);
		
		
		ConnectionManager cm = new ConnectionManagerImpl();
		downloader.setConnectionManager(cm);
		
		downloader.setListener(new DownloadListener() {
			@Override
			public void notifyFinished() {
				downloadFinished = true;
			}

		});

		
		downloader.execute();
		
		// 等待多线程下载程序执行完毕
		while (!downloadFinished) {
			try {
				System.out.println("还没有下载完成，休眠五秒");
				//休眠5秒
				Thread.sleep(5000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		System.out.println("下载完成！");
		
		

	}
	
}

