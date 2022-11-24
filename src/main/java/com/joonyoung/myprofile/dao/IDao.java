package com.joonyoung.myprofile.dao;

import java.util.ArrayList;

import com.joonyoung.myprofile.dto.MemberDto;

public interface IDao {
	public int memberJoin(String mid, String mpw, String mname, String memail);//회원가입 insert
	public ArrayList<MemberDto> memberLogin(String mid);
}
