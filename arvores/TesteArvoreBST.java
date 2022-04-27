package arvores;

public class TesteArvoreBST {
	public static void main(String[] args) {
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
		System.out.println("Sandra->"+arvore.buscar("Sandra").getInfo());
		System.out.println("Fantasminha->"+arvore.buscar("Fantasminha"));
	}
}
