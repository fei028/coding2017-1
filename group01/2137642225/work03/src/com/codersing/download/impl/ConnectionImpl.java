package com.codersing.download.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.codersing.download.FileDownloader;
import com.codersing.download.api.Connection;
import com.codersing.download.api.ConnectionManager;
import com.codersing.download.api.DownloadListener;


public class ConnectionImpl implements Connection{

	
	
	private InputStream in;
	
	private String fileName;
	
	private long contentLength;
	
	public ConnectionImpl(String urlStr) {
		try {
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			contentLength = conn.getContentLengthLong();
			String contentDisposition = conn.getHeaderField("Content-Disposition");
			fileName = 
					//"test.txt";
					//"test-11.jpg";
					"a.exe";
			in = conn.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public byte[] read(long startPos, long endPos) throws IOException {
		int len = endPos != getContentLength() ? (int) (endPos - startPos + 1) : (int) (endPos - startPos);
		byte[] b = new byte[len];
		in.skip(startPos);
		in.read(b);
		//System.out.println(new String(b));
		System.out.println("start:" + startPos + " endPos:" + endPos + " length:" + getContentLength());
		return b;
	}

	@Override
	public long getContentLength() {
	
		return contentLength;
	}

	public String getFileName(){
		return fileName;
	}
	
	@Override
	public void close() {
		
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
