package com.example.demo.team7;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class Team7displayService {
	
	private final Team7CalenderRepository repository;
	
	@Transactional(readOnly = true)
		public Team7CalenderEntity  getTeam7CalenderEntityByDate(Date date) {
		 return Team7CalenderRepository.findByYoteiDt(date);
		 
		 .orElseGet(() -> {
			 Team7CalenderEntity emptyTeam7CalenderEntity = new Team7CalenderEntity();
			 emptyTeam7CalenderEntity.setYoteiDt(date);
			 emptyTeam7CalenderEntity.setYoteiNm("なにもないよ");
			 emptyTeam7CalenderEntity.setYoteiDetail("だらだらしよう；）");
			 
		 }
			 
		 
	}
	
	 
	
		
		
		
	}
	
	


}
