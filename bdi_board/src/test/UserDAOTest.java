package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.board.bdi.common.DBCon;
import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;
import com.board.bdi.vo.UserInfoVO;

class UserDAOTest {
	@Test
	void selectUserTest() {
		UserDAO udao = new UserDAOImpl();
		udao.setCon(DBCon.getCon());
		try {
			UserInfoVO ui = new UserInfoVO();
			UserInfoVO rUi = udao.selectUser(ui);
			assertEquals(rUi, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	void insertUserTest() {
		UserDAO udao = new UserDAOImpl();
		udao.setCon(DBCon.getCon());
		try {
			UserInfoVO ui = new UserInfoVO();
			ui.setUiid("test");
			ui.setUiname("홍길동");
			ui.setUipwd("r1r2r3");
			ui.setUiemail("test@naver.com");
			int cnt = udao.insertUser(ui);
			DBCon.commit();
			assertEquals(cnt, 0);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		
	}
}
