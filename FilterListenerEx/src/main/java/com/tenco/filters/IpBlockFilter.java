package com.tenco.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;



public class IpBlockFilter implements Filter {

	private static final String BLOCKED_IP_PREFIX = "192.168.1";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("IPBlockFilter 초기화");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//전처리 - 요청자의 ip 확인
		String remoteIp = request.getRemoteAddr();
		System.out.println("Request form Ip : "+remoteIp);
		
		//차단 시킬 코드 작성
		if (remoteIp.startsWith(BLOCKED_IP_PREFIX)) {
			response.setContentType("text/plain;charset=UTF-8");
			response.getWriter().print("Access Denied!!");
			System.out.println(remoteIp + " : 사용자 차단 함");
			return;
		}
		
		chain.doFilter(request, response);
	}

}
