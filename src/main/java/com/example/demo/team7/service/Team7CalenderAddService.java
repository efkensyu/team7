//package com.example.demo.team7.service;
////赤坂
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.example.demo.team7.entity.Team7NewAccount;
//import com.example.demo.team7.repositories.Team7CalenderAddRepositories;
//
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//@Service
//public class Team7CalenderAddService {
//
//    private final Team7CalenderAddRepositories repository;
//
//    public boolean AccountCheck(String userCd, String userPw) {
//
//    	List<Team7NewAccount> list = repository.findByNewuserCd(code);
//
//        // ユーザーが存在しない場合
//        if (list == null || list.isEmpty()) {
//            return true;
//        } else {
//        	return false;
//        }
//    }
//    // ★3: 追加：データベース（user_tbl）にデータを保存するメソッド
//    public void registerAccount(String userCd, String userPw) {
//        // エンティティ（箱）のインスタンスを作成
//        Team7NewAccount newAccount = new Team7NewAccount();
//        
//        // 画面から渡ってきた値をエンティティにセット
//        // （※セッター名は Team7NewAccount クラスの定義に合わせて適宜変更してください）
//        newAccount.setNewuserCd(userCd);
//        newAccount.setNewuserPw(userPw);
//        
//        // リポジトリの標準機能「saveメソッド」を使ってDBに保存（INSERT）する
//        repository.save(newAccount);
//    }
//    
//}