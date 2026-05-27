package com.example.demo.team7.MakeAccount;
//もりもと

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Team7Form {
	@NotBlank(message = "IDを入力してください。")
    @Pattern(regexp = "^[0-9]{4,8}$", message = "IDは4〜8桁の数字で入力してください")
	private String userCd;
	
	@NotBlank(message = "パスワードを入力してください。")
    @Pattern(regexp="^(|.{8,20})$", message = "パスワードは8文字以上20文字以内です。")
	private String userPw;

}
