package tutorial08.decorator;

import java.io.*;

public class ReaderTest {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src/tutorial08/decorator/test.txt");
		BufferedReader br = new BufferedReader(fr);
		LineNumberReader lnr = new LineNumberReader(br);
		BufferedReader br2 = new BufferedReader(lnr);
		System.out.println(br2.readLine());
		//System.out.println(br2.getLineNumber());
		System.out.println(br2.readLine());
	}
}
