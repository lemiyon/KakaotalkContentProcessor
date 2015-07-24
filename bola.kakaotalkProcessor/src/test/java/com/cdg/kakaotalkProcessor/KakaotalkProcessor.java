package com.cdg.kakaotalkProcessor;

//카톡 대화 분석기의 본체
public class KakaotalkProcessor {
	//txt로 되어 있는 카톡 대화 파일을 로드해 오는 객체.
	private DialogFileLoader dfLoader;
	
	//KakaotalkProcessor의 생성자. 카톡 대화 파일을 작업하기 전 로드한다.
	public	KakaotalkProcessor(){
		dfLoader = new DialogFileLoader();
		System.out.println("Welcome to Bola's Kakaotalk Conversation analyzer.");
		try {
			dfLoader.loadDialogFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Fail to Close File/BufferedReader!");
			e.printStackTrace();
		}
		
	}

	//카톡 대화 파일을 분석해 가장 많이 대화한 시간대를 1시간 단위로 구해 준다.
	public int getMostNoisyTime() {
		// TODO Auto-generated method stub
		
		//StringBuffer를 받아와 앞의 기본적인 대화 정보를 자른다.
		
		/*
		 * txt파일에서 각 앞 줄의 yyyy.mm.dd..형식으로 되어 있는 시간을 받아 1 ~ 12시 까지의 원소를 갖는 해쉬 맵을 만들고, 거기에 해당하는 대화의 수를
		 *  집어넣고, Collection의 소트 함수를 이용해 가장 대화 수가 많은 시간대를 구한다.
		 */
		
		//정상종료 시 0 반환
		return 0;
	}

	//대화 내의 각각의 계정이 가장 많이 사용한 단어 5개를 각 계정 당 보여준다.
	//이름이 너무 길어서 바꾸는 게 좋을듯...
	public int getTopFiveTermsMostUsedForEachUser() {
		// TODO Auto-generated method stub
		
		//정상종료 시 0 반환
		return 0;
	}
	
	
	
}
