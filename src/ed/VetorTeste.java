package ed;

public class VetorTeste {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("João");
		Aluno a2 = new Aluno("José");
		
		Vetor lista = new Vetor();
		
		System.out.println(lista.tamanho());
		lista.adicionaAluno(a1);
		System.out.println(lista.tamanho());
		lista.adicionaAluno(a2);
		System.out.println(lista.tamanho());

		//teste, imprimirá somente numeros
		System.out.println(lista);
		
		System.out.println(lista.contemAluno(a2));
		
		Aluno a3 = new Aluno("Daniel");
		System.out.println(lista.contemAluno(a3));

		lista.adicionaPosicao(1, a3);
		System.out.println(lista);
		
		lista.removeAluno(1);
		System.out.println(lista);

	}

}
