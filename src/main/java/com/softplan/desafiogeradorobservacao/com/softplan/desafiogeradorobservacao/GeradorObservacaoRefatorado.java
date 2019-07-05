package com.softplan.desafiogeradorobservacao.com.softplan.desafiogeradorobservacao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class GeradorObservacaoRefatorado {
	// Textos pré-definidos
	static final String TEXTO_SINGULAR = "da nota fiscal";
	static final String TEXTO_PLURAL = "das notas fiscais";
	static final String TEXTO_INICIAL = "Fatura <TEXTO> de simples remessa: ";
	static final String TEXTO_VALOR_TOTAL = "Total = ";
	static final String TEXTO_CUJO_VALOR = "cujo valor é R$ ";

	private String retornaTextoInicial(int size) {
		if (size > 1) {
			return (TEXTO_INICIAL.replace("<TEXTO>", TEXTO_PLURAL));
		} else {
			return (TEXTO_INICIAL.replace("<TEXTO>", TEXTO_SINGULAR));
		}
	}

	// Gera observa��es, com texto pre-definido, incluindo os n�meros, das notas
	// fiscais, recebidos no par�metro
	public String geraObservacao(Map<Integer, BigDecimal> mapFaturas) {
		if (!mapFaturas.isEmpty()) {

			StringBuilder textoInicial = new StringBuilder(retornaTextoInicial(mapFaturas.size()));

			String informacoesNotas = retornaCodigos(mapFaturas) + ".";

			return textoInicial.append(informacoesNotas).toString();
		}
		return "";
	}

	// Cria observacao simplificada
	private String retornaCodigos(Map<Integer, BigDecimal> mapFaturas) {
		StringBuilder informacoesNotas = new StringBuilder();

		ArrayList<Integer> keyList = new ArrayList<>(mapFaturas.keySet());

		for (Integer idNota : keyList) {

			informacoesNotas.append(idNota);

			if (isUltimaNota(keyList.indexOf(idNota), keyList.size()))
				break;
			else if (isPenultimaNota(keyList.indexOf(idNota), keyList.size()))
				informacoesNotas.append(" e ");
			else
				informacoesNotas.append(", ");

		}

		return informacoesNotas.toString();
	}

	private boolean isUltimaNota(int indexOf, int size) {
		if (indexOf == (size - 1))
			return true;

		return false;
	}

	private boolean isPenultimaNota(int indexOf, int size) {
		if (indexOf == (size - 2))
			return true;

		return false;
	}

}
