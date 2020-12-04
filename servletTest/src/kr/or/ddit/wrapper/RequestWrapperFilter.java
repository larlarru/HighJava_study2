package kr.or.ddit.wrapper;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestWrapperFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// RequestWrapperTest객체 생성
		// request쓰면 오르나는데 왜나하면 밑에 request가 자식이 부모를 쓸려하기 때문에 오류난다. 그러니 형벼노한해야한다.
		RequestWrapperTest requestWrapper = new RequestWrapperTest((HttpServletRequest) request);
		
		// 만약 ResponseWapper객체도 등록하려면 이 곳에서 같이 생성한다.
		
		// 필터의 체이닝에서 원래의 Request객체 대신 RequestWrapper객체를 인수로 넣어준다.
		//chain.doFilter(request, response);
		chain.doFilter(requestWrapper, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
