package com.busking.board.service;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.busking.board.model.BoardCustomerDTO;
import com.busking.board.model.BoardCustomerMapper;

import com.busking.util.mybatis.MybatisUtil;
import com.busking.util.paging.PageVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardCustomerServiceImpl implements BoardCustomerService {

	private SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();

	// 리스트 가져오기
	@Override
	public void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 글 목록

		// request
<<<<<<< Updated upstream

=======
		// 페이지 번호 받아오기
		String page = (String)request.getAttribute("page");
		int pageNum = Integer.parseInt(page);
		System.out.println(pageNum);
>>>>>>> Stashed changes
		// DTO

		// 호출하기
		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardCustomerMapper boardMapper = sql.getMapper(BoardCustomerMapper.class);

		// 화면에 리스트 내보내기
		ArrayList<BoardCustomerDTO> noticeList = boardMapper.getList();
		System.out.println("화면에 리스트 나타내기 " + noticeList);
		
		int total = boardMapper.getTotal(); // 페이징 용 전체 글 개수 가져오기
		PageVO pageVO = new PageVO(pageNum, total); // 페이징용 PageVO 객체 생성

		sql.close();

		// response
		request.setAttribute("noticeList", noticeList);
<<<<<<< Updated upstream
		request.getRequestDispatcher("/customer_center/customer_center_index.jsp").forward(request, response);
=======
		request.setAttribute("page", pageVO); // PageVO 객체 넘기기
		request.getRequestDispatcher("customer_center_index.jsp").forward(request, response);
>>>>>>> Stashed changes
	}

	// 글 등록
	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 확인
		System.out.println("글 작성 OK");

		// request
		String managerId = "관리자"; // 관리자 아이디 고정
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");

		// DTO
		BoardCustomerDTO dto = new BoardCustomerDTO(0, managerId, noticeTitle, noticeContent, null, 0);

		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardCustomerMapper boardMapper = sql.getMapper(BoardCustomerMapper.class);

		boardMapper.regist(dto);
		sql.close();

		// 목록화면 보내기
		response.sendRedirect("customer_center_index.customer");

	}

	// 글 내용
	@Override
	public void getContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// a링크로 넘어온 값을 받는다
		String noticeNum = request.getParameter("noticeNum");

		// Mybatis
		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardCustomerMapper boardMapper = sql.getMapper(BoardCustomerMapper.class);

		boardMapper.increaseHit(noticeNum); // 조회수 증가
		BoardCustomerDTO dto = boardMapper.getContent(noticeNum);
		sql.close(); // 마이바티스 세션 종료

		// response
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("customer_center_index_content.jsp").forward(request, response);
		// 자체 페이지 이름으로 포워드 이동

	}

	//글 수정 화면
	@Override
	public void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String noticeNum = request.getParameter("noticeNum");
		
		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardCustomerMapper boardMapper = sql.getMapper(BoardCustomerMapper.class);
		BoardCustomerDTO dto = boardMapper.getContent(noticeNum);
		sql.close(); //마이바티스 세션 종료
		
		//dto를 request에 담고 forward 화면으로 이동
		request.setAttribute("dto", dto);
		request.getRequestDispatcher("customer_center_index_content_modify.jsp").forward(request, response);;
		
	}
	
	//update
	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 확인
		System.out.println("글 수정 확인");

		// request
		String managerId = "관리자"; // 관리자 아이디 고정
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		
		String noticeNum = request.getParameter("noticeNum");


		// DTO
		BoardCustomerDTO dto = new BoardCustomerDTO(0, managerId, noticeTitle, noticeContent, null, 0);
		
		SqlSession sql = sqlSessionFactory.openSession(true);
		BoardCustomerMapper boardMapper = sql.getMapper(BoardCustomerMapper.class);

		boardMapper.update(dto);
		int result = boardMapper.update(dto);
		sql.close(); //close
		
		System.out.println(result);
		
		if(result == 1) { //업데이트 성공
			
			response.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정상 처리 되었습니다!');");
			out.println("location.href='customer_center_index.customer.customer';");
			out.println("</script>");
			
		} else { //업데이트 실패
			
			//다시 수정화면으로
			response.sendRedirect("getContent.customer?noticeNum=" + noticeNum); //content는 bno를 필요로 함
			
		}
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
