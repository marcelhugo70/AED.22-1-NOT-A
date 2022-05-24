package arvores;

public class Arvore<T> { // contribuição do Thiago

	private NoArvore<T> raiz;

	public Arvore() {
		this.raiz = null;
	}

	public NoArvore<T> getRaiz() {
		return this.raiz;
	}

	public void setRaiz(NoArvore<T> raiz) {
		this.raiz = raiz;
	}

	public NoArvore<T> pertence(T info) {
		if (this.vazia()) {
			return null;
		}
		return this.raiz.pertence(info);
	}

	public boolean vazia() {
		return this.raiz == null;
	}

	public String toString() {
		if (this.vazia()) {
			return "<>";
		}
		return this.raiz.imprimePre();
	}

}