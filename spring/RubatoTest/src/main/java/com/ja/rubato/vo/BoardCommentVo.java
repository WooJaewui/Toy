package com.ja.rubato.vo;

import java.util.Date;

public class BoardCommentVo {

	private int no;
	private int board_no;
	private int member_no;
	private String comment;
	private Date date;
	
	public BoardCommentVo() {
		// TODO Auto-generated constructor stub
	}

	public BoardCommentVo(int no, int board_no, int member_no, String comment, Date date) {
		super();
		this.no = no;
		this.board_no = board_no;
		this.member_no = member_no;
		this.comment = comment;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
