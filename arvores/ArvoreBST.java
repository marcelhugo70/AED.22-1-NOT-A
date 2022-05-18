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
		NoArvoreBST<T> noRemover = this.buscar(info);
		if (noRemover != null) {
			this.retirar(noRemover);
		}
	}

	private void retirar(NoArvoreBST<T> noRemover) {
		NoArvoreBinaria<T> noPai = this.localizarPai(noRemover);

		if (noRemover.ehFolha()) { // caso1
			if (noPai == null) { // noRemover é raiz
				this.setRaiz(null);
			} else {
				if (noPai.getEsq() == noRemover) {
					noPai.setEsq(null);
				} else {
					noPai.setDir(null);
				}
			}
		} else if (noRemover.temApenasUmFilho()) { // caso 2
			NoArvoreBinaria<T> filho = (noRemover.getEsq() != null ? noRemover.getEsq() : noRemover.getDir());
			if (noPai == null) { // noRemover é raiz
				this.setRaiz(filho);
			} else {
				if (noPai.getEsq() == noRemover) {
					noPai.setEsq(filho);
				} else {
					noPai.setDir(filho);
				}
			}
		} else { // caso 3
			NoArvoreBST<T> sucessor = (NoArvoreBST<T>) this.getNoSucessor(noRemover);
			T info = sucessor.getInfo();
			this.retirar(sucessor);
			noRemover.setInfo(info);
		}
	}

	private NoArvoreBinaria<T> getNoSucessor(NoArvoreBST<T> no) {
		NoArvoreBinaria<T> suc = no.getDir();
		while (suc.getEsq() != null) {
			suc = suc.getEsq();
		}
		return suc;
	}

	private NoArvoreBinaria<T> getNoAntecessor(NoArvoreBST<T> no) {
		NoArvoreBinaria<T> ant = no.getEsq();
		while (ant.getDir() != null) {
			ant = ant.getDir();
		}
		return ant;
	}

	private NoArvoreBinaria<T> localizarPai(NoArvoreBST<T> noRemover) {
		if (noRemover == this.getRaiz()) {
			return null;
		}
		NoArvoreBinaria<T> pai = this.getRaiz();

		while (pai.getEsq() != noRemover && pai.getDir() != noRemover) {
			if (noRemover.getInfo().compareTo(pai.getInfo()) < 0) {
				pai = pai.getEsq();
			} else {
				pai = pai.getDir();
			}
		}
		return pai;
	}

	public T localizarMenorElemento() {
		if (this.vazia())
			return null;

		NoArvoreBinaria<T> menorElemento = this.getRaiz();

		while (menorElemento.getEsq() != null) {
			menorElemento = menorElemento.getEsq();
		}

		return menorElemento.getInfo();
	}

	public T localizarMaiorElemento() {
		if (this.vazia())
			return null;

		NoArvoreBinaria<T> maiorElemento = this.getRaiz();

		while (maiorElemento.getDir() != null) {
			maiorElemento = maiorElemento.getDir();
		}

		return maiorElemento.getInfo();
	}

	public T getSucessor(T info) { // contribuição da Ana Carolina
		if (this.vazia()) {
			return null;
		}
		if (this.localizarMaiorElemento().equals(info)) {
			return null;
		}
		NoArvoreBST<T> no = this.buscar(info);
		if (no == null) { // valor não está na árvore
			return null;
		}
		NoArvoreBinaria<T> sucessor = null;
		if (no.getDir() != null) {
			return getNoSucessor(no).getInfo();
		} else {
			sucessor = localizarPai(no);
			while (sucessor.getInfo().compareTo(info) < 0) {
				sucessor = localizarPai((NoArvoreBST<T>) sucessor);
			}
			return sucessor.getInfo();
		}
	}

	public NoArvoreBinaria<T> getAntecessor(T info) {
		if (this.vazia()) {
			return null;
		}
		if (this.localizarMenorElemento().equals(info)) {
			return null;
		}
		NoArvoreBST<T> no = this.buscar(info);
		if (no == null) { // valor não está na árvore
			return null;
		}

		NoArvoreBinaria<T> antecessor = null;
		if (no.getEsq() != null) {
			return this.getNoAntecessor(no);
		} else {
			antecessor = localizarPai(no);
			while (antecessor.getInfo().compareTo(info) > 0) {
				antecessor = localizarPai((NoArvoreBST<T>) antecessor);
			}
			return antecessor;
		}
	}
	public String toStringOrdered()
    {
        String retorno = "";
        if (!this.vazia())
            retorno += ((NoArvoreBST<T>)this.getRaiz()).imprimeEmOrdem();
        return retorno;
    }
}
