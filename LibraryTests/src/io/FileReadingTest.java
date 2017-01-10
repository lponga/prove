package io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileReadingTest {

	public static void main(String[] args) {
		
		System.out.println("===================================");
		System.out.println("Inizio lettura stream");
		System.out.print("***");

		// InputStream is = openBufferedFileInputStream("TextExample.txt");
		InputStream is = openByteArrayInputStream("TextExample.txt");
		// InputStream is = openMyFilterInputStream("TextExample.txt");
		if (is!=null)
			for (byte[] b = readInputStream(is); b != null; b = readInputStream(is)) {
				System.out.print(new String(b, 0, b.length ));
			}
		closeInputStream(is);
		System.out.println("***");
		System.out.print("***");
		
		//InputStream is = openByteArrayInputStream("TextExample.txt");
		InputStream is2 = openMyFilterInputStream("TextExample.txt");
		if (is2!=null)
			for (byte[] b = readInputStream(is2); b != null; b = readInputStream(is2)) {
				System.out.print(new String(b, 0, b.length ));
			}
		closeInputStream(is2);
		System.out.println("***");
	}

	private static InputStream openBufferedFileInputStream(String filename) {
		try {
			return new BufferedInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException filename="+filename);
			fnfe.printStackTrace();
		}

		return null;
	}
	
	private static InputStream openByteArrayInputStream(String filename) {
		byte bArray[] = "ab abba dfasjnb abab ciao".getBytes();
		
		return new ByteArrayInputStream(bArray);
	}
	
	private static InputStream openMyFilterInputStream(String filename) {
		byte bArray[] = "ab abba dfasjnb abab ciao".getBytes();
		
		return new MyFilterInputStream(new ByteArrayInputStream(bArray));
	}
	
	private static void closeInputStream(InputStream is) {
		try {
			if (is!=null)
				is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	private static byte[] readInputStream(InputStream is) {
//		byte b[] = new byte[1];
//		try {
//			if (is !=null) {
//				if (is.read(b) !=-1)
//					return b;
//			}
//		} catch (IOException ioe) {
//			ioe.printStackTrace();
//		}
//		return null;
//	}

	private static byte[] readInputStream(InputStream is) {
		byte b[] = new byte[10];
		try {
			if (is !=null) {
				int len = is.read(b);
				if (len !=-1) {
					byte bRet[] = new byte[len];
					for (int i=0; i<len; i++)
						bRet[i]=b[i];
					return bRet;
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	private static void readInputStreamWithForLoop(InputStream is) {
		byte[] b = new byte[10];
		
		System.out.println("Inizio lettura file");
		
		try {
			for(int len=is.read(b); len != -1; len = is.read(b)) { // lettura di un file tramite ciclo for
				System.out.print(" "+new String(b, 0, len ));
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("\nFine lettura file");
	}

	private static void readBufferedInputStream(String filename) {
		BufferedInputStream fIn = null;
		byte[] b = new byte[10];
		
		System.out.println("===================================");
		System.out.println("Inizio lettura BufferedInputStream");
		try {
			fIn = new BufferedInputStream(new FileInputStream(filename));
			readInputStream(fIn);
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException filename="+filename);
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("IOException filename="+filename);
			ioe.printStackTrace();
		}
		finally {
			try {
				if (fIn!=null)
					fIn.close();
			} catch (IOException e) {
				System.out.println("IOException filename="+filename);
				e.printStackTrace();
			}
		}
		System.out.println("\nFine lettura BufferedInputStream");
	}

	private static void readFileInputStream(String filename) {
		FileInputStream fIn = null;
		byte[] b = new byte[2];
		
		System.out.println("===================================");
		System.out.println("Inizio lettura FileInputStream");
		try {
			fIn = new FileInputStream(filename);
			readInputStream(fIn);
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException filename="+filename);
			fnfe.printStackTrace();
			
		} catch (IOException ioe) {
			System.out.println("IOException filename="+filename);
			ioe.printStackTrace();
		}
		finally {
			try {
				if (fIn!=null)
					fIn.close();
			} catch (IOException e) {
				System.out.println("IOException filename="+filename);
				e.printStackTrace();
			}
		}
		System.out.println("\nFine lettura FileInputStream");
	}

}
