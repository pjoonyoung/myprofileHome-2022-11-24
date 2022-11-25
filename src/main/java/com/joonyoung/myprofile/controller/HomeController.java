package com.joonyoung.myprofile.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joonyoung.myprofile.dao.IDao;
import com.joonyoung.myprofile.dto.MemberDto;
import com.joonyoung.myprofile.dto.QBoardDto;

@Controller
public class HomeController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping("/question")
	public String question(HttpSession session, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String sessionId = (String) session.getAttribute("memberId");
		
		if(sessionId == null) {
			model.addAttribute("memberId", "GUEST");
		} else {
			model.addAttribute("memberId", sessionId);
		}
		
		return "question";
	}
	
	@RequestMapping("/questionOk")
	public String questionOk(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String qid = request.getParameter("qid");//글쓴 유저 아이디
		String qname = request.getParameter("qname");//글쓴 유저 이름
		String qcontent = request.getParameter("qcontent");//글쓴 내용
		String qemail = request.getParameter("qemail");//글쓴 유저 이메일
		
		dao.writeQuestion(qid, qname, qcontent, qemail);
		
		return "redirect:list";
	}
	
	@RequestMapping("joinOk")
	public String joinOk(HttpServletRequest request, HttpSession session, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		int joinFlag = dao.memberJoin(mid, mpw, mname, memail);
		//joinFlag값이 1이면 회원가입 성공, 아니면 실패
		
		if(joinFlag == 1) {//회원가입성공시 바로 로그인 진행
			session.setAttribute("memberId", mid);
			session.setAttribute("memberName", mname);
			
			model.addAttribute("mname", mname);
			model.addAttribute("mid", mid);
			
			return "joinOk";
		
		} else { //회원가입 실패
			return "joinFail";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "login";
	}
	
	@RequestMapping("/loginOk")
	public String loginOk(HttpServletRequest request, HttpSession session, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		int checkIdFlag = dao.checkId(mid);
		//로그인 하려는 아이디가 존재시 1, 로그인 아이디가 존재하지않으면 0 
		
		int checkIdPwFlag = dao.checkIdAndPw(mid, mpw);
		//로그인 하려는 아이디와 비밀번호가 모두 일치하면 1 아니면 0
		
		model.addAttribute("checkIdFlag", checkIdFlag);
		
		model.addAttribute("checkIdPwFlag", checkIdPwFlag);
		
		if(checkIdPwFlag == 1) {//로그인 실행
			session.setAttribute("memberId", mid);
			
			MemberDto memberDto = dao.getMemberInfo(mid);
			
			model.addAttribute("memberDto", memberDto);
			model.addAttribute("mid", mid);
		}
		
		return "loginOk";
	}
	
	@RequestMapping("memberModify")
	public String memberModify(HttpSession session, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String sessionid = (String) session.getAttribute("memberId");
		
		MemberDto memberdto = dao.getMemberInfo(sessionid);
		
		model.addAttribute("memberdto", memberdto);
		
		return "memberModify";
	}
	
	@RequestMapping("memberModifyOk")
	public String memberModifyOk(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String mdate = request.getParameter("mdate");
		
		dao.memberModify(mid, mpw, mname, memail, mdate);
		
		MemberDto memberdto = dao.getMemberInfo(mid);//수정된 회원정보 다시 가져오기 
		
		model.addAttribute("memberDto", memberdto);
		
		return "memberModifyOk";
	}
	
	@RequestMapping ("/list")
	public String list(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		List<QBoardDto> qboardDto = dao.questionList();
		
		model.addAttribute("qdtos", qboardDto);
		
		return "questionlist";
	}
	
}
