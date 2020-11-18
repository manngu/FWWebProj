package com.fw.shopping.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fw.shopping.commons.SearchVO;
import com.fw.shopping.notice.model.NoticeVO;
import com.fw.shopping.notice.repository.INoticeMapper;

@Service
public class NoticeService implements INoticeService {

	
	@Inject
	private INoticeMapper noticeMapper;
	
	@Override
	public void addNotice(NoticeVO noti) {
		noticeMapper.addNotice(noti);
	}
	
	@Override
	public NoticeVO getNoticeInfo(int noticeNo) {
		return noticeMapper.getNoticeInfo(noticeNo);
	}
	
	@Override
	public void modifyNotice(NoticeVO noti) {
		noticeMapper.modifyNotice(noti);		
	}
	
	@Override
	public void deleteNotice(int noticeNo) {
		noticeMapper.deleteNotice(noticeNo);
	}
	
	@Override
	public List<NoticeVO> getNoticeList(SearchVO search) {
		List<NoticeVO> noticeList = noticeMapper.getNoticeList(search);
		
		return noticeList;
	}

	@Override
	public Integer countNotices(SearchVO search) {
		return noticeMapper.countNotices(search);

	}
	
}
