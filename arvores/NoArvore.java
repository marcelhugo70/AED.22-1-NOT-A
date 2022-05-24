package arvores;

public class NoArvore<T> {

	private T info;
	private NoArvore<T> filho;
	private NoArvore<T> irmao;

	public NoArvore(T info) {
		super();
		this.info = info;
		this.filho = null;
		this.irmao = null;
	}

	public String imprimePre() {
		String retorno = "<"+ this.getInfo();

		if (this.getFilho() != null) {
			retorno += this.getFilho().imprimePre();
		}
		retorno += ">";
		
		if (this.getIrmao() != null) {
			retorno += this.getIrmao().imprimePre();
		}

		return retorno;
	}

	public void inserirFilho(NoArvore<T> sa) {
		if (sa != null) {
			sa.setIrmao(filho);
			this.filho = sa;
		}
	}

	public NoArvore<T> pertence(T info) {
		if (this.info.equals(info)) {
			return this;
		} else {
			NoArvore<T> no = null;
			if (this.filho != null) {
				no = this.filho.pertence(info);
			}
			if (no == null && this.irmao != null) {
				no = this.irmao.pertence(info);
			}
			return no;
		}
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NoArvore<T> getFilho() {
		return filho;
	}

	public void setFilho(NoArvore<T> filho) {
		this.filho = filho;
	}

	public NoArvore<T> getIrmao() {
		return irmao;
	}

	public void setIrmao(NoArvore<T> irmao) {
		this.irmao = irmao;
	}

	@Override
	public String toString() {
		return info.toString();
	}

	
	
}