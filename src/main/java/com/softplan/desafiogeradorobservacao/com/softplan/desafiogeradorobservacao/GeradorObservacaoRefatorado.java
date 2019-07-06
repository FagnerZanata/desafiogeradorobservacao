package com.softplan.desafiogeradorobservacao.com.softplan.desafiogeradorobservacao;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class GeradorObservacaoRefatorado {

	static final String TEXTO_SINGULAR = "da nota fiscal";
	static final String TEXTO_PLURAL = "das notas fiscais";
	static final String TEXTO_INICIAL = "Fatura <TEXTO> de simples remessa: ";
	static final String TEXTO_VALOR_TOTAL = ". Total = ";
	static final String TEXTO_CUJO_VALOR = " cujo valor é ";
	static final String TEXTO_SEPERADOR_E = " e ";
	static final String TEXTO_SEPARADOR = ", ";

	private String retornaTextoInicial(int size) {
		if (size > 1) {
			return (TEXTO_INICIAL.replace("<TEXTO>", TEXTO_PLURAL));
		} else {
			return (TEXTO_INICIAL.replace("<TEXTO>", TEXTO_SINGULAR));
		}
	}

	/**
	 * Gera observa��es, com texto pre-definido, incluindo os n�meros, das notas
	 * fiscais, recebidos no par�metro
	 * 
	 * @param <T>
	 * 
	 * @param faturaFiscalSR
	 * @return
	 */
	public <T> String geraObservacao(List<T> faturaFiscalSR) {
		if (!faturaFiscalSR.isEmpty()) {

			StringBuilder textoInicial = new StringBuilder(retornaTextoInicial(faturaFiscalSR.size()));

			String informacoesNotas = retornaInformacoesNotas(faturaFiscalSR) + ".";

			return textoInicial.append(informacoesNotas).toString();
		}

		return "";
	}

	private <T> String retornaInformacoesNotas(List<T> faturaFiscalSR) {
		StringBuilder informacoesNotas = new StringBuilder();
		boolean isDetalhado = false;
		BigDecimal totalFatura = BigDecimal.ZERO;

		for (Object obj : faturaFiscalSR) {

			if (obj instanceof notaFiscalSR) {
				notaFiscalSR nota = (notaFiscalSR) obj;
				formataDetalhado(informacoesNotas, nota);
				isDetalhado = true;
				totalFatura = totalFatura.add(nota.getValor());
			} else {
				informacoesNotas.append((Integer) obj);
			}

			if (isUltimaNota(obj, faturaFiscalSR))
				break;
			else if (isPenultimaNota(obj, faturaFiscalSR))
				informacoesNotas.append(TEXTO_SEPERADOR_E);
			else
				informacoesNotas.append(TEXTO_SEPARADOR);
		}

		if (isDetalhado) {
			informacoesNotas.append(TEXTO_VALOR_TOTAL).append(formataValorMoeda(totalFatura));
		}

		return informacoesNotas.toString();
	}
	
	private void formataDetalhado(StringBuilder informacoesNotas, notaFiscalSR nota) {
		informacoesNotas.append(nota.getNumero());
		informacoesNotas.append(TEXTO_CUJO_VALOR);
		informacoesNotas.append(formataValorMoeda(nota.getValor()));
	}
	
	private String formataValorMoeda(BigDecimal valorNota) {
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return format.format(valorNota);		
	}

	private boolean isUltimaNota(Object nota, List<?> notas) {
		if (notas.indexOf(nota) == (notas.size() - 1))
			return true;

		return false;
	}

	private boolean isPenultimaNota(Object nota, List<?> notas) {
		if (notas.indexOf(nota) == (notas.size() - 2))
			return true;

		return false;
	}

}
