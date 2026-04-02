package ex04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class Zipcode5_2 {

	public static void main(String[] args) throws IOException {
//		4. 한국의 시도명 출력 - 17건 
//		   서울
//		   부산
//		   ... 
//		   충북

		String path = Zipcode5_2.class.getResource("").getPath();
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
		int totcnt = 0;
		
		String prevSido = "";
		int cnt = 0;
		
		long startTime = System.nanoTime();
		
		TreeSet<String> set = new TreeSet<>();
				
		while((line = br.readLine()) !=null) {
			PostVo vo = new PostVo(line);
			String sido = vo.getSido();
			set.add(sido);
			if(!sido.equals(prevSido)){
				prevSido = sido;
				//System.out.println(sido);
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
