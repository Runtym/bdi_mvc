package com.bdi.mvc.common;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFiles {
	private static final String UPLOAD_PATH = "C:\\bdi_study\\workspace\\gits\\bdi_mvc\\bdi_mvc\\WebContent";
	
	public static int saveFileList(HttpServletRequest req) throws ServletException {
		if(!ServletFileUpload.isMultipartContent(req)) {
			throw new ServletException("폼형식이 파일업로드에 적합하지 않습니다.");
		}
		DiskFileItemFactory diFactory = new DiskFileItemFactory();
		diFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		diFactory.setSizeThreshold(1024*1024*5);//5MB
		
		ServletFileUpload sfu = new ServletFileUpload(diFactory);
		sfu.setSizeMax(1024*1024*100); //100MB
		sfu.setFileSizeMax(1024*1024*50); //50MB
		String path = UPLOAD_PATH + File.separator + "files";
		File upPath = new File(path);
		if(!upPath.exists()) {
			upPath.mkdir();
		}
		try {
			List<FileItem> fList = sfu.parseRequest(req);
			
			if(fList==null || fList.size()==0) {
				throw new ServletException("업로드할 파일이 없습니다!!");
			}
			int cnt = 0;
			for(FileItem fi : fList) {
				if(!fi.isFormField()) {
					File f = new File(fi.getName());
					String fileName = f.getName();
					String filePath = path + File.separator + fileName;
					File sFile = new File(filePath);
					fi.write(sFile);
					cnt++;
				}
			}
			return cnt;
		}catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
