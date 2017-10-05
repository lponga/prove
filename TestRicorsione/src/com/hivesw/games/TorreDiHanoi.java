package com.hivesw.games;

public class TorreDiHanoi {

	static long numMossa=0;
	
	public static void main(String[] args) {
		muoviTorre(1,3,1,3,2);

	}

	private static void muoviTorre(int livello, int numPezzi, int start, int end, int intermediate) {
		if (numPezzi>1)
			muoviTorre(livello+1,numPezzi-1,start,intermediate,end);
		System.out.println(""+(++numMossa)+","+livello+" -> muovi elemento from "+start+" to "+end);
		if (numPezzi>1)
			muoviTorre(livello+1,numPezzi-1,intermediate,end,start);		
	}

}
