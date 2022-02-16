package com.dbproject.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dbproject.entity.Player;
import com.dbproject.entity.Team;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Long> {

	@Transactional
	@Modifying
	@Query(value="update Player p set p.age = ?1,p.created_at = ?2, p.updated_at = ?3, p.team_id=?4 where p.name = ?5")
	public void update(Long age,String created_at,String updated_at,Long team_id, String name);
	
	@Transactional
	@Modifying
	@Query(value="delete from Player p where p.name = ?1")
	public void deletePlayerByName(String playerName);
	
	
	@Query(value="select t from Player p join Team t on p.team_id=t.id where p.id=?1")
	public Team getTeamByPlayerId(Long playerId);
}
