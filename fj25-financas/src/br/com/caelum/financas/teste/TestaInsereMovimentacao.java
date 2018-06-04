package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereMovimentacao {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Teteu");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("7899-6");
		conta.setAgencia("7898");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Almoço no lagoa azul");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("20"));
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(movimentacao);
		manager.getTransaction().commit();
	}
}
