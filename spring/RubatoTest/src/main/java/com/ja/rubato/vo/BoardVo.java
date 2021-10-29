package com.ja.rubato.vo;

import java.util.Date;

public class BoardVo {

	private int no;
	private int member_no;
	private String title;
	private String content;
	private int readCount;
	private Date writeDate;
	
	public BoardVo() {
		// TODO Auto-generated constructor stub
	}

	public BoardVo(int no, int member_no, String title, String content, int readCount, Date writeDate) {
		super();
		this.no = no;
		this.member_no = member_no;
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.writeDate = writeDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
}
