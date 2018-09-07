package com.board.bdi.common;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class ParseUtil {

    public static <T> T parseRequest(HttpServletRequest request, Class<T> clazz) throws ServletException {
    	T t = null;
		try {
			t = (T)clazz.newInstance();
			BeanUtils.populate(t, request.getParameterMap());
		} catch (Exception e) {
			throw new ServletException("파싱에러 : " + e);
		}
    	return t;
    }

    public static <T> T parseMap(Map<String, ? extends Object> map, Class<T> clazz) throws ServletException {
    	T t = null;
		try {
			t = (T)clazz.newInstance();
			BeanUtils.populate(t,map);
		} catch (Exception e) {
			throw new ServletException("파싱에러 : " + e);
		}
    	return t;
    }
}
