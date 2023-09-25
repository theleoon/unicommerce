package br.com.alura.unicommerce.core.entity;

import java.math.BigDecimal;

public enum TipoDescontoPedido {
	
	NENHUM(BigDecimal.ZERO), 
	FIDELIDADE(new BigDecimal("0.05")),
	QUANTIDADE(new BigDecimal("0.10"));
	
	TipoDescontoPedido(BigDecimal percentualDesconto) {
		this.desconto = percentualDesconto;
	}

	private BigDecimal desconto;
	
	public BigDecimal getDesconto() { 
		return this.desconto;
	}
	
	BigDecimal getTotalDeDesconto(BigDecimal total) {
		return total.multiply(getDesconto());
	}
	
	public static void main(String[] args) {
		System.out.println(TipoDescontoPedido.FIDELIDADE
				.getTotalDeDesconto(new BigDecimal("1000")));
	}
}
 
