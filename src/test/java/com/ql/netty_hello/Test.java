package com.ql.netty_hello;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Test {

	public static void main(String[] args) throws Exception {
		
		FileInputStream in = new FileInputStream("date.txt");
		FileChannel inChannel = in.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(4);
		
		while (true) {
			buffer.clear(); //将position置位0,并不是清空buffer.limit置位buffer的容量
//			buffer.rewind(); //将position置位0,limit不会变,会是上一次循环的limit
			
			int flag = inChannel.read(buffer);
			
			if (flag == -1) {
				break;
			}
			
			buffer.flip(); //必须反转, 将position置位0,从头开始写,否则写入为空
			FileOutputStream out = new FileOutputStream("target" + new Random().nextInt(10) + ".txt");
			FileChannel outChannel = out.getChannel();
			
			outChannel.write(buffer);
		}
	}
	
}
