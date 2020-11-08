package com.fw.shopping.notice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fw.shopping.admin.model.SearchVO;
import com.fw.shopping.notice.model.NoticeVO;

@Service
public class NoticeService implements INoticeService {

	@Override
	public List<NoticeVO> getNoticeList(SearchVO search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeVO getNoticeInfo(int noticeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNotice(NoticeVO noti) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyNotice(NoticeVO noti) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNotice(int noticeNo) {
		// TODO Auto-generated method stub
		
	}

}
