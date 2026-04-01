package ex04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zipcode {

	public static void main(String[] args) {
		
		String fname = "D:\\Dev\\Java\\PrjiO\\src\\ex04\\zipcode_20130201(1).csv";
				
		Scanner scanner = new Scanner(System.in);
		System.out.println("검색할 자료(동, 건물명)를 입력해주삼: ");
		String searchKeyword = scanner.nextLine();
		
		int totalCount = 0;
		int matchCount = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(fname))){
			String line;
			br.readLine();
			while((line = br.readLine()) != null) {
				totalCount++;
				
				String[] parts = line.split(",");
				if (parts.length >= 4) {
					String zipcode = parts[0];
					String sido = parts[1];
					String gugun = parts[2];
					String dong = parts[3];
					String bunji = (parts.length > 4) ? parts[4] : "";
					
					if(dong.contains(searchKeyword)) {
						matchCount++;
						System.out.println("[" + zipcode + "] " + sido + " " + gugun + " " + dong + " " + bunji);
					}
				}
			}	// 반복 끝
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일 읽다가 터졌음. 경로를 확인해주삼.");
		}
	
		System.out.println("\n검색된 자료수 : " + matchCount);
		System.out.println("전체 자료수 : " + totalCount);
	}

}
