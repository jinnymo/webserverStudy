package com.tenco.filters;

import java.io.IOException;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

/**
 * 필터 클래스 만드는 법 
 * 1. jakarta.servlet.Filter 를 구현해야 한다. (톰캣 10번전이 아니면
 * javax.servlet.Filter) 사용할수 있다
 * 2. URL 패턴을 설정해야 한다.(web.xml || @어노테이션 기반 설정가능)
 * 
 */
@WebFilter(urlPatterns = "/*", dispatcherTypes = {DispatcherType.REQUEST})
public class SimpleFilter implements Filter {

	// 필터가 생성될 때 초기화 작업을 수행하는 메서드
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필요하다면 초기화 코드 작성
		System.out.println("SimpleFilter 초기화 ");
	}
	
	//특정 URL 요청이 들어올 때 실행(통과) 되는 메서드 이다.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("SimpleFilter doFilter() 메서드 호출됨.");
		// 다음 필터로 또는 서블릿으로 요청, 응답 객체를 전달한다.
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		System.out.println("종료될때 호출 되는 메서드");
	}
}
