package io.bazuca.vr.dto;

public class ClienteDTO {

	private boolean cartaoBloqueado;
	private boolean primeiroAcesso;

	public boolean isCartaoBloqueado() {
		return cartaoBloqueado;
	}

	public void setCartaoBloqueado(boolean cartaoBloqueado) {
		this.cartaoBloqueado = cartaoBloqueado;
	}

	public boolean isPrimeiroAcesso() {
		return primeiroAcesso;
	}

	public void setPrimeiroAcesso(boolean primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}
}
