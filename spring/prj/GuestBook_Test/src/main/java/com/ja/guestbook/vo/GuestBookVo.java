package com.ja.guestbook.vo;

import java.util.Date;

public class GuestBookVo {

	private int no;
	private String nick; 
	private String content;
	private String password;
	private Date writedate;
	
	public GuestBookVo() {
		
	}

	public GuestBookVo(int no, String nick, String content, String password, Date writedate) {
		super();
		this.no = no;
		this.nick = nick;
		this.content = content;
		this.password = password;
		this.writedate = writedate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	
}
