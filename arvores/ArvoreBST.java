package arvores;

public class ArvoreBST<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

	public void inserir(T info) {
		if (this.vazia()) {
			NoArvoreBST<T> no = new NoArvoreBST<>(info);
			this.setRaiz(no);
		} else {
			((NoArvoreBST<T>) this.getRaiz()).inserir(info);
		}
	}

	public NoArvoreBST<T> buscar(T info) {
		if (this.vazia())
			return null;
		return ((NoArvoreBST<T>) this.getRaiz()).buscar(info);
	}
	
	public void retirar(T info) {
		if (!this.vazia())
			return ((NoArvoreBST<T>) this.getRaiz()).retirar(info);
	}
}
