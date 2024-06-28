package com.tenco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class jsonParsingTest
 */
public class jsonParsingTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StringBuffer buffer;
    
    public jsonParsingTest() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	System.out.println("json 데이터 불러오기");
    	
    	try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			// 응답 코드 확인
			int responseCode = conn.getResponseCode();
			System.out.println("response code : " + responseCode);
			
			// HTTP 응답 메세지에 데이터를 추출 [] -- Stream ---  []
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			buffer = new StringBuffer();
			while( (inputLine = in.readLine()) != null ) {
				buffer.append(inputLine);
			}
			in.close();
			
			System.out.println(buffer.toString());
			System.err.println("-------------------------------");
			// gson lib 활용 
			// Gson gson = new Gson();
			// Gson gson = new GsonBuilder().setPrettyPrinting().create();
			// Album albumDTO =  gson.fromJson(buffer.toString(), Album.class);
			
			// System.out.println(albumDTO.getId());
			// System.out.println(albumDTO.getUserId());
			// System.out.println(albumDTO.getTitle());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }


	

	@Override
	public void destroy() {

	
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write(""+buffer+"");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
