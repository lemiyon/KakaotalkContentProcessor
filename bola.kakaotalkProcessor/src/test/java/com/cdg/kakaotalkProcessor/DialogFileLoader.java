package com.cdg.kakaotalkProcessor;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//카카오톡 대화 txt파일을 읽어온다. 그리고 알맞은 형태로 가공한다
public class DialogFileLoader {

	//문자 스트림을 읽는 
	FileReader in;
	
	public int loadDialogFile() throws Exception{
		// TODO Auto-generated method stub
	
		Scanner scanner = new Scanner(System.in);
		
		try{
		in = new FileReader("/Users/gim-yuncheol-second/Desktop/Bola/KakaotalkContentProcessor/bola.kakaotalkProcessor/kakaotalkText.txt");
		
		
		
		
		}
		catch(IOException e)
		{
			System.out.println("Fail to Open File!");
			return -1;
		}
		finally
		{
			in.close();
		}
		
		
		return 0; //정상적인 실행은 0 반
	}

	 
}
