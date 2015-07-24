package com.cdg.kakaotalkProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//카카오톡 대화 txt파일을 읽어온다.
public class DialogFileLoader {

	//읽어올 문자열을 갖고 있을 저장소
	private StringBuffer buffer;
	
	//분석할 카톡 대화 내용을 가지고 있는 저장소 StringBuffer를 보여준다.
	public StringBuffer getBuffer() {
		return buffer;
	}

	public int loadDialogFile() throws Exception{
		// TODO Auto-generated method stub
		
		//파일을 읽어올 스트림
		FileReader in = null;
		//읽어올 파일을 라인 단위로 잘라 읽어줄 BufferedStream
		BufferedReader bfreader = null;
		//스트림을 통해 읽은 문자열을 임시저장하는 스트링.
		
		String str;
		
		try{
		in = new FileReader("/Users/gim-yuncheol-second/Desktop/Bola/KakaotalkContentProcessor/bola.kakaotalkProcessor/kakaoTalk.txt");
		bfreader = new BufferedReader(in);
		buffer = new StringBuffer();
		
		//카카오톡 대화 파일을 읽어 버퍼에 집어 넣는다. 
		while((str = bfreader.readLine())!= null)
			{
			buffer.append(str);
			}
		
		System.out.println(buffer);
		
		}
		catch(IOException e)
		{
			System.out.println("Fail to Open File!");
			return -1;
		}
		finally
		{
			
			bfreader.close();
			in.close();
		}
		
		
		return 0; //정상적인 실행은 0 반
	}

}
