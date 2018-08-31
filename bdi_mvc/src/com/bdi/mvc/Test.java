package com.bdi.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FileItem{
	String name;
	String string;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	
}
public class Test {
	public static void main(String[] args) {
		List<FileItem> fList = new ArrayList<FileItem>();
		FileItem fi = new FileItem();
		fi.setName("gcName");
		fi.setString("카트라이더");
		fList.add(fi);
		
		fi = new FileItem();
		fi.setName("gcPrice");
		fi.setString("10000");
		fList.add(fi);
		
		
		Map<String,String> param = new HashMap<String,String>();
		for(FileItem ff:fList) {
			param.put(ff.getName(), ff.getString());
		}
		
		System.out.println(param.get("gcName"));
	}
}
