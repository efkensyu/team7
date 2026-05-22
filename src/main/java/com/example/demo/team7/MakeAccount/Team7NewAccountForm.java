package com.example.demo.team7.MakeAccount;
//もりもと

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class Team7NewAccountForm {
	
    @NotBlank(message = "IDを入力してください。")
    @Size(min = 4, max = 8, message = "IDは4文字以上8文字以内です。")
	private String userCd;
    
    @NotBlank(message = "パスワードを入力してください。")
    @Size(min = 8, max = 20, message = "パスワードは8文字以上20文字以内です。")
	private String userPw;
	
	public String getUserCd() {
		return userCd;
	}
	public String getUserPw() {
		return userPw;
	}

}
