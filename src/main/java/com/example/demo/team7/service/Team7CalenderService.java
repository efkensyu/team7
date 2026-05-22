package com.example.demo.team7.service;

import java.time.LocalDate;
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
	
	public List<Team7CalenderEntity> countYoteiDt(String date){
		LocalDate day = LocalDate.parse(date);
		return repository.countByYoteiDt(day);
	}
}
