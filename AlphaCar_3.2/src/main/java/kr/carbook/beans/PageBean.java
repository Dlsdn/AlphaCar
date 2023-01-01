package kr.carbook.beans;

import lombok.Getter;

@Getter
public class PageBean {

	// 최소 페이지 번호
	private int min;
	// 최대 페이지 번호
	private int max;
	// 이전 버튼의 페이지 번호
	private int prevPage;
	// 다음 버튼의 페이지 번호
	private int nextPage;
	// 전체 페이지 개수
	private int pageCnt;
	// 현재 페이지 번호
	private int currentPage;
	
	//contentCnt(table), currentPage(param) : 현재 글번호, contentPageCnt(properties):페이지당 글의 갯수,
	//paginationCnt(properties) : 페이지당 버튼의 갯수
	public PageBean(int contentCnt, int currentPage, int contentPageCnt, int paginationCnt) {
		
		// 현재 페이지 번호
		this.currentPage = currentPage;
		// 전체 페이지 갯수
		pageCnt = contentCnt / contentPageCnt;
		// 561 / 10 56페이지 + 1페이지 필요
		if(contentCnt % contentPageCnt > 0) {
			pageCnt++;
		}
		// 이전 이후 비활성화
		//1 ~ 10 : 최소 1 최대 10    => 0 ~ 9
		///11 ~ 20 : 최소 11 최대 20 => 10 ~ 19
		
		//오라클의 index번호와 코드에서의 값을 일치 시키기
		min =((currentPage -1 ) / contentPageCnt ) * contentPageCnt+1;
		max = min+paginationCnt -1;
		 
		if(max > pageCnt) {
			max=pageCnt;
		}
		prevPage = min-1;
		nextPage = max+1;
		
		// 마지막 페이지 예외처리
		if(nextPage > pageCnt) {
			nextPage=pageCnt;
		}
		
	}
	
}
