package com.ednardo.loteca.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ednardo.loteca.dto.NoticiaDTO;

@ManagedBean
@ViewScoped
@Component
public class NoticiasTimesController {

	private List<NoticiaDTO> noticias;

	private String clube;

	@PostConstruct
	public void init() {
		// noticias = find("avai");
	}

	public String getClube() {
		return clube;
	}

	public void setClube(String clube) {
		this.clube = clube;
	}

	public List<NoticiaDTO> find() {
		RestTemplate restTemplate = new RestTemplate();
		List response = Arrays.asList(restTemplate.getForObject("http://localhost:8080/noticias/" + clube,
				NoticiaDTO[].class));
		return response;
	}

	public List<NoticiaDTO> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<NoticiaDTO> noticias) {
		this.noticias = noticias;
	}

	public void add() {
		NoticiaDTO noticiaDTO = new NoticiaDTO();
		noticiaDTO.setTitulo("teste");
		noticiaDTO.setId("22");
		noticiaDTO.setTexto("texto");
		noticiaDTO.setData(new Date());
		this.noticias.add(noticiaDTO);
	}
}
