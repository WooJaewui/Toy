package com.ja.rubato.vo;

public class MemberVo {

	private int no;
	private String id;
	private String pw;
	private String nick;
	
	public MemberVo() {
		super();
	}

	public MemberVo(int no, String id, String pw, String nick) {
		super();
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
}
