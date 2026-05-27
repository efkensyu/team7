package com.example.demo.team7.MakeAccount;
//もりもと

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Team7Form {
	@NotBlank(message = "IDをきめてね。")
    @Pattern(regexp= "^(|.{4,8})$", message = "IDは4文字以上8文字以内でおねがいね。")
	private String userCd;
	
	@NotBlank(message = "パスワードをきめてね。")
    @Pattern(regexp="^(|.{8,20})$", message = "パスワードは8文字以上20文字以内だよ。")
	private String userPw;

}
