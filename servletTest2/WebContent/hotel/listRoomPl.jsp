<%@page import="kr.or.ddit.hotel.vo.HotelVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<HotelVO> list = (List<HotelVO>) request.getAttribute("list");
%>

[
	<%
		for(int i=0; i < list.size(); i++) {
			
			HotelVO vo = list.get(i);
			
	%>
			{
				"room_pl" : "<%= vo.getRoom_pl() %>",
			}
	<%		
		}
	%>
]




















    