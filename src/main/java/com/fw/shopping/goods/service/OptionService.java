package com.fw.shopping.goods.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fw.shopping.goods.model.OptionVO;
import com.fw.shopping.goods.repository.IOptionMapper;

@Service
public class OptionService implements IOptionService {

	@Inject
	private IOptionMapper mapper;


	@Override
	public List<OptionVO> getOptionList(int gdsNo) {
		return mapper.getOptionList(gdsNo);
	}
	
	@Override
	public void modifyGdsOpt(OptionVO option) {
		mapper.modifyGdsOpt(option);
	}

	@Override
	public void addGdsOpt(OptionVO option) {
		mapper.addGdsOpt(option);	
	}



	
	
	@Override
	public void deleteGdsOpt(int optionNo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public OptionVO getOptionInfo(int optionNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
