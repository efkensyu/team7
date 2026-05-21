package com.example.demo.team7.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_tbl")
@Data
public class Team7NewAccount {
	@Id
	private String NewuserCd;
	private String NewuserPw;
}
