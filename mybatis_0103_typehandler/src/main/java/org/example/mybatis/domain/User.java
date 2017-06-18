package org.example.mybatis.domain;

public class User {

	private Long userId;
    private String userName;
    private String password;
    private String comment;
    private Sex sex;
    private Sex sex2;
    private Sex sex3;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Sex getSex2() {
		return sex2;
	}

	public void setSex2(Sex sex2) {
		this.sex2 = sex2;
	}

	public Sex getSex3() {
		return sex3;
	}

	public void setSex3(Sex sex3) {
		this.sex3 = sex3;
	}
}
