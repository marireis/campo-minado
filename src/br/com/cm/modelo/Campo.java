package br.com.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.cm.excecao.ExplosaoException;

public class Campo {

	private final int linha;
	private final int coluna;
	
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;
	
	private List<Campo> vizinhos = new ArrayList<>();//codigo encapsulado, s� pode adicionar o vizinho pelo metodo adicionaVizinho
		
	Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	boolean adicionarVizinho(Campo vizinho) {//s� adiciona vizinho por esse metodo - por isso a lista � privada
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = linha != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;
		
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else if(deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else {
			return false;
		}
	}
	
	void alternarMarcacao() {
		if(!aberto) {
			marcado = !marcado;
		}
	}
	
	boolean abrir(){
		if(!aberto && !marcado) {
			aberto = true;
			
			if(minado) {
				throw new ExplosaoException();
			}
			
			if(vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());//vai abrir o campo se a vizinhan�a for segura
			}
			return true;
		} else {
			return false;			
		}
		
	}
	
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);//se nenhum vizinho esta minado
	}
	
	void minar() {
		minado = true;
	}
	
	
	public boolean isMarcado() {//metodo publico que nao geral nenhum efeito colateral
		return marcado;
	}
	
	public boolean isAberto() {
		return aberto;
	}
	
	public boolean isFechado() {
		return !aberto;
	}
}
