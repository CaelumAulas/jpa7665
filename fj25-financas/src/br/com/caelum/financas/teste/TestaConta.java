package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaConta {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Lucas");
		conta.setAgencia("798-0");
		conta.setNumero("780");
		conta.setBanco("Banco Caelum SA");
		
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDao dao = new ContaDao(em);
		
		em.getTransaction().begin();
		dao.adiciona(conta);
		em.getTransaction().commit();
		
		List<Conta> contas = dao.lista();
		
		for(Conta c : contas) {
			System.out.println(c);
		}
	}
}
