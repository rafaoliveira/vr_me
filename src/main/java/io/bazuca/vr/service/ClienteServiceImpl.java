package io.bazuca.vr.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.bazuca.vr.model.Cliente;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

	@PersistenceContext
	EntityManager em;

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
	public Integer atualiza(Cliente cliente) {
		Cliente c = new Cliente();
		c.setPrimeiroAcesso(c.isPrimeiroAcesso());
		c.setCartaoBloqueado(c.isCartaoBloqueado());
		em.persist(c);
		return null;
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
