package ex03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class TestOutputStream {

	public static void main(String[] args)throws IOException {
		// ~Stream 으로 끝나는 class 는 byte 단위 입출력
		String fname = "D:/dev/java/PrjiO/src/ex03/data2.dat";
		FileOutputStream fos = new FileOutputStream(fname);
		
		//for (int i = 65; i <= 65 + 26; i++) {
			for (int i = 'A'; i <= 'Z'; i++) {
			fos.write(i);
		}
		fos.close();
	}

}
