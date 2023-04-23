package br.com.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CampoTeste {
	
	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {//para intanciar em cada metodo
		campo = new Campo(3,3);
	}

	@Test
	void testeVizinhoDistancia1Esquerda() {
		Campo vizinhoEsquerda = new Campo(3,2);
		boolean resultado = campo.adicionarVizinho(vizinhoEsquerda);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistancia1Direita() {
		Campo vizinhoDireita = new Campo(3,4);
		boolean resultado = campo.adicionarVizinho(vizinhoDireita);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistancia1EmCima() {
		Campo vizinhoCima = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinhoCima);
		
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistancia1EmBaixo() {
		Campo vizinhoBaixo = new Campo(4,3);
		boolean resultado = campo.adicionarVizinho(vizinhoBaixo);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistancia2() {
		Campo vizinho = new Campo(2,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertFalse(resultado);
	}
}
