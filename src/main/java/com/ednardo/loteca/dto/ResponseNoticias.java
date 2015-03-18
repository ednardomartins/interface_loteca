package com.ednardo.loteca.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseNoticias implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<NoticiaDTO> noticias;

	public List<NoticiaDTO> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<NoticiaDTO> noticias) {
		this.noticias = noticias;
	}

}
