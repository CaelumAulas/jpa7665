package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereConta {
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		ContaDao dao = new ContaDao(manager);
		Conta conta = new Conta();
		
		conta.setTitular("Teteu");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("7899-6");
		conta.setAgencia("7898");
		
		System.out.println("Valor do id antes de inserir: " + conta.getId());
		
		manager.getTransaction().begin();
		dao.adiciona(conta);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Valor do id depois de inserida: " + conta.getId());
		System.out.println("Conta gravada com sucesso!");
	}
}