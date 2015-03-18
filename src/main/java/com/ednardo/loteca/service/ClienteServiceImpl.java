package com.ednardo.loteca.service;
///*
// * Copyright 2012-2013 the original author or authors.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//package com.netsar.ednardo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.Assert;
//
//import com.netsar.ednardo.entity.Cliente;
//
//
//@Component("clienteServiceImpl")
//@Transactional
//class ClienteServiceImpl implements ClienteService {
//
//	private final ClienteRepository clienteRepository;
//
//
//	public ClienteServiceImpl(ClienteRepository clienteRepository) {
//		this.clienteRepository = clienteRepository;
//	}
//	
//	@Override
//	public Page<Cliente> buscaClientes(String nome, Pageable pageable) {
//		Assert.notNull(nome, "Nome nao pode ser null");
//		return clienteRepository.buscaClientes(nome, pageable);
//	}
//
//	@Override
//	public Cliente getCliente(int idCliente) {
//		return clienteRepository.getCliente(idCliente);
//	}
//
//	@Override
//	public Cliente save(Cliente cliente) {
//		return clienteRepository.save(cliente);
//	}
//}
