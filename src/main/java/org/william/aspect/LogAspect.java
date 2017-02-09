package org.william.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.william.util.LoggerUtil;
import org.william.util.NetworkUtil;

import com.alibaba.fastjson.JSON;

@Aspect
@Component
@Order(5)
public class LogAspect {
	
	 ThreadLocal<Long> startTime = new ThreadLocal<Long>();

	    @Pointcut("execution(public * org.william.controller..*.*(..))")
	    public void dfpLog() {
	    	
	    }

	    @Before("dfpLog()")
	    public void doBefore(JoinPoint joinPoint) throws Throwable {
	        startTime.set(System.currentTimeMillis());

	        // 接收到请求，记录请求内容
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();
	        // 记录下请求内容
	        LoggerUtil.info(this, String.format("[%s] start, remoteAddr: %s, request parameters: %s", request.getRequestURI(), NetworkUtil.getIpAddress(request), JSON.toJSONString(request.getParameterMap())));
	    }
	    // 处理完请求，返回内容
	    @AfterReturning(returning = "data", pointcut = "dfpLog()")
	    public void doAfterReturning(Object data) throws Throwable {
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        HttpServletRequest request = attributes.getRequest();
	        long took = System.currentTimeMillis() - startTime.get();

	        LoggerUtil.info(this, String.format("[%s] end, took: %s, response: %s", request.getRequestURI(), took, JSON.toJSONString(data)));
	    }

}
