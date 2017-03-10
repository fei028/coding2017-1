package com.codersing.download.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.codersing.download.api.Connection;


public class ConnectionImpl implements Connection{

	private URLConnection conn;
	
	public ConnectionImpl(String urlStr) {
		try {
			URL url = new URL(urlStr);
			conn = url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public byte[] read(int startPos, int endPos) throws IOException {
		InputStream in = conn.getInputStream();
		byte[] b = new byte[endPos - startPos + 1];
		in.read(b , startPos,b.length);
		return null;
	}

	@Override
	public int getContentLength() {
		
		return conn.getContentLength();
	}

	@Override
	public void close() {
		
		
	}

}
