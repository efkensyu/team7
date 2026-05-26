package com.example.demo.team7.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.team7.entity.Team7CalenderEntity;

@Repository
public interface Team7CalenderRepositories extends JpaRepository<Team7CalenderEntity, String> {
	
	//select * from yotei_tbl where yotei_dt = date
	public List<Team7CalenderEntity> findByYoteiDt(LocalDate date);
	
	//select count(yotei_dt) from yotei_tbl
	public long countByYoteiDt(LocalDate date);
	
	//select * from yotei_tbl where user_id = userCd
	public List<Team7CalenderEntity> findByUserId(String userCd);
	
	//select count(yotei_dt) from yotei_tbl where userId = user
	public long countByUserIdAndYoteiDt(String user, LocalDate date);
	
	//select * from yotei_tbl where yotei_dt = date and user_id = user
	public List<Team7CalenderEntity> findByUserIdAndYoteiDt(String user, LocalDate date);
	
	public List<Team7CalenderEntity> findByYoteiCd(String code);

}
