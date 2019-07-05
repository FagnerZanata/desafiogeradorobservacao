package com.softplan.desafiogeradorobservacao.com.softplan.desafiogeradorobservacao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GeradorObservacaoTest {

	@Test
	public void geradorObservacao_ExemploTest() {
		String esperado = "Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.";

		GeradorObservacao gerador = new GeradorObservacao();

		List<Integer> lista = new ArrayList();

		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);

		String result = gerador.geraObservacao(lista);

		assertTrue(result.equals(esperado));
	}
	
	

}
