package com.tenco.listeners;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.ServletRegistration.Dynamic;
import jakarta.servlet.SessionCookieConfig;
import jakarta.servlet.SessionTrackingMode;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.descriptor.JspConfigDescriptor;

/**
 * 리스너 사용해 보기 ServletContext 를 구현 해야 한다. 
 * 동작 트리거, web.xml 파일과 어노테이션 기반으로 설정가능하다.
 */
@WebListener
public class AppLifecycleListener implements ServletContextListener {
	
	private static final Logger LOGGER = Logger.getLogger(AppLifecycleListener.class.getName());
	
	private String timeFormat() {
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		
		String now = sdf1.format(System.currentTimeMillis());
		
		return now;
	}
	
	
	//애플리케이션이 언제 시작을 했는지 로그, 파일로 남겨야 될 때 사용한다라고 가정하자.
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("-----------------------");
		LOGGER.info("웹 애플리케이션 시작됨 >>>" + timeFormat());
		System.out.println("-----------------------");	
		System.out.println();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("-----------------------");
		LOGGER.info("웹 애플리케이션 종료됨 >>>" + System.currentTimeMillis());
		System.out.println("-----------------------");
		System.out.println();
	}
}
