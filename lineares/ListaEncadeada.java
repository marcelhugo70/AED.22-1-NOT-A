package lineares;

public class ListaEncadeada implements Lista {
	private NoLista primeiro;
	private NoLista ultimo;
	private int qtdElem;

	@Override
	public void inserir(int valor) {
		NoLista novo = new NoLista();
		novo.setInfo(valor);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProximo(novo);
		}
		ultimo = novo;
		qtdElem++;
	}

	@Override
	public String exibir() {
		String resultado = "[";
		NoLista p = primeiro;
		while (p != null) {
			// processar o nó
			resultado += p.getInfo() + ", ";
			p = p.getProximo();
		}
		return resultado + "]";
	}

	@Override
	public int buscar(int valor) {
		int posicao = 0;
		NoLista p = primeiro;
		while (p != null) {
			// processar o nó
			if (p.getInfo() == valor) {
				return posicao;
			}
			p = p.getProximo();
			posicao++;
		}
		return -1;
	}

	@Override
	public void retirar(int valor) {
		NoLista anterior = null;
		NoLista p = primeiro;

		while (p != null && p.getInfo() != valor) {
			anterior = p;
			p = p.getProximo();
		}

		if (p != null) { // significa que encontrou
			if (anterior == null) {
				primeiro = p.getProximo();
			} else {
				anterior.setProximo(p.getProximo());
			}
		}
		if (ultimo == p) {
			ultimo = anterior;
		}
		qtdElem--;
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	public Lista copiar() { // Contribuição da Ana Carolina
		Lista copia = new ListaEncadeada();
		NoLista p = primeiro;
		while (p != null) {
			copia.inserir(p.getInfo());
			p = p.getProximo();
		}
		return copia;
	}

	@Override
	public void concatenar(Lista outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			this.inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return qtdElem;
	}

	@Override
	public Lista dividir() {
		Lista outraMetade = new ListaEncadeada();
		int metade = this.qtdElem / 2;
		int contador = 1;
		NoLista p = primeiro;

		while (p != null) {
			if (contador > metade) {
				outraMetade.inserir(p.getInfo());
			}
			else if (contador == metade) {
				this.ultimo = p;
			}
			contador++;
			p = p.getProximo();
		}
		ultimo.setProximo(null);
		this.qtdElem = metade;
		return outraMetade;
	}

	@Override
	public int pegar(int posicao) { // Contribuição do Guilherme
		if (posicao < 0 || posicao >= this.getTamanho()) {
			throw new IndexOutOfBoundsException("Posicao = " + posicao + "; Tamanho = " + this.getTamanho());
		}
		int resultado = 0;
		NoLista p = primeiro;

		while (p != null) {
			if (resultado == posicao) {
				return p.getInfo();
			}
			p = p.getProximo();
			resultado++;
		}
		return -1; // nunca deveria chegar aqui
	}

}
