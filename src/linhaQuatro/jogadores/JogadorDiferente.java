package linhaQuatro.jogadores;

import java.util.ArrayList;
import java.util.List;

public class JogadorDiferente implements Jogador{

	private int larguraTabuleiro;
	private int alturaTabuleiro;
	//private int corDaBola;
	private static final int ALTURA_TABULEIRO 	= 7;
	private static final int LARGURA_TABULEIRO 	= 7;

	public int getLarguraTabuleiro() {
		return (larguraTabuleiro - 1);
	}

	public void setLarguraTabuleiro(int larguraTabuleiro) {
		this.larguraTabuleiro = larguraTabuleiro;
	}

	public int getAlturaTabuleiro() {
		return (alturaTabuleiro - 1);
	}

	public void setAlturaTabuleiro(int alturaTabuleiro) {
		this.alturaTabuleiro = alturaTabuleiro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return "Diferente";
	}

	@Override
	public int jogada(int[][] tabuleiro, int corDaMinhaBola) {
		// TODO Auto-generated method stub
		return miniMax(corDaMinhaBola, tabuleiro);
	}
	private List<Integer> sucessores (int[][]tabuleiro)
	{
		List<Integer> noSucessores = new ArrayList<Integer>();
		for (int i =0; i<=getLarguraTabuleiro(); i++)
		{
			if(tabuleiro[i][getAlturaTabuleiro()]==0)
			{
				noSucessores.add(i);
			}
		}
		return noSucessores;
	}

	private int miniMax(int corDaMinhaBola, int[][]tabuleiro) {
		// TODO Auto-generated method stub
		// deve verificar primeiro se está para ganhar ou se está prestes a perder
		//deve verificar se o tabuleiro está vazio. Retornar daí um valor padrao, tipo 1
		int acaoCorreta = 0;
		int resultado =0;
		
		for(int acao : sucessores(tabuleiro))
		{
			int utilidade = piorUtil(corDaMinhaBola, adicionarAoTabuleiro(corDaMinhaBola, acao, tabuleiro));
			if(utilidade>resultado)
			{
				resultado = utilidade;
				acaoCorreta = acao;
			}
		}
		return resultado;
		
		
	}

	private int[][] adicionarAoTabuleiro(int corBola, int acao, int[][] tabuleiro) {
		// adiciona ação ao tabuleiro, peça da cor do 
		
		for(int j = 0; j<=getAlturaTabuleiro(); j++)
		{
			if(tabuleiro[j][acao]==0)
			{
				tabuleiro[j][acao]=corBola;
				break;
			}
			
		}
		
		return tabuleiro;
	}

	private int piorUtil(int corDaMinhaBola, int[][] tabuleiro) {
		// TODO Auto-generated method stub
		int valor = 1;
		for(int acao : sucessores(tabuleiro))
		{
			valor=Math.min(valor, melhorJogada(corDaMinhaBola,adicionarAoTabuleiro(corDaMinhaBola, acao, tabuleiro)));
		}
		return valor;
		
	}

	private int melhorJogada(int corDaMinhaBola, int[][] tabuleiro) {
		int valor =-10000;
		if(alguemGanha(corDaMinhaBola, tabuleiro))
		{
			return 1;
		}
		else
		{
			for(int acao:sucessores(tabuleiro))
			{
				valor=Math.max(valor, piorUtil(corDaMinhaBola, adicionarAoTabuleiro(corDaMinhaBola, acao, tabuleiro)));
			}
			return valor;
		}
		
	}

	public boolean alguemGanha(int corbola, int[][]tabuleiro)
	{
		if(muitasBolasDiagonal(corbola, tabuleiro))
		{
			return true;
		}
		else {
		if(muitasBolasHorizontal(corbola, tabuleiro))
		{
			return true;
		}
		else {
		if(muitasBolasVertical(corbola, tabuleiro))
		{
			return true;
		}
		else return false;
		}
		}
	}
	public boolean muitasBolasVertical(int corbola, int[][]tabuleiro)
	{
		boolean resultado = false;
		for(int i =0; i<=getAlturaTabuleiro(); i++)
		{
			for(int j =0; j<=getLarguraTabuleiro()-3; j++)
			{
				if(tabuleiro[j][i]==corbola && tabuleiro[j+1][i]==corbola &&
						tabuleiro[j+2][i]==corbola && tabuleiro[j+3][i]==corbola)
				{
					resultado = true;
				}
				
			}
		}
		return resultado;
	}
	public boolean muitasBolasHorizontal(int corbola, int[][]tabuleiro)
	{
		boolean resultado = false;
		for(int i =0; i<=getAlturaTabuleiro(); i++)
		{
			for(int j =0; j<=getLarguraTabuleiro()-3; j++)
			{
				if(tabuleiro[i][j]==corbola && tabuleiro[i][j+1]==corbola &&
						tabuleiro[i][j+2]==corbola && tabuleiro[i][j+3]==corbola)
				{
					resultado = true;
				}
				
			}
		}
		return resultado;
	}
	
	public boolean muitasBolasDiagonal(int corbola, int[][]tabuleiro)
	{
		boolean resultado = false;
		for(int i =0; i<=getAlturaTabuleiro()-3; i++)
		{
			for(int j =0; j<=getLarguraTabuleiro()-3; j++)
			{
				if(tabuleiro[i][j]==corbola && tabuleiro[i+1][j+1]==corbola &&
						tabuleiro[i+2][j+2]==corbola && tabuleiro[i+3][j+3]==corbola)
				{
					resultado = true;
				}
				
			}
			for(int j=getLarguraTabuleiro(); j>=3; j--)
			{
				if(tabuleiro[i][j]==corbola && tabuleiro[i+1][j-1]==corbola &&
						tabuleiro[i+2][j-2]==corbola && tabuleiro[i+3][j-3]==corbola)
				{
					resultado = true;
				}
			}
		}
		return resultado;
	}

//	public void setCorDaBola(int corDaBola) {
//		this.corDaBola = corDaBola;
//	}
//
//	public int getCorDaBola() {
//		return corDaBola;
//	}

	public JogadorDiferente() {
		super();

		this.larguraTabuleiro 	= LARGURA_TABULEIRO;
		this.alturaTabuleiro 	= ALTURA_TABULEIRO;
	}	
}