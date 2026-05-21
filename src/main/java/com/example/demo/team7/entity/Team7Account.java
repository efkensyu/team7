package com.example.demo.team7.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "user_tbl")
@Data
public class Team7Account {
	@Id
	@NotBlank(message = "未入力項目があります。")
	private String userCd;
	@NotBlank(message = "未入力項目があります。")
	@Size(min = 8, max = 20, message = "パスワードは8～20桁で入力してください")
	private String userPw;
}
