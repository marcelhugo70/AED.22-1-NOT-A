package lineares;

public interface Lista {

	void inserir(int valor);
	String exibir();
	int buscar(int valor);
	void retirar(int valor);
	boolean estaVazia();
	Lista copiar();
	void concatenar(Lista outra);
	int getTamanho();
	Lista dividir();
	int pegar(int posicao);

}