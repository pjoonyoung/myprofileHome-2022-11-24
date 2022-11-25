package com.joonyoung.myprofile.dao;

import java.util.List;

import com.joonyoung.myprofile.dto.MemberDto;
import com.joonyoung.myprofile.dto.QBoardDto;

public interface IDao {
	//회원관리
	public int memberJoin(String mid, String mpw, String mname, String memail);//회원가입 insert
	public int checkId(String mid);//아이디 존재여부 확인 select
	public int checkIdAndPw(String mid, String mpw);//아이디와 비밀번호의 존재 및 일치 여부 select
	public MemberDto getMemberInfo(String mid);//아이디로 조회하여 회원정보 가져오기 select
	public void memberModify(String mid, String mpw, String mname, String memail, String mdate);//회원정보 수정 update
	
	//질문 게시판
	public void writeQuestion(String qid, String qname, String qcontent, String qemail);//질문하기 insert
	public List<QBoardDto> questionList();//질문게시판 리스트 가져오기 select
	public QBoardDto questionView(String qnum);//선택한 글 번호의 정보 가져오기 select
	public void questionModify(String qnum, String qname, String qcontent, String qemail);//해당 글 번호로 조회하여 질문수정 update
	public void questionDelete(String qnum);//해당 글 번호로 조회하여 글 삭제 delete
}
