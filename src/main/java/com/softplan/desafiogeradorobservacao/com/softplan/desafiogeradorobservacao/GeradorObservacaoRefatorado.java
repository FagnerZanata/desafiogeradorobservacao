package com.softplan.desafiogeradorobservacao.com.softplan.desafiogeradorobservacao;

import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class GeradorObservacaoRefatorado {
	// Textos pré-definidos
	static final String TEXTO_SINGULAR = "da nota fiscal";
	static final String TEXTO_PLURAL = "das notas fiscais";
	static final String TEXTO_FINAL = "Fatura <TEXTO> de simples remessa: ";
	static final String TEXTO_VALOR_TOTAL = "Total = ";
	static final String TEXTO_CUJO = "cujo valor é ";

	// Identificador da entidade
	StringBuilder texto = new StringBuilder();

	// Gera observa��es, com texto pre-definido, incluindo os n�meros, das notas
	// fiscais, recebidos no par�metro
	public String geraObservacao(List lista) {
		texto = new StringBuilder();
		if (!lista.isEmpty()) {
			return retornaCodigos(lista) + ".";
		}
		return "";
	}

	// Cria observacao
	private String retornaCodigos(List lista) {
		if (lista.size() >= 2) {
			texto = new StringBuilder( TEXTO_FINAL.replace("<TEXTO>", TEXTO_PLURAL) );
		} else {
			texto = new StringBuilder(TEXTO_FINAL.replace("<TEXTO>", TEXTO_SINGULAR) );
		}

		// Acha separador
		StringBuilder cod = new StringBuilder();
		for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
			Integer c = iterator.next();
			String s = "";
			if (cod.toString() == null || cod.toString().length() <= 0)
				s = "";
			else if (iterator.hasNext())
				s = ", ";
			else
				s = " e ";

			cod.append(s + c);
		}

		return texto.append(cod).toString();
	}
}
