package com.cdg.kakaotalkProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

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
		in = new FileReader("/Users/gim-yuncheol-second/Desktop/Bola/KakaotalkContentProcessor/bola.kakaotalkProcessor/kakaoTalkShort.txt");
		bfreader = new BufferedReader(in);
		buffer = new StringBuffer();
		
		//카카오톡 대화 파일을 읽어 버퍼에 집어 넣는다. 
		while((str = bfreader.readLine())!= null)
			{
			buffer.append(str);
			}

			//최빈값을 가진 키와 값 순서쌍이 나오도록 해야 하는데.... 해쉬맵은 Sort를 위해서 존재하지 않는다네???? 
			//그나마 정렬을 위한 TreeMap이 있긴 하지만, 이 또한 키를 중심으로 정렬하는 애라..... 값을 중심으로 정렬하고 싶은 나로는 
			//역시 24개 배열을 둬서 하는 게 좋으려나. 하지만 공간 복잡도가 높아지는데....
			//에라이 모르겠다. 일단 해쉬맵을 정렬하는 방법으로 가자. 
			//아까 전 StringUtils에서 CountMatches라는 상당히 의미심장한 메소드를 발견했다. 
		System.out.println("Most Noisy Time is "+ mostBusyTime() + "o'Clock around");
		
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

	
	String mostBusyTime()
	{
		Pattern p = Pattern.compile("[0-9]{2}:[0-9]{2},"); //이 정규표현식을 쓰면, 대화 내에서 이런 표현("09:30, 09:45" - 예를 들어 지하철 시간표 설명)이 쓰인 경우를 거를 수 없다. 좀 난감한
		Matcher m = p.matcher(getBuffer()); //버퍼에서 위의 패턴에 해당하는 것
		String total = null; //빈도수를 검사하기 위해서, 위의 패턴에서 시간에 해당되는 모든 문자열을 합해서 가지고 있을 문자
		int result = 0; //가장 대화가 많은 시간대를 정수로 저장하고 있다. 정상적인 값은 0 ~ 23
		int mostUsed = 0; 
		int temp = 0;
		
		//처음 나오는 2개의 결과는 제외해야 함. 음....
		
		
			while(m.find()) {
				String time = m.group().substring(0, 2);
				System.out.println(time);
				
				total += time;
			}
		
			for(int i = 0; i <= 23; i++)
			{
				String compensation = "0";
				if(i < 10 ) compensation += i;
				else compensation = Integer.toString(i);
				
				temp = 	StringUtils.countMatches(total, compensation);
				if(mostUsed < temp)
				{
					result = i;
					mostUsed = temp;
				}
			}
			return Integer.toString(result);
	}
}

