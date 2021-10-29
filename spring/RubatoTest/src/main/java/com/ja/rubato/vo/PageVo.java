package com.ja.rubato.vo;

public class PageVo {

	private int start;
	private int end;
	private int total;
	private int totalPage;
	
	public PageVo() {
		// TODO Auto-generated constructor stub
	}

	public PageVo(int start, int end, int total, int totalPage) {
		super();
		this.start = start;
		this.end = end;
		this.total = total;
		this.totalPage = totalPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	
	
	
	
}
