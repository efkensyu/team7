package com.example.demo.team7.service;
//赤坂

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team7.entity.Team7NewAccount;
import com.example.demo.team7.repositories.Team7NewAccountRepositories;

@Service
public class Team7LNewAccountService {

    private Team7NewAccountRepositories repository;

    public boolean AccountCheck(String userCd, String userPw) {

        List<Team7NewAccount> list = repository.findByNewUserCd(userCd);

        // ユーザーが存在しない場合
        if (list == null || list.isEmpty()) {
            return true;
        } else {
        	return false;
        }
    }
}