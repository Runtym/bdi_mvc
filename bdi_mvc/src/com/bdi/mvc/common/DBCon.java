package com.bdi.mvc.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	
	private static Properties prop;
	private static Connection con;
	static {
		prop = new Properties();
		String path = "/config/db.properties";
		InputStream is = DBCon.class.getResourceAsStream(path);
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			String line;
			StringBuffer response = new StringBuffer(); 
			while((line = rd.readLine()) != null) {
			 response.append(line);
			 response.append('\r');
			}
			System.out.println(response.toString());
			rd.close();


//			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Connection getCon() {
		if(con==null) {
			try {
				Class.forName(prop.getProperty("driver"));
				con = DriverManager.getConnection(
						prop.getProperty("url"), prop.getProperty("id"), 
						prop.getProperty("pwd"));
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	public static void close() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		con = null;
	}
	public static void main(String[] args) {
		DBCon dbc = new DBCon();
	}
}
