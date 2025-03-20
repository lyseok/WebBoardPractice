package member.controller;

import java.io.BufferedReader;
import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;

public class SendDataSrialize {
	public static String chageData(HttpServletRequest request){
		// 전송데이터 받기
		StringBuffer strbuf = new StringBuffer();
		String line = null;
		BufferedReader br = null;
		
		try {
			br = request.getReader();
			
			while(true) {
				line = br.readLine();
				if(line == null) {
					break;
				}
				strbuf.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return strbuf.toString();
	}
}
