package string;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Locale;

public class StringTests {

	public static void main(String[] args) {
	     String abc = "abc";
         System.out.println("str="+abc);
         String cde = "cde";
         System.out.println("cde=" + cde);
         String c = "abc".substring(2,3);
         System.out.println("c=" + c);
         String d = cde.substring(1, 2);
         System.out.println("d=" + d);
         
         byte data[] = {65,66,67}; // costruttore stringa da array di BYTE 
         String str1 = new String(data);
         System.out.println("str1=" + str1);

         byte data2[] = {65,66,67}; // costruttore stringa da array di BYTE specificando il charset
         System.out.println("str({65,66,67},\"US-ASCII\")=" + new String(data2,Charset.forName("US-ASCII")));
         System.out.println("str({65,66,67},\"ISO-8859-1\")=" + new String(data2,Charset.forName("ISO-8859-1")));
         System.out.println("str({65,66,67},\"UTF-8\")=" + new String(data2,Charset.forName("UTF-8")));
         System.out.println("str({65,66,67},\"UTF-16BE\")=" + new String(data2,Charset.forName("UTF-16BE")));
         System.out.println("str({65,66,67},\"UTF-16LE\")=" + new String(data2,Charset.forName("UTF-16LE")));
         System.out.println("str({65,66,67},\"UTF-16\")=" + new String(data2,Charset.forName("UTF-16")));

         System.out.println("new String(data2,1,2)=" + new String(data2,1,2));

         int data3[] = {65,66,67,68,69,70,71,72,73,74,75,76,77};
         System.out.println("data3=" + new String(data3, 0,13));
         System.out.println("data3.codePointCount(1,3)=" + new String(data3, 0,13).codePointCount(1,3));
         int dataUNICODE[] = {65,66,67,65540,69,70,71,72,73,74,75,76,77};
         System.out.println("dataUNICODE=" + new String(dataUNICODE, 0,13));
         System.out.println("dataUNICODE.codePointCount(1,3)=" + new String(dataUNICODE, 0,13).codePointCount(1,3));

         System.out.println("risultato del confronto case insensitive di AbC e aBc = " + "AbC".compareToIgnoreCase("aBc"));

         
         char data4[] = {'A','B','C'}; // costruttore stringa da array di BYTE 
         System.out.println("str4=" + String.copyValueOf(data4));

         // https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html#syntax
         String str5 = String.format(Locale.ITALIAN, "Un intero %d un char %c un boolean %b un byte %b una stringa %s",12, 'a', true, 0xb, "ciao");
         System.out.println("str5=" + str5);
         String str6 = String.format(Locale.ITALIAN, "Un intero %10d un char %10c un boolean %10b un byte %10b una stringa %10s",12, 'a', true, 0xb, "ciao");
         System.out.println("str6=" + str6);
         
         String str7 = String.format(Locale.ITALIAN, "Un intero %d in ottale %o in esadecimale %x in esadec maiuscolo %X un char '%c' un boolean %b una stringa %10s una string uppercase %S a date %tc",
        		 12, 12, 12, 12, 'a', true, "ciao", "ciao", new Date());
         System.out.println("str7=" + str7);
         
	}

}
