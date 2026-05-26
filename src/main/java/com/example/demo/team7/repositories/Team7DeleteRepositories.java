package com.example.demo.team7.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team7.entity.Team7CalenderAdd;

@Repository
public interface Team7DeleteRepositories extends JpaRepository<Team7CalenderAdd, Long>{
	public List<Team7CalenderAdd> findByyoteiCd(long yoteiCd);

}
