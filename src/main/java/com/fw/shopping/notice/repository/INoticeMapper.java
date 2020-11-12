package com.fw.shopping.notice.repository;

import java.util.List;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.notice.model.NoticeVO;

public interface INoticeMapper {

	List<NoticeVO> getNoticeList(SearchVO search);	//정렬은 최신순. 검색기능
	
	NoticeVO getNoticeInfo(int noticeNo);
	
	void addNotice(NoticeVO noti);
	
	void modifyNotice(NoticeVO noti);
	
	void deleteNotice(int noticeNo);

}
