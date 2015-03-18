package com.ednardo.loteca.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Component;


@ManagedBean
@ViewScoped
@Component
public class AutocompleteController {

	private String text;

	@PostConstruct
	public void init() {
		text = "Selecione";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> find() {
		ArrayList<String> texts = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			texts.add(text + i);
		}
		return texts;
	}
}
