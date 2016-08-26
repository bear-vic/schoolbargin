/**
 * @description 全局异常处理类
 * @date 2016-8-17
 * @author hxg	
 */
package com.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
public class ExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ExceptionCommon common = null;
		if (ex instanceof ExceptionCommon) {
			common = (ExceptionCommon) ex;
		} else {
			common = new ExceptionCommon("未知错误");
		}
		ModelAndView model = new ModelAndView();
		model.addObject("error", common.getMessage());
		model.setViewName("error");
		return model;
	}
}
