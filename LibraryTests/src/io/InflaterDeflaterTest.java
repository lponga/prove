package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.InflaterOutputStream;

public class InflaterDeflaterTest {

	public static void main(String[] args) {
		
		try {
			InflaterOutputStream out = new InflaterOutputStream(new FileOutputStream("AZippedFile.zip"));
			
			out.write("una riga di testo\n".getBytes());
			out.write("una seconda di testo\n".getBytes());
			out.write("ciao\n".getBytes());
			out.write("loris\n".getBytes());
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
