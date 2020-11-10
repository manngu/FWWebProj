package com.fw.shopping.notice.service;

import java.util.List;

import com.fw.shopping.admin.model.SearchVO;
import com.fw.shopping.notice.model.NoticeVO;

public interface INoticeService {

	//공지 등록 기능	
	void addNotice(NoticeVO noti);
	
	//공지 상세 조회 기능
	NoticeVO getNoticeInfo(int noticeNo);
	
	//공지 수정 기능
	void modifyNotice(NoticeVO noti);
	
	//공지 삭제 기능
	void deleteNotice(int noticeNo);

	//검색, 페이징 기능이 포함된 공지 목록 조회
	List<NoticeVO> getNoticeList(SearchVO search);	//정렬은 최신순. 검색기능
	Integer countNotices(SearchVO search);
}
