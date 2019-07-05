package com.softplan.desafiogeradorobservacao.com.softplan.desafiogeradorobservacao;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GeradorObservacaoRefatoradoTest {

	@Test
	public void geradorObservacaoRefatorado_ExemploTest() {
		String esperado = "Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.";

		GeradorObservacaoRefatorado gerador = new GeradorObservacaoRefatorado();

		List<Integer> lista = new ArrayList();

		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(5);

		String result = gerador.geraObservacao(lista);

		assertTrue(result.equals(esperado));
	}
	
	
	
	public void geradorObservacaoRefatorado_ExemploSingularTest() {
		String esperado = "Fatura da nota fiscal de simples remessa: 1";

		GeradorObservacaoRefatorado gerador = new GeradorObservacaoRefatorado();

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
