package kr.or.ddit.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet으로 파일 다운로드 구현하기
 * 1. response객체의 setContentType()메서드에
 *  "application/octet-stream; charset="utf-8""을 설정한다.
 * 
 * 2. response객체의 setHeader()메서드에
 * 		key값으로 "Content-Disposition"을 지정하고
 * 		value값으로 "attachment; filename=\"파일명"\"을 지정한다.
 * 		(위의 value값에서 '파일명'은  클라이언트에 저장될 파일명이 된다.)
 * 
 * 3. FileInputStream객체를 이용하여 서버에서 파일을 읽어
 * 		response객체의 getOutputStream()메서드로 구한 OutputStream객체로 출력한다.
 * 
 *------------------------------------------------------------------------
 *만약 다운 받을 파일이 서버에 없으면
 *	ContentType을 'text/html; charset=utf-8로 설정하고'
 *	'다운받을 파일이 없습니다.'라는 메시지를 응답으로 전달한다.
 *
 */
@WebServlet("/filedownloadServlet.do")
public class FiledownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final int BUFFFER_SIZE = 1024*10;	// 100kb크기
	private final String UPLOAD_DIR = "d:/d_other/uploadFiles";	// 파일이 저장될 폴더명
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터로 넘어온 파일명을 얻는다.
		String fileName = request.getParameter("fileName");
		
		String filePath = UPLOAD_DIR + File.separator + fileName;
		
		File file = new File(filePath);
		
		OutputStream out = null;	// 파일 출력용
		FileInputStream fin = null;	// 파일 입력용
		
		if(file.exists()) {	// 전송할 파일이 있으면...
			
			try {
				// ContentType 설정
				response.setContentType("application/octet-stream; charset=utf-8");
				
				// Response의 헤더에 Content-Disposition 속성 설정하기
				String headerKey = "Content-Disposition";
				//String headerValue = 
						//String.format("attachement; filename=\"%s\"", fileName);
			
				String headerValue =  
						String.format("attachement; filename=\"%s\"", getDisposition(fileName, getBrowser(request)));
				response.setHeader(headerKey, headerValue);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
			try {
				
				// 출력용 스트림 객체 구하기 ==> Response객체 이용
				out = response.getOutputStream();
				
				// 파일 입력용 스트림 객체 생성
				fin = new FileInputStream(file);
				
				// 파일 내용을 읽어서 저장할 byte형 배열 생성
				byte[] buffer = new byte[BUFFFER_SIZE];
				
				int len = -1;	// 실제 읽어온 byte 수가 저장될 변수
				
				// byte형 배열을 이용해서 파일 내용을 읽어와 출력용 스트림 객체로 출력한다.
				while((len=fin.read(buffer))!= -1) {
					
					out.write(buffer, 0, len);
				}
				
				out.flush();
				
			} catch (IOException e) {
				
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {	// 자원 반납
				if(fin!=null) try { fin.close(); } catch(IOException e) {}
				if(out!=null) try { out.close(); } catch(IOException e) {}
			}
			
		} else {	// 다운 받을 파일이 서버에 없으면...
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>" + fileName + " 파일은 존재하지 않습니다.</h3>");
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// 클라이언트(사용자)의 웹브라우저 종류를 반환하는 메서드
	private String getBrowser(HttpServletRequest request) {
		
		// 파일 내용을 읽어서 저장할 byte형 배열 생성
		String header = request.getHeader("User-Agent");	// User-Agent헤더값 구하기
		
		System.out.println("User-Agent ==> " + header);
		
		if(header.indexOf("MSIE") > -1) {	// 익스플로러
			return "MSIE";
		} else if(header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if(header.indexOf("Opera") > -1) {
			return "Opera";
		} else if(header.indexOf("Trident/7.0") > -1) {	// IE 11이상
			return "MSIE";
		}
		
		return "Firefox";
		
	}
	
	// 웹브라우저 별로 한글 파일명을 인코딩 변환하여 반환하는 메서드
	private String getDisposition(String filename, String browser) throws Exception {
		
		String encodingFilename = null;
		if(browser.equals("MSIE")) {
			encodingFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if(browser.equals("Firefox")) {
			encodingFilename = "\"" + new String(filename.getBytes("utf-8"), "8859_1") + "\"";	// 8859_1 영문 전용 코드
		} else if(browser.equals("Opera")) {
			encodingFilename = "\"" + new String(filename.getBytes("utf-8"), "8859_1") + "\"";	// 8859_1 영문 전용 코드
		} else if(browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<filename.length(); i++) {
				char c = filename.charAt(i);
				if(c>'~') {	// 아스키 코드 중 제일 마지막 문자 ==> ~
					sb.append(URLEncoder.encode("" + c, "utf-8"));
				} else {
					sb.append(c);
				}
			}
			encodingFilename = sb.toString();
		} else {	// 지정된 웹브라우저가 아닐 경우 exception 발생
			throw new RuntimeException("지원되지 않는 웹브라우저 입니다.");
		}
		
		return encodingFilename;
	}
	
	
	
	
	
}
