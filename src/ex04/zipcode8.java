package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class zipcode8 {

	public static void main(String[] args) {

		String path = zipcode8.class.getResource("").getPath();
		String inFname = "zipcode_utf8.csv";
		String outFname = "";
		
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		int cnt = 0;
		
		try {
			fr = new FileReader(path + inFname);
			br = new BufferedReader(fr);
			

			
			br.readLine();
			String line = "";
			String prevSido = "";
			while((line = br.readLine())!=null) {
				PostVo postVo = new PostVo(line);
				String sido = postVo.getSido();
				String gugun = postVo.getGugun();
				
				if(!sido.equals(prevSido)) {
					outFname = path + sido + ".csv";
					File oFile = new File(outFname);
					if(oFile.exists()) {
						oFile.delete();
					}
					fw = new FileWriter(oFile, true);  // true : append
					bw = new BufferedWriter(fw);
					
					prevSido = sido;
					cnt++;
				}
				
				bw.write(postVo.getAddress()+"\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr !=null) br.close();
				if(fr !=null) bw.close();
				
				if(fr !=null) fr.close();
				if(fr !=null) fw.close();
			} catch (IOException e) {
			}
		}  //try catch end
		System.out.println(cnt + "개 파일 생성");
	}

}
