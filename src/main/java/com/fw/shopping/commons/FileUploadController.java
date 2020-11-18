package com.fw.shopping.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping( "/admin/test" )
	
	public String fileuploadtest() {
		return "admin/fileuploadtest";
	}
	
	@RequestMapping( "/admin/upload" )
	public String upload(
			Model model,
			@RequestParam("gdsName") String gdsName,
			@RequestParam("file1") MultipartFile file) {
		
		String url = fileUploadService.restore(file);
		model.addAttribute("url", url);
		return "/admin/result";
	}
		

}
