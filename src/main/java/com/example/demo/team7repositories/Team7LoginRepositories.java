package com.example.demo.team7repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team7entity.Team7Account;

@Repository
public interface Team7LoginRepositories extends JpaRepository<Team7Account, String>{
	public List<Team7Account> findByUserCd(String code);
	
	@Query(value = "select * from user_tbl where user_cd = :code", nativeQuery = true)
	public List<Team7Account>findBumonCd(@Param("code")String code);
}