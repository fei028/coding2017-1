package com.codersing.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codersing.download.api.ConnectionManager;
import com.codersing.download.api.DownloadListener;
import com.codersing.download.impl.ConnectionManagerImpl;

public class FileDownloaderTest {
	boolean downloadFinished = false;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDownload() {
		
		String url = //"http://localhost:8080/examples/jsp/test.txt";
				"http://localhost:8080/examples/jsp/TIM1.0.4.exe";
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
