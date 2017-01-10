package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputTest {

	public static void main(String[] args) {
		
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"));
			dos.writeInt(12);
			dos.writeDouble(12.12);
			dos.writeChars("ciao\n");
			dos.writeBoolean(true);
			dos.close();
			
			DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"));
			int numInt = dis.readInt();
			double numDouble = dis.readDouble();
			String anStr = dis.readLine();
			boolean b = dis.readBoolean();
			dis.close();
			
			System.out.println("numInt="+numInt+" numDouble="+numDouble+" anStr="+anStr+" bool="+b);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
