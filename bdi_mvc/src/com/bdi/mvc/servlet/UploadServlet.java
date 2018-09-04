package com.bdi.mvc.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(
		urlPatterns="/upload/*"
		)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upName = request.getParameter("upName");
		DiskFileItemFactory diFactory = new DiskFileItemFactory();
		File tmpDisk = new File(System.getProperty("java.io.tmpdir"));
		diFactory.setRepository(tmpDisk);
		
		
		ServletFileUpload sfu = new ServletFileUpload(diFactory);
		try {
			List<FileItem> fList = sfu.parseRequest(request);
			for(FileItem fi:fList) {
				if(fi.isFormField()) {
					System.out.println(fi.getFieldName());
					System.out.println(fi.getString("utf-8"));
				}else {
					File f = new File("c:\\test\\" + fi.getName());
					fi.write(f);
					System.out.println(fi.getName() + "저장 완료");
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("업로더 : " + upName);
	}

}
