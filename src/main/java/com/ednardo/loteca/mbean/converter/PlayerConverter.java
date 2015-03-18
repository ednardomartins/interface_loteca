package com.ednardo.loteca.mbean.converter;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.ednardo.loteca.mbean.data.Player;
import com.ednardo.loteca.mbean.util.PlayerDataSource;
//To be considered by the JavaServer Faces As Managed Bean
// & Make the converter Eligible for use @ManagedProperty
@ManagedBean 
@RequestScoped
@FacesConverter
public class PlayerConverter implements Converter{
	@ManagedProperty(value="#{playerDataSource}")
	private PlayerDataSource ds;
	
	public PlayerDataSource getDs() {
		return ds;
	}

	public void setDs(PlayerDataSource ds) {
		this.ds = ds;
	}

	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		for(Player p : ds.getPlayers()){
			if(p.getPlayerId().equals(value)){
				return p;
			}
		}
		return null;
	}

	public String getAsString(FacesContext context, UIComponent component,Object value) {
		if(value instanceof Player){
			Player player = (Player)value;
			return player.getPlayerId();
		}
		return "";
	}

}
