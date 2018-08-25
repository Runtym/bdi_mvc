package com.bdi.mvc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.MakerService;
import com.bdi.mvc.service.impl.MakerServiceImpl;
import com.bdi.mvc.vo.Maker;

public class MakerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MakerService ms = new MakerServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		if(cmd.equals("makerList")) {
			List<Maker> makerList = ms.getMakerList(null);
			request.setAttribute("list", makerList);
		}else if(cmd.equals("makerView") || cmd.equals("makerUpdate")) {
			String mNumStr = request.getParameter("mNum");
			if(mNumStr==null) {
				request.setAttribute("msg","메이커 넘버 없이 화면 요청은 불가능 합니다.");
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			int mNum = Integer.parseInt(mNumStr);
			request.setAttribute("maker", ms.getMaker(mNum));
		}else if(cmd.equals("makerUpdate")) {
			
		}else if(cmd.equals("makerDelete")) {
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("utf-8");
		if(cmd.equals("makerUpdate")) {
			String mNum = request.getParameter("mNum");
			String mName = request.getParameter("mName");
			String mPrice = request.getParameter("mPrice");
			String mCnt = request.getParameter("mCnt");
			String mDesc = request.getParameter("mDesc");
			Maker mk = new Maker(Integer.parseInt(mNum), 
					mName,
					Integer.parseInt(mPrice),
					Integer.parseInt(mCnt),
					0,
					mDesc
					);
			request.setAttribute("rMap",ms.updateMaker(mk));
		}else if(cmd.equals("makerInsert")) {
			String mName = request.getParameter("mName");
			String mPrice = request.getParameter("mPrice");
			String mCnt = request.getParameter("mCnt");
			String mDesc = request.getParameter("mDesc");
			Maker mk = new Maker(0, 
					mName,
					Integer.parseInt(mPrice),
					Integer.parseInt(mCnt),
					0,
					mDesc
					);
			request.setAttribute("rMap", ms.insertMaker(mk));
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
