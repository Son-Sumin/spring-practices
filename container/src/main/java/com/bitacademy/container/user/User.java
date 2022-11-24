package com.bitacademy.container.user;


// 수동 확인 중, @ 안 달았음
public class User {
	private long no = 0L;
	private String name = "마이콜";
	private Friend friend;
	/* 마지막 필드로 인해 User가 friend라는 변수로 참조하고 있는 DI 발생 */	
	
	
	// 아래에 파라미터가 1개인 생성자를 만들면서 기본 생성자 따로 만들어야함
	public User() {	
	}
	
	// 파라미터가 1개인 생성자
	public User(String name) {
		this.name = name;
	}
	
	// 파라미터가 2개인 생성자
	public User(Long no, String name) {
		this.no = no;
		this.name = name;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", friend=" + friend + "]";
	}
}
