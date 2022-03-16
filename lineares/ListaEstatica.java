package lineares;

public class ListaEstatica implements Lista {
	private int[] info;
	private int tamanho;

	public ListaEstatica() {
		info = new int[10];
		tamanho = 0;
	}

	@Override
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

	@Override
	public String exibir() {
		String str = "[";
		for (int i = 0; i < tamanho; i++) {
			str += info[i] + ", ";
		}
		return str + "]";
	}

	@Override
	public int buscar(int valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i] == valor) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void retirar(int valor) {
		int index = buscar(valor);
		if (index != -1) {
			for (int i = index; i < tamanho - 1; i++) {
				info[i] = info[i + 1];
			}
			tamanho--;
		}
	}

	@Override
	public boolean estaVazia() {
		return (tamanho == 0);
	}

	@Override
	public Lista copiar() {
		Lista copia = new ListaEstatica();

		for (int i = 0; i < this.tamanho; i++) {
			copia.inserir(this.info[i]);
		}

		return copia;
	}
	
	@Override
	public void concatenar(Lista outra)
    {
        for (int i = 0; i < outra.getTamanho(); i++)
        {
            this.inserir(outra.pegar(i));
        }
    }
	
	@Override
	public int getTamanho() {
		return tamanho;
	}
	
    @Override
	public Lista dividir()
    {
        Lista outraParte = new ListaEstatica();
        int metade = this.tamanho / 2;

        for (int i = metade; i < this.tamanho; i++)
        {
            outraParte.inserir(this.info[i]);
        }

        this.tamanho = metade;
        return outraParte;
    }


	@Override
	public int pegar(int posicao) {
		return info[posicao];
	}
}
