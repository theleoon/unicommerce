package br.com.alura.unicommerce.core.vo;

import java.math.BigDecimal;

public class RelatorioDeVendasCategoriaVo {
	
	private String nomeCategria;
	private Long quantidadeVendida;
	private BigDecimal montanteVendido;
	
	public RelatorioDeVendasCategoriaVo(String nomeCategria, Long quantidadeVendida, BigDecimal montanteVendido) {
		this.nomeCategria = nomeCategria;
		this.quantidadeVendida = quantidadeVendida;
		this.montanteVendido = montanteVendido;
	}

	public String getNomeCategria() {
		return nomeCategria;
	}

	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public BigDecimal getMontanteVendido() {
		return montanteVendido;
	}

	@Override
	public String toString() {
		return "RelatorioDeVendasCategoriaVo [nomeCategria=" + nomeCategria + ", quantidadeVendida=" + quantidadeVendida
				+ ", montanteVendido=" + montanteVendido + "]";
	}

}
