package com.example.demo.team7.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="team7_yotei_tbl")
public class Team7CalenderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String yoteiCd;  //予定のID(管理用)
//	@NotBlank(message="予定名を入力してください")
	private String yoteiNm;  //予定の名前
	private String yoteiDetail;  //予定の詳細
	private String userId;  //ユーザーID
	private LocalDate yoteiDt; //日付

}
