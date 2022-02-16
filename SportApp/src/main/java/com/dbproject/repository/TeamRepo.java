package com.dbproject.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbproject.entity.Player;
import com.dbproject.entity.Team;

@Repository
public interface TeamRepo extends CrudRepository<Team, Long> {

	@Transactional
	@Modifying
	@Query(value="update Team t set t.location = ?1,t.created_at = ?2, t.updated_at = ?3 where t.name = ?4")
	public void update(String location,String created_at,String updated_at, String name);
	
	@Transactional
	@Modifying
	@Query(value="delete from Team t where t.name = ?1")
	public void deleteTeamByName(String teamName);
	
	@Query(value="select p from Player p join Team t on p.team_id=t.id where t.id=?1")
	public List<Player> getPlayersByTeamId(Long teamId);
}
