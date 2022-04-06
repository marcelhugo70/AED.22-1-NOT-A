package lineares;

public class FilaVetor<T> implements Fila<T> { // contribuição do Henrique
	private T[] info;
	private int limite;
	private int tamanho = 0;
	private int inicio = 0;

	public FilaVetor(int limite) {
		this.limite = limite;
		this.info = (T[]) new Object[limite];
	}

	@Override
	public void inserir(T valor) {
		if (this.estaCheia())
			throw new RuntimeException("Fila está cheia");

		int posicao = (this.inicio + this.tamanho) % this.limite;

		this.info[posicao] = valor;
		this.tamanho++;
	}

	@Override
	public boolean estaVazio() {
		return this.tamanho == 0;
	}

	@Override
	public T peek() {
		if (this.estaVazio())
			throw new RuntimeException("Fila está vazia");

		return this.info[this.inicio];
	}

	@Override
	public T retirar() {
		T valor = this.peek();

		this.info[this.inicio] = null;
		this.inicio = (this.inicio + 1) % this.limite;
		this.tamanho--;

		return valor;
	}

	@Override
	public void liberar() {
		this.info = (T[]) new Object[this.limite];
		this.tamanho = 0;
		this.inicio = 0;
	}

	private boolean estaCheia() {
		return this.tamanho == this.limite;
	}

	@Override
	public String toString() {

		String filaString = "";

		if (!estaVazio()) {
			int posicao;
			for (int i = 0; i < this.tamanho; i++) {
				posicao = (this.inicio + i) % this.limite;
				filaString += info[posicao] + ", ";
			}

			filaString = filaString.substring(0, filaString.length() - 2);

		}

		return filaString;
	}

	public FilaVetor<T> concatenar(FilaVetor<T> f2) {
		FilaVetor<T> novaFila = new FilaVetor<>(this.getLimite() + f2.getLimite());
		for (int i = 0; i < this.getTamanho(); i++) {
			novaFila.inserir(this.pegar(i));
		}

		for (int i = 0; i < f2.getTamanho(); i++) {
			novaFila.inserir(f2.pegar(i));
		}

		return novaFila;
	}

	private int getLimite() {
		return this.limite;
	}

	private T pegar(int pos) {
		if (pos < 0 || pos >= this.getTamanho())
			throw new IndexOutOfBoundsException("Posição inválida");

		return this.info[(this.inicio + pos) % this.limite];
	}

	public int getTamanho() {
		return this.tamanho;
	}

}
