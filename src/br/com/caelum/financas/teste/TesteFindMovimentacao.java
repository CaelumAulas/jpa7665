package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFindMovimentacao {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		Movimentacao movimentacao = em.getReference(Movimentacao.class, 1);
		System.out.println("Buscando a movimentacao");
		System.out.println(movimentacao.getDescricao());
		System.out.println(movimentacao.getConta().getTitular());
		
		movimentacao.getConta().setTitular("Thiago");
		em.getTransaction().commit();
	}
}
