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
			NoArvoreBinaria<T> filho = (noRemover.getEsq() != null?
										noRemover.getEsq():
										noRemover.getDir());
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
			NoArvoreBST<T> sucessor = (NoArvoreBST<T>)this.getNoSucessor(noRemover);
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
}
