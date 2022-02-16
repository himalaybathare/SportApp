package com.dbproject.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dbproject.repository.TeamRepo;

@Component
public class TeamService {

	@Autowired
	TeamRepo teamRepo;
	
	public void updateTeamByName(String teamName,Map<String, ?> input) {
	
		String location=(String)input.get("location");
		String created_at=(String) input.get("created_at");
		String updated_at=(String) input.get("updated_at");
		
		teamRepo.update(location,created_at,updated_at,teamName);
	}
}

