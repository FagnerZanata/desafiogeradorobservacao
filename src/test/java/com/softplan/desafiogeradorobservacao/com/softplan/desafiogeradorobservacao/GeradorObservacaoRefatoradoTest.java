package com.softplan.desafiogeradorobservacao.com.softplan.desafiogeradorobservacao;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GeradorObservacaoRefatoradoTest {

	@Test
	public void geradorObservacaoRefatorado_ExemploTest() {
		String esperado = "Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.";

		GeradorObservacaoRefatorado gerador = new GeradorObservacaoRefatorado();

		Map<Integer, BigDecimal> mapFaturas = new HashMap<Integer, BigDecimal>();
		mapFaturas.put(1, new BigDecimal(10));
		mapFaturas.put(2, new BigDecimal(35));
		mapFaturas.put(3, new BigDecimal(5));
		mapFaturas.put(4, new BigDecimal(1500));
		mapFaturas.put(5, new BigDecimal(0.3));

		String result = gerador.geraObservacao(mapFaturas);

		assertTrue(result.equals(esperado));
	}

	@Test
	public void geradorObservacaoRefatorado_ExemploSingularTest() {
		String esperado = "Fatura da nota fiscal de simples remessa: 1.";

		GeradorObservacaoRefatorado gerador = new GeradorObservacaoRefatorado();

		Map<Integer, BigDecimal> mapFaturas = new HashMap<Integer, BigDecimal>();
		mapFaturas.put(1, new BigDecimal(10));

		String result = gerador.geraObservacao(mapFaturas);

		assertTrue(result.equals(esperado));
	}

}
