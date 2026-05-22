package com.example.demo.team7.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team7.entity.Team7CalenderEntity;

@Repository
public interface Team7CalenderRepositories extends JpaRepository<Team7CalenderEntity, String> {
	
	public List<Team7CalenderEntity> findByYoteiDt(LocalDate date);
	
	public List<Team7CalenderEntity> countByYoteiDt(LocalDate date);

}
