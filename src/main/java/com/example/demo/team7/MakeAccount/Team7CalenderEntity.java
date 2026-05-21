package com.example.demo.team7.MakeAccount;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="yotei_tbl")
public class Team7CalenderEntity {
	
	@Id
	private String yoteiCd;  //予定のID(管理用)
	private String yoteiNm;  //予定の名前
	private String yoteiDetail;  //予定の詳細
	private Integer userId;  //ユーザーID
	private Date yoteiDt; //日付

}
