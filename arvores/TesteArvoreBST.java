package arvores;

import java.util.Random;
import java.util.Scanner;

public class TesteArvoreBST {
	public static void main(String[] args) {
		// lista 6
		ArvoreBST<String> arvore = new ArvoreBST<>();
		arvore.inserir("Maria");
		arvore.inserir("João");
		arvore.inserir("Zequinha");
		arvore.inserir("Wilson");
		arvore.inserir("Carla");
		arvore.inserir("Pedro");
		arvore.inserir("Marcel");
		arvore.inserir("Sandra");
		System.out.println(arvore.toString());
		System.out.println("Sandra->" + arvore.buscar("Sandra").getInfo());
		System.out.println("Fantasminha->" + arvore.buscar("Fantasminha"));

		
		// lista 7
		ArvoreBST<Integer> arv2 = new ArvoreBST<>();
		System.out.println("Quantos nós?");
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int qtde = s.nextInt();
		int[] vetor = new int[qtde];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = r.nextInt(100000);
			arv2.inserir(vetor[i]);
		}
		System.out.println(arv2.toString());
		int pos;
		while (qtde != 0) {
			pos = r.nextInt(vetor.length);
			if (vetor[pos] != -1) {
				arv2.retirar(vetor[pos]);
				vetor[pos] = -1;
				qtde--;
				System.out.println(arv2.toString());
			}
		}
	}

}
