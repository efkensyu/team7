package com.example.demo.team7.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team7_user_tbl")
@Data
public class Team7NewAccount {
	 @Id
	    @Column(name = "user_cd")
	    private Integer newuserCd;

	    @Column(name = "user_pw")
	    private String newuserPw;
}
