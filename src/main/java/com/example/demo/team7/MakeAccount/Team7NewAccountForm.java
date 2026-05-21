package com.example.demo.team7.MakeAccount;
//もりもと

import lombok.Data;

@Data
public class Team7NewAccountForm {
	private String NewID;
	private String Newpassword;
	
	public String getUserCd() {
		return NewID;
	}
	public String getUserPw() {
		return Newpassword;
	}

}
