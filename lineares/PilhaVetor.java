package lineares;

public class PilhaVetor<T> implements Pilha<T> {
	private T[] info;
	private int limite;
	private int tamanhoAtual = 0;

	public PilhaVetor(int limite) {
		super();
		this.limite = limite;
		this.info = (T[]) new Object[limite];
	}

	@Override
	public void push(T valor) { // Contribuição do Lorhan
		if (this.limite == this.tamanhoAtual) {
			throw new RuntimeException("Capacidade esgotada da pilha");
		}

		info[tamanhoAtual] = valor;
		tamanhoAtual += 1;
	}

	@Override
	public T pop() { // Contribuição do Leonardo
		T retorno = this.peek();
		info[tamanhoAtual - 1] = null;
		tamanhoAtual--;
		return retorno;
	}

	@Override
	public T peek() {
		if (this.estaVazia()) {
			throw new IndexOutOfBoundsException();
		} else {
			return info[tamanhoAtual - 1];
		}
	}

	@Override
	public boolean estaVazia() {
		return (this.tamanhoAtual == 0);
	}

	@Override
	public void liberar() { // Guilherme
		this.info = (T[]) new Object[limite];
		this.tamanhoAtual = 0;
	}

	@Override
	public String toString() { // Joshua
		String ps = "";

		for (int i = tamanhoAtual - 1; i >= 0; i--) {
			ps += info[i]+", ";
		}
		ps = ps.substring(0,Math.max(0, ps.length()-2));
		return ps;
	}

}
