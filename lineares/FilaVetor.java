package lineares;

public class FilaVetor<T> implements Fila<T> {  // contribuição do Henrique
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
    public String toString(){
        
        String filaString = "";
        
        if(!estaVazio()){        
        	int posicao;
            for(int i=0; i<this.tamanho; i++){
            	posicao = (this.inicio + i) % this.limite;
                filaString += info[posicao] + ", ";
            }
        
            filaString = filaString.substring(0, filaString.length() - 2);
        
        }
        
        return filaString;
        
    }
}
