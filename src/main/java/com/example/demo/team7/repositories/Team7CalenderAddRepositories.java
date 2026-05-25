package com.example.demo.team7.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team7.entity.Team7CalenderAdd;

@Repository
public interface Team7CalenderAddRepositories extends JpaRepository<Team7CalenderAdd, String>{
	public List<Team7CalenderAdd> findByuserId(String userId);

}
