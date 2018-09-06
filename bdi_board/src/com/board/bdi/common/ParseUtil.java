package com.board.bdi.common;

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
}
