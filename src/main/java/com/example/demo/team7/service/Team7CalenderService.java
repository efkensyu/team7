package com.example.demo.team7.service;

import java.time.LocalDate;
//konnnitiha
import java.util.List;

import org.springframework.stereotype.Service;

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
	
	public List<Team7CalenderEntity> findByYoteiCd(String code) {
		return repository.findByYoteiCd(code);
	}

}
