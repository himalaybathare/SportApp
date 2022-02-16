package com.dbproject.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbproject.repository.PlayerRepo;

@Component
public class PlayerService {
	
	@Autowired
	PlayerRepo playerRepo;

	public void updatePlayerByName(String playerName,Map<String, ?> input) {
		
		Long age=Long.valueOf(input.get("age").toString());
		String created_at=(String) input.get("created_at");
		String updated_at=(String) input.get("updated_at");
		Long team_id=Long.valueOf(input.get("team_id").toString());
		
		playerRepo.update(age,created_at,updated_at,team_id,playerName);
	}
}
