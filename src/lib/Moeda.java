package lib;

public class Moeda {

	private int preco;
	private int quatidadeMoedaDistinta;
	private int[] moedas;

	public boolean precoValido() {
		return this.preco >= 1 && this.preco <= 50000;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public boolean quatidadeMoedaDistintasValido() {
		return this.quatidadeMoedaDistinta >= 1
				&& this.quatidadeMoedaDistinta <= 100;
	}

	public void setQuatidadeMoedaDistinta(int quatidadeMoedaDistinta) {
		this.quatidadeMoedaDistinta = quatidadeMoedaDistinta + 10;
	}

	public boolean quatidadeMoedasValida() {
		return this.quatidadeMoedaDistinta == this.moedas.length;
	}

	public void setMoedas(int... moedas) {
		this.moedas = moedas;
	}

	public String quantidadeDeMoedaNecessarias() {

		int quantidadeMoedas = 0, restoDoPreco = this.preco, quantidadeMoedaAtual = 0;

		for (int moeda : this.moedas) {
			quantidadeMoedaAtual = restoDoPreco / moeda;
			quantidadeMoedas += quantidadeMoedaAtual;
			restoDoPreco -= quantidadeMoedaAtual * moeda;
			if (restoDoPreco == 0)
				break;
		}
		if (restoDoPreco > 0)
			return "Missão Impossível";

		return String.valueOf(quantidadeMoedas);
	}
}
