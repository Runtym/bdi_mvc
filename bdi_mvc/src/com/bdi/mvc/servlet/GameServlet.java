package com.bdi.mvc.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.common.UploadFiles;
import com.bdi.mvc.service.GameService;
import com.bdi.mvc.service.impl.GameServiceImpl;
import com.bdi.mvc.vo.Game;

/*
 * web.xml에 해당 서블릿이 등록 되어 있어야 함.
 * 
  <servlet>
    <servlet-name>GameServlet</servlet-name>
    <servlet-class>com.bdi.mvc.servlet.GameServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>GameServlet</servlet-name>
    <url-pattern>/game/*</url-pattern>
  </servlet-mapping>
  
  url-pattern은 클라어인트의 요청에 대한 패턴으로 예를들어
	  localhost/game/abc
	  localhost/game
	  localhost/game/1
	  localhost/game/1/2/3
     위의 url-pattern모두 GameServlet을 호출한다.
  localhost이후부터 /game/ <--이 들어가 있으면 만족함.
 */
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//서블릿에서 필요한 서비스를 생성한다.
	private GameService gs = new GameServiceImpl();
	private String uri;
	
	//doGet 메소드는 클라이언트에서 get방식으로 보냈을때 실행되는 함수이다.
	//예를들어 localhost/game/gameList 라는 url로 method방식을 get으로 요청할경우
	//web.xml에 기술되어있는 url-pattern /game/*을 만족하기 때문에
	//GameServlet을 생성(생성되어있을경우엔 다시 생성안함) 하고
	// doGet메소드를 자동으로 호출한다.
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri = req.getRequestURI();
		//클라이언트의 요청이 무엇인지 판단하기 위해 마지막 '/'를 기준으로 uri를 잘라준다.
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
		try {
			//클라이언트의 요청이 gameList일경우(uri : localhost/game/gameList)
			if(cmd.equals("gameList")) {
				//게임서비스에서 game리스트를 리턴하는 함수를 호출해준다.
				List<Game> gameList = gs.selectGameList(null);
				//해당 리스트를 포워딩할 jsp에서 포문을 돌리며 출력해주기위해
				//gmaeList라는 키값을 저장한다.
				req.setAttribute("gameList", gameList);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//최하단에 있는 doService 메소드를 호출한다.
		doService(req,res);
	}

	//doPost 메소드는 클라이언트에서 post방식으로 보냈을때 실행되는 함수이다.
	//예를들어 localhost/game/gameList 라는 url로 method방식을 post으로 요청할경우
	//web.xml에 기술되어있는 url-pattern /game/*을 만족하기 때문에
	//GameServlet을 생성(생성되어있을경우엔 다시 생성안함) 하고
	//doPost메소드를 자동으로 호출한다.
	//위의 설명된것과 같이 똑같은 url로 호출한다고 하더라도
	//클라이언트의 method방식에 따라 doGet//doPost가 실행된다.
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri = req.getRequestURI();
		//클라이언트의 요청이 무엇인지 판단하기 위해 마지막 '/'를 기준으로 uri를 잘라준다.
		String cmd = uri.substring(uri.lastIndexOf("/") + 1);
		req.setCharacterEncoding("utf-8");
		try {
			//클라이언트의 요청이 gameList일경우(uri : localhost/game/gameList)
			if(cmd.equals("gameInsert")) {
				Map<String,String> param = UploadFiles.saveFileList(req);
				if(param.isEmpty()) {
					new ServletException("파일 저장이 실패하였습니다.");
				}
				String gcName = param.get("gcName");
				String gcPrice = param.get("gcPrice");
				String gcVendor = param.get("gcVendor");
				String gcDesc = param.get("gcDesc");
				String gcImg = param.get("gcImg");
				Game game = new Game(null,
						gcName,
						Integer.parseInt(gcPrice),
						gcVendor,
						null,
						gcDesc,
						gcImg
						);
				//게임서비스에서 game목록을 인서트 함수를 호출해준다.
				Map<String,Object> rMap = gs.insertGame(game);
				//해당 리스트를 포워딩할 jsp에서 포문을 돌리며 출력해주기위해
				//rMap라는 키값을 저장한다.
				req.setAttribute("rMap", rMap);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//최하단에 있는 doService 메소드를 호출한다.
		doService(req,res);
		doService(req,res);
	}
	
	private void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//클라이언트에서 요청한 uri앞에 '/views'를 붙여서 포워딩해준다.
		//'/views'를 붙이는 이유는 ViewServlet을 호출하기 위해서임.
		RequestDispatcher rd = req.getRequestDispatcher("/views" + uri);
		rd.forward(req, res);
	}

}
