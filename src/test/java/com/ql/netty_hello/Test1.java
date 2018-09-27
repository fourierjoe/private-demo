package com.ql.netty_hello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Random;

public class Test1 {

	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("date.txt");
		FileOutputStream out = null;
		
		byte[] b = new byte[4];
		int len;
		int i = 0;
		while ((len = in.read(b)) != -1) {
			
			out = new FileOutputStream("target" + i++ + ".txt");
			out.write(b);
			out.flush();
		}
		
		in.close();
		out.close();
	}
}
