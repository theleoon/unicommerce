package br.com.alura.unicommerce.core.vo;

public class RelatorioProdutoVendidosMaisTresVezesVo {
	
	private String nomeProduto;
	private Long quantidadeVendida;

	
	public RelatorioProdutoVendidosMaisTresVezesVo(String nomeProduto, Long quantidadeVendida) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	@Override
	public String toString() {
		return "RelatorioProdutoVendidosMaisTresVezesVo [nomeProduto=" + nomeProduto + ", quantidadeVendida="
				+ quantidadeVendida + "]";
	}

}
