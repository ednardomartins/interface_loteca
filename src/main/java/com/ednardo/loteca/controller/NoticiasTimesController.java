package com.ednardo.loteca.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ednardo.loteca.dto.NoticiaDTO;

@ManagedBean
@RequestScoped
@Component
public class NoticiasTimesController {

	private List<NoticiaDTO> noticias;

	private String clube;

	@PostConstruct
	public void init() {
		noticias = find();
	}

	@PreDestroy
	public void clean() {
		noticias = null;
		clube = "";
	}

	public String getClube() {
		return clube;
	}

	public void setClube(String clube) {
		this.clube = clube;
	}

	public List<NoticiaDTO> findPorClube() {
		RestTemplate restTemplate = new RestTemplate();
		List<NoticiaDTO> response = Arrays.asList(restTemplate.getForObject("http://localhost:8080/informacoesClube/"
				+ clube, NoticiaDTO[].class));
		return response;
	}

	public List<NoticiaDTO> find() {
		RestTemplate restTemplate = new RestTemplate();
		List<NoticiaDTO> response = Arrays.asList(restTemplate.getForObject("http://localhost:8080/informacoesClube/",
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
