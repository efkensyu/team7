package com.example.demo.team7.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.team7.entity.Team7NewAccount;

@Repository
public interface Team7NewAccountRepositories extends JpaRepository<Team7NewAccount, String>{
	public List<Team7NewAccount> findByNewuserCd(String code);

	
	@Query(value = "select * from user_tbl where user_cd = :code", nativeQuery = true)
	public List<Team7NewAccount> findNewuserCd(@Param("code") String code);
}
