package com.example.demo.team7.service;
//赤坂

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import org.springframework.stereotype.Service;

import com.example.demo.team7.entity.Team7NewAccount;
import com.example.demo.team7.repositories.Team7NewAccountRepositories;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Team7LNewAccountService {

    private final Team7NewAccountRepositories repository;

    public boolean AccountCheck(int userCd, String userPw) {

    	List<Team7NewAccount> list = repository.findNewuserCd(userCd);

        // ユーザーが存在しない場合
        if (list == null || list.isEmpty()) {
            return true;
        } else {
        	return false;
        }
    }
    // ★3: 追加：データベース（user_tbl）にデータを保存するメソッド
    public void registerAccount(@NotBlank(message = "IDを入力してください。") @Pattern(regexp = "^[0-9](|.{4,8})$", message = "IDは4文字以上8文字以内です。") int userCd, String userPw) {
        // エンティティ（箱）のインスタンスを作成
        Team7NewAccount newAccount = new Team7NewAccount();
        
        // 画面から渡ってきた値をエンティティにセット
        // （※セッター名は Team7NewAccount クラスの定義に合わせて適宜変更してください）
        newAccount.setNewuserCd(userCd);
        newAccount.setNewuserPw(userPw);
        
        // リポジトリの標準機能「saveメソッド」を使ってDBに保存（INSERT）する
        repository.save(newAccount);
    }
    
}