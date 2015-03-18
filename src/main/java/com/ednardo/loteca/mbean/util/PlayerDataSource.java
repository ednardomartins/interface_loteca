package com.ednardo.loteca.mbean.util;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ednardo.loteca.mbean.data.Player;
@ManagedBean
@SessionScoped
public class PlayerDataSource {
	public List<Player> players = new ArrayList<Player>();
	
	public PlayerDataSource(){
		// Assumed Player
		Player player = new Player();
		player.setPlayerId("1");
		player.setPlayerName("Anderias Muller");
		player.setPlayerPosition("CF");
		player.setPlayerAge("24");
		player.setPlayerImage("am.png");
		
		// Add Player
		players.add(player);
		
		// Assumed Player
		player = new Player();
		player.setPlayerId("2");
		player.setPlayerName("Olaf Thon");
		player.setPlayerPosition("CM");
		player.setPlayerAge("29");
		player.setPlayerImage("ot.png");
		
		// Add Player
		players.add(player);
		
		// Assumed Player
		player = new Player();
		player.setPlayerId("3");
		player.setPlayerName("Oliver Khan");
		player.setPlayerPosition("GK");
		player.setPlayerAge("31");	
		player.setPlayerImage("ok.png");
		
		// Add Player
		players.add(player);		
		
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	} 
	
	public List<Player> queryByName(String name){
		// Assumed search using the startsWith
		List<Player> queried = new ArrayList<Player>();
		for(Player player: this.players){
			if(player.getPlayerName().startsWith(name)){
				queried.add(player);
			}
		}
		return queried;
	}
	
	
}
