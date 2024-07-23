package com.busking.board.controller;

import java.io.IOException;

import com.busking.board.service.BoardCommentService;
import com.busking.board.service.BoardCommentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.comment")
public class BoardCommentController extends HttpServlet {
	
	public BoardCommentController() {
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String command = uri.substring(path.length());
	
		System.out.println(command);
		
		String subject = request.getParameter("subject");
		
		BoardCommentService service;
		
		if(command.equals("/board/board_comment_list.comment") && subject.equals("free")) {
			service = new BoardCommentServiceImpl();
			service.getCommentFreeList(request, response);
			
		} else if(command.equals("/board/board_comment_list.comment") && subject.equals("news")) {
			service = new BoardCommentServiceImpl();
			service.getCommentNewsList(request, response);
			
		} else if(command.equals("/board/board_comment_list.comment") && subject.equals("team")) {
			service = new BoardCommentServiceImpl();
			service.getCommentTeamList(request, response);
			
		} else if(command.equals("/board/board_comment_write.comment") && subject.equals("free")) {
			service = new BoardCommentServiceImpl();
			service.writeCommentFree(request, response);
			
		} else if(command.equals("/board/board_comment_write.comment") && subject.equals("news")) {
			service = new BoardCommentServiceImpl();
			service.writeCommentNews(request, response);
			
		} else if(command.equals("/board/board_comment_write.comment") && subject.equals("team")) {
			service = new BoardCommentServiceImpl();
			service.writeCommentTeam(request, response);
			
		}
	}
}
