package linhaQuatro;

import java.util.ArrayList;

import linhaQuatro.jogadores.Android;
import linhaQuatro.jogadores.Jogador;
import linhaQuatro.jogadores.JogadorAlastor;
import linhaQuatro.jogadores.JogadorAleatorio;
import linhaQuatro.jogadores.JogadorDiferente;
import linhaQuatro.jogadores.JogadorDivino2;
import linhaQuatro.jogadores.JogadorIdeiaFix;
import linhaQuatro.jogadores.JogadorIgor;
import linhaQuatro.jogadores.JogadorIniciante;
import linhaQuatro.jogadores.JogadorMDF;
import linhaQuatro.jogadores.JogadorManual;

/**
 * Classe responsável por gerenciar os jogos.
 * 
 * @author Fabrício J. Barth
 *
 */
public class GerenciadorLinhaQuatro {
	
	public GerenciadorLinhaQuatro(){
		/**
		 * Jogadores que irao participar
		 * da competicao
		 * 
		 * Para inserir um novo jogador, insira aqui.
		 * 
		 * Previa da competicao 2013/2
		 */
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(new JogadorAleatorio());
		jogadores.add(new JogadorAlastor());
		jogadores.add(new JogadorIdeiaFix());
		jogadores.add(new JogadorMDF());
		
		/*
		 * Jogos
		 */
		ArrayList<JogoLinhaQuatro> jogos = new ArrayList<JogoLinhaQuatro>();
		for(int i=0; i<jogadores.size(); i++){
			for(int j=i+1; j<jogadores.size(); j++){
				System.out.println("\nNovo jogo entre "+jogadores.get(i).getNome()+"  "+jogadores.get(j).getNome());
				jogos.add(new JogoLinhaQuatro(jogadores.get(i),jogadores.get(j)));
				System.out.println("\nNovo jogo entre "+jogadores.get(j).getNome()+"  "+jogadores.get(i).getNome());
				jogos.add(new JogoLinhaQuatro(jogadores.get(j),jogadores.get(i)));
			}
		}
		
		
		/**
		 * Resultados
		 */
		System.out.println("");
		System.out.println("Resultados da competição");
		for(int i=0; i<jogos.size(); i++){
			System.out.println(jogos.get(i).resultado());
		}
		
		/*
		 * Imprimindo apenas o nome dos vencedores
		 */
		System.out.println("");
		System.out.println("Imprimindo apenas o nome dos vencedores");
		for(int i=0; i<jogos.size(); i++){
			System.out.println(jogos.get(i).vencedor());
		}
	}
	
	public static void main(String args[]){
		new GerenciadorLinhaQuatro();
	}

}
