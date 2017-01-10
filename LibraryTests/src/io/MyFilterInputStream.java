package io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * questo filtro toglie tutti i caratteri 'a' dallo stream in lettura
 */
public class MyFilterInputStream extends FilterInputStream {

	public MyFilterInputStream(InputStream arg0) {
		super(arg0);
	}

	public int read() throws IOException {
		int data;
		for (data = super.read(); data=='a' || data==-1; data = super.read());
		return data;
	}
	
	public int	read(byte[] b) throws IOException{
		int i=0,j=0;
		do {
			int retval = super.read(b);
			if (retval==-1)
					return -1;
			
			i=0;j=0;
			for(;i<retval;i++)
				if (b[i]!='a') 
					b[j++]=b[i];
			for (i=j;i<b.length;i++)
				b[i]=0;
		} while (j==0);
		return j; // qui non va bene ritornare se j==0 perche` rompe il contratto. si deve continuare a leggere lo stream ed eventualmente ritornare -1 quando questo e` finito
	}

	public int	read(byte[] b, int off, int len) throws IOException{
		return super.read(b, off, len);
		// va implementato anche qui il filtraggio altrimenti non funziona nulla 
	}
}
