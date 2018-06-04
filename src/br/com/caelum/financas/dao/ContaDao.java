package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDao {

	private EntityManager em;
	
	public ContaDao(EntityManager manager) {
		this.em = manager;
	}
	
	public void adiciona(Conta conta) {
		em.persist(conta);
	}
	
	public List<Conta> lista() {
		return em.createQuery("select c from Conta c", Conta.class).getResultList();
	}
	
	public void remove(Conta conta) {
		em.remove(conta);
	}
	
	public Conta busca(Integer id) {
		return em.find(Conta.class, id);
	}
}
