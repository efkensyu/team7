package com.example.demo.team7.service;
//赤坂

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team7.entity.Team7Account;
import com.example.demo.team7.repositories.Team7LoginRepositories;

@Service
public class Team7LoginService {

    private Team7LoginRepositories repository;

    public boolean loginCheck(String userCd, String userPw) {

        List<Team7Account> list = repository.findByUserCd(userCd);

        // ユーザーが存在しない
        if (list == null || list.isEmpty()) {
            return false;
        }

        Team7Account account = list.get(0);

        // パスワード一致チェック
        return account.getUserPw().equals(userPw);
    }
}