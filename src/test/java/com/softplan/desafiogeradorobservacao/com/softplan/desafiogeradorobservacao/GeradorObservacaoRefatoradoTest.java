package com.softplan.desafiogeradorobservacao.com.softplan.desafiogeradorobservacao;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GeradorObservacaoRefatoradoTest {

	@Test
	public void geradorObservacaoRefatoradoSimplificado_ExemploTest() {

		String esperado = "Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.";

		GeradorObservacaoRefatorado gerador = new GeradorObservacaoRefatorado();

		List<Integer> faturaFicalSR = new ArrayList<Integer>();
		faturaFicalSR.add(1);
		faturaFicalSR.add(2);
		faturaFicalSR.add(3);
		faturaFicalSR.add(4);
		faturaFicalSR.add(5);

		String result = gerador.geraObservacao(faturaFicalSR);

		System.out.println(result);
		assertTrue(result.equals(esperado));
	}

	@Test
	public void geradorObservacaoRefatoradoDetalhado_ExemploTest() {
		String esperado = "Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 10,00, "
				+ "2 cujo valor é R$ 35,00, 3 cujo valor é R$ 5,00, "
				+ "4 cujo valor é R$ 1.500,00 e 5 cujo valor é R$ 6,00. Total = R$ 1.556,00.";

		GeradorObservacaoRefatorado gerador = new GeradorObservacaoRefatorado();

		List<notaFiscalSR> faturaFicalSR = new ArrayList<notaFiscalSR>();
		faturaFicalSR.add(new notaFiscalSR(1, new BigDecimal(10)));
		faturaFicalSR.add(new notaFiscalSR(2, new BigDecimal(35)));
		faturaFicalSR.add(new notaFiscalSR(3, new BigDecimal(5)));
		faturaFicalSR.add(new notaFiscalSR(4, new BigDecimal(1500)));
		faturaFicalSR.add(new notaFiscalSR(5, new BigDecimal(6)));

		String result = gerador.geraObservacao(faturaFicalSR);

		System.out.println(result);
		assertTrue(result.equals(esperado));
	}

	@Test
	public void geradorObservacaoRefatoradoSimplificado_ExemploSingularTest() {
		String esperado = "Fatura da nota fiscal de simples remessa: 1.";

		GeradorObservacaoRefatorado gerador = new GeradorObservacaoRefatorado();

		List<Integer> faturaFicalSR = new ArrayList<Integer>();
		faturaFicalSR.add(1);

		String result = gerador.geraObservacao(faturaFicalSR);

		System.out.println(result);
		assertTrue(result.equals(esperado));
	}

	@Test
	public void geradorObservacaoRefatoradoDetalhado_ExemploSingularTest() {
		String esperado = "Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 10,00. Total = R$ 10,00.";

		GeradorObservacaoRefatorado gerador = new GeradorObservacaoRefatorado();

		List<notaFiscalSR> faturaFicalSR = new ArrayList<notaFiscalSR>();
		faturaFicalSR.add(new notaFiscalSR(1, new BigDecimal(10)));

		String result = gerador.geraObservacao(faturaFicalSR);

		System.out.println(result);
		assertTrue(result.equals(esperado));
	}
	
	@Test
	public void geradorObservacaoRefatoradoDetalhado_ExemploSingularDecimalTest() {
		String esperado = "Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 0,30. Total = R$ 0,30.";

		GeradorObservacaoRefatorado gerador = new GeradorObservacaoRefatorado();

		List<notaFiscalSR> faturaFicalSR = new ArrayList<notaFiscalSR>();
		faturaFicalSR.add(new notaFiscalSR(1, new BigDecimal(0.3)));

		String result = gerador.geraObservacao(faturaFicalSR);

		System.out.println(result);
		assertTrue(result.equals(esperado));
	}

}
