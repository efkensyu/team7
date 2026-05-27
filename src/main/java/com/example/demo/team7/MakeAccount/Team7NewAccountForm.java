package com.example.demo.team7.MakeAccount;
//もりもと

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Team7NewAccountForm {
	
	@NotBlank(message = "IDを決めてね")
    @Pattern(regexp = "^[0-9]{4,8}$", message = "IDは4〜8桁の数字にしてね")
    private String userCd;
    
    @NotBlank(message = "パスワードをきめてね。")
    @Pattern(regexp="^(|.{8,20})$", message = "パスワードは8文字以上20文字以内にしてね。")
	private String userPw;
	
	public String getUserCd() {
		return userCd;
	}
	public String getUserPw() {
		return userPw;
	}

}
