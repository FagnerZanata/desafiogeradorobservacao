package com.softplan.desafiogeradorobservacao.com.softplan.desafiogeradorobservacao;

import java.math.BigDecimal;

public class notaFiscalSR {

	public notaFiscalSR(int numeroNota, BigDecimal valorNota) {
		this.numero = numeroNota;
		this.valor = valorNota;

	}

	private Integer numero;
	private BigDecimal valor;

	public Integer getNumero() {
		return numero;
	}

	public BigDecimal getValor() {
		return valor;
	}

}
