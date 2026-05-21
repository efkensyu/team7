package com.example.demo.team7;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.team7.entity.Team7CalenderEntity;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor

public class Team7displayService {
	
	private final Team7CalenderRepository repository;
	
	@Transactional(readOnly = true)
		public List<Team7CalenderEntity>  getTeam7CalenderEntityByDate(LocalDate date) {
		List<Team7CalenderEntity>list =repository.findByYoteiDt(date);
		 
		 if (list.isEmpty()){
			 Team7CalenderEntity empty = new Team7CalenderEntity();
			 empty.setYoteiDt(date);
			 empty.setYoteiNm("なにもないよ");
			 empty.setYoteiDetail("だらだらしよう；）");
			 list.add(empty);
		 }
		 return list;
	}

}
