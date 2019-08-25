package io.bazuca.vr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private Integer id;

	private String nome;
	private Integer cartao;
	private Boolean primeiroAcesso;
	private Boolean cartaoBloqueado;
	private String proximoBeneficio;
	private Double saldo;
	private Double valorProximoBeneficio;

	public Cliente() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean isPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(Boolean primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}

	public Boolean isCartaoBloqueado() {
		return cartaoBloqueado;
	}

	public void setCartaoBloqueado(Boolean cartaoBloqueado) {
		this.cartaoBloqueado = cartaoBloqueado;
	}

	public String getProximoBeneficio() {
		return proximoBeneficio;
	}

	public void setProximoBeneficio(String proximoBeneficio) {
		this.proximoBeneficio = proximoBeneficio;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getValorProximoBeneficio() {
		return valorProximoBeneficio;
	}

	public void setValorProximoBeneficio(Double valorProximoBeneficio) {
		this.valorProximoBeneficio = valorProximoBeneficio;
	}

	public Cliente(String nome) {
		this.nome = nome;

	}

	public Integer getCartao() {
		return cartao;
	}

	public void setCartao(Integer cartao) {
		this.cartao = cartao;
	}

	public Boolean getPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public Boolean getCartaoBloqueado() {
		return cartaoBloqueado;
	}

	@Override
	public String toString() {
		return "Cliente {" + 
				", id='" + id + '\'' + 
				", nome='" + nome + '\'' +
				", primeiroAcesso='" + primeiroAcesso + '\'' +
				", cartaoBloqueado='" + cartaoBloqueado + '\'' +
				", proximoBeneficio='" + proximoBeneficio + '\'' +
				", saldo=" + saldo + '\'' +
				", valorProximoBeneficio=" + valorProximoBeneficio + "}";
	}

}
