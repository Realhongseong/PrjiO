package ex04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class zipcode6 {

	public static void main(String[] args) {
		String fn="D;/dev/java/PjriO/ex04/src/zipcode_utf8.csv";
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(fn);
			br = new BufferedReader(fr);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} finally {	// Exception 발생과 상관없이 무조건 실행
			
		}
		
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fr.close();

	}

}
