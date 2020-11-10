package com.fw.shopping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fw.shopping.admin.model.CategoryVO;
import com.fw.shopping.admin.repository.ICategoryMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class MapperTest {
	
	private ICategoryMapper cateMapper;
	
	@Test
	private void updateCate() {
		CategoryVO cat = new CategoryVO();
		cat.setCateCode(17);
		cat.setCateName("악세사리");
		cat.setCateRef(3);
		cateMapper.modifyCate(cat);
	}

}
