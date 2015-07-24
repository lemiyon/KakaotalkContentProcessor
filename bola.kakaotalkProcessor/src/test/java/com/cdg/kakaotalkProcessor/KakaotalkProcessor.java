package com.cdg.kakaotalkProcessor;

//카톡 대화 분석기의 본체
public class KakaotalkProcessor {
	//txt로 되어 있는 카톡 대화 파일을 로드해 오는 객체.
	private DialogFileLoader dfLoader;
	
	//
	public	KakaotalkProcessor(){
		dfLoader = new DialogFileLoader();
	}
	
}
