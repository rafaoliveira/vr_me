package io.bazuca.vr.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.bazuca.vr.model.Cliente;
import io.bazuca.vr.service.ClienteService;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Cliente> lista() {
		return em.createQuery("select e from Cliente e", Cliente.class).getResultList();
	}

	@Override
	public Cliente porId(Integer id) {
		return em.find(Cliente.class, id);
	}

	@Override
	@Transactional
	public void atualiza(final Integer id, final boolean primeiroAcesso) {		
		Cliente c = this.porId(id);		
		LOGGER.info("Atualizando cliente: {}, id: {}, primeiroAcesso: {}", c.getNome(), c.getId(), primeiroAcesso);
		c.setPrimeiroAcesso(primeiroAcesso);
		em.merge(c);
	}

	@Override
	@Transactional
	public void remove(Cliente cliente) {
		cliente = em.find(Cliente.class, cliente.getId());
	}

	@Override
	public void removePorId(Integer id) {
		Cliente cliente = porId(id);
		remove(cliente);
	}

	@Override
	@Transactional
	public Integer cria(Cliente cliente) {
		em.persist(cliente);
		return cliente.getId();
	}
}
