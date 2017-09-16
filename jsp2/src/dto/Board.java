package dto;

public class Board {
	private int bNum;
	private String title;
	private String content;
	private String regDate;
	private int writer;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "Board [bNum=" + bNum + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", writer=" + writer + ", userName=" + userName + "]";
	}
}
