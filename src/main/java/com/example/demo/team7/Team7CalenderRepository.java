package com.example.demo.team7;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Bumon;

public interface Team7CalenderRepository extends  JpaRepository <Team7CalenderEntity,String> { {
	public List<Team7CalenderEntity> findByYoteiDt(String date);
	
	
	

}
