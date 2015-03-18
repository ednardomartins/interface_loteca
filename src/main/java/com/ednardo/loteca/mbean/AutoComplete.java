package com.ednardo.loteca.mbean;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import com.ednardo.loteca.mbean.data.Player;
import com.ednardo.loteca.mbean.util.PlayerDataSource;

@ManagedBean
@SessionScoped
public class AutoComplete {
	
	@ManagedProperty("#{playerDataSource}")
	private PlayerDataSource ds;
	
	private List<Player> players;
	
	public AutoComplete (){

	}
	
	public List<Player> complete(String query){
		// Assumed Datasource
		return ds.queryByName(query);
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public PlayerDataSource getDs() {
		return ds;
	}

	public void setDs(PlayerDataSource ds) {
		this.ds = ds;
	}
	
	public void handleSelect(SelectEvent e){
		Player p = (Player)e.getObject();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Add Player :: Player Info: ID :: "+ p.getPlayerId() + " :: Name :: "+p.getPlayerName(),""));
	}
	
	public void handleUnSelect(UnselectEvent e){
		Player p = (Player)e.getObject();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Remove Player :: Player Info: ID :: "+ p.getPlayerId() + " :: Name :: "+p.getPlayerName(),""));
	}	
	
	public void phaseListener(PhaseEvent e){
		List<FacesMessage> messages = e.getFacesContext().getMessageList();
		System.out.println(messages.size());
	}
	
	
}
