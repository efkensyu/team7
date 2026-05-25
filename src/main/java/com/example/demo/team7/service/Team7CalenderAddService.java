package com.example.demo.team7.service;
//赤坂

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.demo.team7.entity.Team7CalenderAdd;
import com.example.demo.team7.repositories.Team7CalenderAddRepositories;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Team7CalenderAddService {

    private final Team7CalenderAddRepositories repository;

    public void add(String userId, String data, String sche, String detail) {

        // エンティティ（箱）のインスタンスを作成
        Team7CalenderAdd add = new Team7CalenderAdd();
        
        // 画面から渡ってきた値をエンティティにセット
        // （※セッター名は Team7NewAccount クラスの定義に合わせて適宜変更してください）
        add.setUserId(userId);
        add.setYoteiDt(LocalDate.parse(data));
        add.setYoteiNm(sche);
        add.setYoteiDetail(detail);
        
        // リポジトリの標準機能「saveメソッド」を使ってDBに保存（INSERT）する
        repository.save(add);
    }
    
}