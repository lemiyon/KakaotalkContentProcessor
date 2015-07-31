package com.cdg.kakaotalkProcessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

//카톡 대화 분석기의 본체
public class KakaotalkProcessor {
	// txt로 되어 있는 카톡 대화 파일을 로드해 오는 객체.
	private Vector<String> contents;

	// KakaotalkProcessor의 생성자. 카톡 대화 파일을 작업하기 전 로드한다.
	public KakaotalkProcessor() {
		super();
		System.out.println("Welcome to Bola's Kakaotalk Conversation analyzer.");
	}

	public int loadDialogFile() {
		// TODO Auto-generated method stub

		// 파일을 읽어올 스트림
		FileReader in = null;
		// 읽어올 파일을 라인 단위로 잘라 읽어줄 BufferedStream
		BufferedReader bfreader = null;
		// 스트림을 통해 읽은 문자열을 임시저장하는 스트링.

		String str = null;
		this.contents = new Vector<String>();

		try {
			in = new FileReader(
					"/Users/gim-yuncheol-second/Desktop/Bola/KakaotalkContentProcessor/bola.kakaotalkProcessor/kakaoTalkShort.txt");
			bfreader = new BufferedReader(in);
			// System.out.println("Most Noisy Time is "+ mostBusyTime() + "
			// o'Clock around");

			while ((str = bfreader.readLine()) != null) {
				contents.addElement(str);
			}
			
			//파일 맨 앞에 붙는 2줄 대화방 설명 + 3줄 공백을 없앤다.
			for(int i = 0; i < 5; i++)
			{
			contents.remove(0);
			}
			
			//벡터의 전처리가 잘 끝났는지 검증 
			for(String string : contents)
			{
				System.out.println(string);
			}
			
			System.out.println("Busiest Time is around " + getBusiestTime() + "o'Clock");
			getFiveTermsMostUsedForEachUser();

		} catch (IOException e) {
			return -1;
		} finally {

			try {
				bfreader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return 0; // 정상적인 실행은 0 반환
	}

	String getBusiestTime() {
		Pattern p = Pattern.compile("[0-9]{2}:[0-9]{2},"); // 이 정규표현식을 쓰면, 대화
															// 내에서 이런 표현("09:30,
															// 09:45" - 예를 들어
															// 지하철 시간표 설명)이 쓰인
															// 경우를 거를 수 없다. 좀
															// 난감한
		Matcher m; // 버퍼에서 위의 패턴에 해당하는 것
		String total = null; // 빈도수를 검사하기 위해서, 위의 패턴에서 시간에 해당되는 모든 문자열을 합해서 가지고
								// 있을 문자
		int result = 0; // 가장 대화가 많은 시간대를 정수로 저장하고 있다. 정상적인 값은 0 ~ 23
		int mostUsed = 0;
		int temp = 0;

		// 처음 나오는 2개의 결과는 제외해야 함. 음....
		for (String string : contents) {
			m = p.matcher(string);
			while (m.find()) {
				String time = m.group().substring(0, 2);
				total += time;
			}

			for (int i = 0; i <= 23; i++) {
				String compensation = "0";
				if (i < 10)
					compensation += i;
				else
					compensation = Integer.toString(i);

				temp = StringUtils.countMatches(total, compensation);
				if (mostUsed < temp) {
					result = i;
					mostUsed = temp;
				}
			}
		}
		return Integer.toString(result);
	}

	public int getFiveTermsMostUsedForEachUser() {
		Pattern p = Pattern.compile("");// 카톡의 아이디 길이 제한은 1 ~ 20임을 이용해 내용과 이름
										// 부분을 분
		Matcher m;
		HashMap<Integer, String> result = new HashMap<Integer, String>();
		;

		
		for (String string : contents) {
			
		}

		return 0;
	}

}
