package io.bazuca.vr.service;

import java.util.List;

import io.bazuca.vr.model.Cliente;

public interface ClienteService {

	public List<Cliente> lista();

	public Cliente porId(final Integer id);
	public Integer cria(Cliente cliente);
	public void atualiza(final Integer id, final boolean primeiroAcesso);
	public void remove(Cliente cliente);
	public void removePorId(final Integer id);

	
	



}

