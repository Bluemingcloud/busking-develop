package com.busking.board.model;

import java.sql.Timestamp;

public class BoardAskDTO {
	
	private String askNum;
	private String askWriter;
	private String askContent;
	private Timestamp askRegdate;
	private int askHit;
	
	public BoardAskDTO() {
	}

	public BoardAskDTO(String askNum, String askWriter, String askContent, Timestamp askRegdate, int askHit) {
		super();
		this.askNum = askNum;
		this.askWriter = askWriter;
		this.askContent = askContent;
		this.askRegdate = askRegdate;
		this.askHit = askHit;
	}

	public String getAskNum() {
		return askNum;
	}

	public void setAskNum(String askNum) {
		this.askNum = askNum;
	}

	public String getAskWriter() {
		return askWriter;
	}

	public void setAskWriter(String askWriter) {
		this.askWriter = askWriter;
	}

	public String getAskContent() {
		return askContent;
	}

	public void setAskContent(String askContent) {
		this.askContent = askContent;
	}

	public Timestamp getAskRegdate() {
		return askRegdate;
	}

	public void setAskRegdate(Timestamp askRegdate) {
		this.askRegdate = askRegdate;
	}

	public int getAskHit() {
		return askHit;
	}

	public void setAskHit(int askHit) {
		this.askHit = askHit;
	}

}
