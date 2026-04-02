package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Zipcode5_3 {

	public static void main(String[] args) throws IOException {
		// 부산의 부전2동 우편번호만 화면 출력

		List<String> sidoList = new ArrayList<>();
		List<Integer> sidoCntList = new ArrayList<>();
		
		String path = Zipcode5_3.class.getResource("").getPath();
		String fname = "zipcode_utf8.csv";
		File inFile = new File(path+fname);
		
		if(!inFile.exists()) {
			System.out.println(fname+"이 없소");
			System.exit(-1);
		}
		
		FileReader fr = new FileReader(inFile);
		BufferedReader br = new BufferedReader(fr);
		
		br.readLine();	// 제목줄 skip
		String line = "";
		int totcnt = 0;		// 전체 자료수
		String prevSido = "";	// 시,도 개수
		int cnt = 0;
		
		long startTime = System.nanoTime();
		
		TreeSet<String> set = new TreeSet<>();
				
		while((line = br.readLine()) !=null) {
			PostVo vo = new PostVo(line);
			String sido = vo.getSido();
			String dong = vo.getDong();
			String zipcode= vo.getZipcode();

			if(sido.equals("부산") && dong.equals("부전2동")){
				System.out.println("부산 부전2동 우편번호:" + zipcode);
				cnt++;
			}
			totcnt++;			
		}
		long endTime = System.nanoTime();
		double execTime = (endTime - startTime)/1000.0/1000.0/1000.0;
		
		br.close();
		fr.close();
		
		for (String s : set) {
			System.out.println(s);
		}
		System.out.println("도시수:" + cnt);
		System.out.println("전체자료수:" + totcnt);
		System.out.println("실행시간:" + execTime + "s");
	}

}
