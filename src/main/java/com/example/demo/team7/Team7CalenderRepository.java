package com.example.demo.team7;

	import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

	public interface Team7CalenderRepository extends JpaRepository<Team7CalenderEntity, String> {
	    List<Team7CalenderEntity> findByYoteiDt(Date date);

}
