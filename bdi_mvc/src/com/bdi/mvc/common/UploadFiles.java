package com.bdi.mvc.common;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFiles {
	private static final String UPLOAD_PATH = "C:\\bdi_study\\workspace\\gits\\bdi_mvc\\bdi_mvc\\WebContent";
	
	public static Map<String,String> saveFileList(HttpServletRequest req) throws ServletException {
		if(!ServletFileUpload.isMultipartContent(req)) {
			throw new ServletException("폼형식이 파일업로드에 적합하지 않습니다.");
		}
		DiskFileItemFactory diFactory = new DiskFileItemFactory();
		diFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		diFactory.setSizeThreshold(1024*1024*5);//5MB
		
		ServletFileUpload sfu = new ServletFileUpload(diFactory);
		sfu.setHeaderEncoding("utf-8");
		sfu.setSizeMax(1024*1024*100); //100MB
		sfu.setFileSizeMax(1024*1024*50); //50MB
		try {
			List<FileItem> fList = sfu.parseRequest(req);
			
			if(fList==null || fList.size()==0) {
				throw new ServletException("업로드할 파일이 없습니다!!");
			}
			Map<String,String> params = new HashMap<String,String>();
			for(FileItem fi : fList) {
				if(!fi.isFormField()) {
					String fEndName = fi.getName().substring(fi.getName().lastIndexOf("."));
					String fileName = File.separator + "files" + File.separator + System.currentTimeMillis() + fEndName;
					String filePath = UPLOAD_PATH + File.separator + fileName;
					File sFile = new File(filePath);
					fi.write(sFile);
					params.put(fi.getFieldName(), fileName);
				}else {
					params.put(fi.getFieldName(), fi.getString("utf-8"));
				}
			}
			return params;
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
