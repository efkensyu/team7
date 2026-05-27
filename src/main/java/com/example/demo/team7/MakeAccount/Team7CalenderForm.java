package com.example.demo.team7.MakeAccount;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class Team7CalenderForm {
	private String user; //ユーザーID
	@NotBlank(message="日付を入力しようね")
	private String data; //日付
	@Size(max=30,message="予定名は30文字以内にしてね")
	private String sche; //予定名
	@Size(max=300,message="詳細は300文字以内にしてね")
	private String detail;  //予定詳細
	private String id; //予定ID
	

}
