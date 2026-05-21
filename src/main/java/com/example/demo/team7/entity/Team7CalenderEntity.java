package com.example.demo.team7.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="yotei_tbl")
public class Team7CalenderEntity {
	
	@Id
	private String yoteiCd;  //予定のID(管理用)
	@NotBlank(message="予定名を入力してください")
	@Size(max=30,message="予定名は30文字以内にしてください")
	private String yoteiNm;  //予定の名前
	@Size(max=300,message="予定名は300文字以内にしてください")
	private String yoteiDetail;  //予定の詳細
	private Integer userId;  //ユーザーID
	@NotBlank(message="日付を入力してください")
	private Date yoteiDt; //日付

}
