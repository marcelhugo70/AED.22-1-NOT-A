package lineares;

public class ListaEstatica {
	private int[] info;
	private int tamanho;

	public ListaEstatica() {
		info = new int[10];
		tamanho = 0;
	}

	public void inserir(int valor) {
		if (tamanho == info.length) {
			this.redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}

	private void redimensionar() {
		int[] novo = new int[tamanho + 10];
		for (int i = 0; i < info.length; i++) {
			novo[i] = info[i];
		}
		info = novo;
	}

	public String exibir() {
		String str = "[";
		for (int i = 0; i < tamanho; i++) {
			str += info[i] + ", ";
		}
		return str + "]";
	}

	public int buscar(int valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		return -1;
	}

	public void retirar(int valor) {
		int index = buscar(valor);
		if (index != -1) {
			for (int i = index; i < tamanho - 1; i++) {
				info[i] = info[i + 1];
			}
			tamanho--;
		}
	}

	public boolean estaVazia() {
		return (tamanho == 0);
	}

	public ListaEstatica copiar() {
		ListaEstatica copia = new ListaEstatica();

		for (int i = 0; i < this.tamanho; i++) {
			copia.inserir(this.info[i]);
		}

		return copia;
	}
	
	public void concatenar(ListaEstatica outra)
    {
        for (int i = 0; i < outra.getTamanho(); i++)
        {
            this.inserir(outra.info[i]);
        }
    }
	
	public int getTamanho() {
		return tamanho;
	}
	
    public ListaEstatica dividir()
    {
        ListaEstatica outraParte = new ListaEstatica();
        int metade = this.tamanho / 2;

        for (int i = metade; i < this.tamanho; i++)
        {
            outraParte.inserir(this.info[i]);
        }

        this.tamanho = metade;
        return outraParte;
    }
}
