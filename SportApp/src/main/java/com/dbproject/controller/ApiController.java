package com.dbproject.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbproject.entity.Player;
import com.dbproject.entity.Team;
import com.dbproject.repository.PlayerRepo;
import com.dbproject.repository.TeamRepo;
import com.dbproject.service.PlayerService;
import com.dbproject.service.TeamService;


@RestController
public class ApiController {
	
	@Autowired
    PlayerRepo playerRepo;
	
	@Autowired
    TeamRepo teamRepo;
	
	@Autowired
    PlayerService playerService;
	
	@Autowired
    TeamService teamService;
	
	 	@PostMapping("/createTeam")
	    public void createTeam(@RequestBody Team team) 
	    {
	        teamRepo.save(team);
	    }
	 	
	 	@PostMapping("/createPlayer")
	    public void createPlayer(@RequestBody Player player) 
	    {
	        playerRepo.save(player);
	    }
	 	
	 	@GetMapping("/getTeamById")
	    public Optional<Team> getTeamById(@RequestParam(value = "teamId") Long teamId) 
	    {
	        return teamRepo.findById(teamId);  
	    }
	 	
	 	@GetMapping("/getPlayerById")
	    public Optional<Player> getPlayerById(@RequestParam(value = "playerId") Long playerId) 
	    {
	        return playerRepo.findById(playerId);
	    }
	 	
	 	@PutMapping("/updateTeamByName")
	    public void updateTeamByName(@RequestParam(value = "teamName") String teamName,@RequestBody Map<String, ?> input) 
	    {
	         teamService.updateTeamByName(teamName,input);
	    }
	 	
	 	@PutMapping("/updatePlayerByName")
	    public void updatePlayerByName(@RequestParam(value = "playerName") String playerName,@RequestBody Map<String, ?> input) 
	    {
	 		playerService.updatePlayerByName(playerName,input);
	    }
	 	
	 	@DeleteMapping("/deletePlayerByName")
	    public void deletePlayerByName(@RequestParam(value = "playerName") String playerName) 
	    {
	 		playerRepo.deletePlayerByName(playerName);
	    }
	 	
	 	@DeleteMapping("/deleteTeamByName")
	    public void deleteTeamByName(@RequestParam(value = "teamName") String teamName) 
	    {
	        teamRepo.deleteTeamByName(teamName);
	    }
	 	
	 	@GetMapping("/getTeams")
	    public List<Team> getTeams() 
	    {
	 		List<Team> team=new ArrayList<Team>();
	        Iterable<Team> i=teamRepo.findAll();
	        for(Team t:i) {
	        	team.add(t);
	        }
	        return team;
	    }
	 	
	 	@GetMapping("/getPlayers")
	    public List<Player> getPlayers() 
	    {
	 		List<Player> player=new ArrayList<Player>();
	        Iterable<Player> i=playerRepo.findAll();
	        for(Player t:i) {
	        	player.add(t);
	        }
	        return player;
	    }
	 	
	 	@GetMapping("/getTeamByPlayerId")
	    public Object getTeamByPlayerId(@RequestParam(value = "playerId") Long playerId) 
	    {
	        return playerRepo.getTeamByPlayerId(playerId);
	    }
	 	
	 	@GetMapping("/getPlayersByTeamId")
	    public List<Player> getPlayersByTeamId(@RequestParam(value = "teamId") Long teamId) 
	    {
	        return teamRepo.getPlayersByTeamId(teamId);
	    }
}
