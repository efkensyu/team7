package com.example.demo.team7.service;

import java.time.LocalDate;
//konnnitiha
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.team7.entity.Team7CalenderEntity;
import com.example.demo.team7.repositories.Team7CalenderRepositories;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Team7CalenderService {
	private final Team7CalenderRepositories repository;
	
	public List<Team7CalenderEntity> findByYoteiDt(String date){
		LocalDate day = LocalDate.parse(date);
		return repository.findByYoteiDt(day);
	}
	
	public long countYoteiDt(String date){
		LocalDate day = LocalDate.parse(date);
		return repository.countByYoteiDt(day);
	}
	
	public List<Team7CalenderEntity> findByUserId(String userCd) {
		return repository.findByUserId(userCd);
	}
	
	public long countByUserIdAndYoteiDt(String user, String date){
		LocalDate day = LocalDate.parse(date);
		return repository.countByUserIdAndYoteiDt(user,day);
	}
	
	public List<Team7CalenderEntity> findByUserIdAndYoteiDt(String userCd, String date) {
		LocalDate day = LocalDate.parse(date);
		return repository.findByUserIdAndYoteiDt(userCd, day);
	}
	
	//予定の詳細が入っていた場合
	@Transactional
	public Team7CalenderEntity insertYotei(String date, String yoteiNm, String yoteiDetail) {
		Team7CalenderEntity team7Calender = new Team7CalenderEntity();
		LocalDate day = LocalDate.parse(date);
		team7Calender.setYoteiDt(day);
		team7Calender.setYoteiNm(yoteiNm);
		team7Calender.setYoteiDetail(yoteiDetail);
		return repository.save(team7Calender);
	}
	
	//予定の詳細が入っていない場合
		@Transactional
		public Team7CalenderEntity insertYoteiNotDetail(String date, String yoteiNm) {
			Team7CalenderEntity team7Calender = new Team7CalenderEntity();
			LocalDate day = LocalDate.parse(date);
			team7Calender.setYoteiDt(day);
			team7Calender.setYoteiNm(yoteiNm);
			team7Calender.setYoteiDetail(null);
			return repository.save(team7Calender);
		}
}
