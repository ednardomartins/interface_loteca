package com.ednardo.loteca.mbean.data;


public class Player {
	private String playerId;
	private String playerName;
	private String playerPosition;
	private String playerAge;
	private String playerImage;
	
	public String getPlayerId() {
		return playerId;
	}
	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerPosition() {
		return playerPosition;
	}
	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}
	public String getPlayerAge() {
		return playerAge;
	}
	public void setPlayerAge(String playerAge) {
		this.playerAge = playerAge;
	}
	
	public String getPlayerImage() {
		return playerImage;
	}
	public void setPlayerImage(String playerImage) {
		this.playerImage = playerImage;
	}
	public boolean equals(Object obj){
		if(obj instanceof Player){
			Player player = (Player)obj;
			if(this.playerId.equals(player.getPlayerId())){
				return true;
			}
		}
		return false;
	}
	
	public int hashCode(){
		return this.playerId.hashCode();
	}
	
	
}
