package ed;

import java.util.Arrays;

public class Vetor {
	private Aluno[] alunos = new Aluno[100];
	
	//essa variavel irá guardar qntas posições tenho no array, e a próxima 0
	private int totalAlunos = 0;
	
	//add no final da lista
	public void adicionaAluno (Aluno aluno){
		//melhor performance, deste modo o tempo de execução demora bem menos.
		this.alunos[totalAlunos] = aluno;
		totalAlunos++;
		
		/*funciona, mas o tempo de execucao nao é bom, dermorara muito
		quanto maior a lista, mais demorada será a execucao
		for (int i = 0; i < alunos.length; i++) {
			if(alunos[i]==null){
				alunos[i]=aluno;
				break;}}*/	
	}
	
	//verificar se a posicao é valida para o metodo adicionaPosicao
	private boolean posicaoValida(int posicao){
		return posicao >=0 && posicao <= totalAlunos;
	}
	
	//add em qualquer lugar da lista, empurrando o restante para a direita
	public void adicionaPosicao (int posicao, Aluno aluno){
		if(!posicaoValida(posicao)){
			throw new IllegalArgumentException("posicão invalida");
		}
		
		for (int i = totalAlunos-1; i >= posicao; i-=1) {
			alunos[i+1]=alunos[i];
		}
		alunos[posicao]=aluno;
		totalAlunos++;
	}
	
	//metodo auxiliar para o metodo pegarAluno
	private boolean posicaoOcupada(int posicao){
		return posicao>= 0 && posicao < totalAlunos;
	}
	public Aluno pegarAluno(int posicao){
		if(!posicaoOcupada(posicao)){
			//msg de erro no exception
			throw new IllegalArgumentException("posicão invalida");
		}
		return alunos[posicao];
	}
	
	//remove aluno, movendo o restante para a esquerda
	public void removeAluno (int posicao){
		for (int i = posicao; i < this.totalAlunos; i++) {
			this.alunos[i]=this.alunos[i+1];
		}
		totalAlunos--;
	}
	
	public boolean contemAluno (Aluno aluno){
		//loop até o tamanho maximo
		//for (int i = 0; i < alunos.length; i++) {
		for (int i = 0; i < totalAlunos; i++) {
			//se o aluno que quero comparar for igual ao aluno da posicao i, retorno true
			if(aluno.equals(alunos[i])){
				return true;
			}
		}
		return false;
	}
	
	public int tamanho(){
		return totalAlunos;
	}
			
	public String toString(){
		return Arrays.toString(alunos);
	}

}
