package linhaQuatro.jogadores;


import java.util.List;

public class JogadorMDF implements Jogador {
	
	int nivel = 4;
	long fim;
	long ini;
	long conta = 0;
	
	public String getNome() {return "Chewbacca";	}

	public int jogada(int[][] tabuleiro, int corDaMinhaBola) {
		
		ini = System.currentTimeMillis();
		Robo inicial = new Robo();
		inicial.tabuleiro = tabuleiro;
		inicial.corDaMinhaBola = corDaMinhaBola;
		inicial.profundidade = 0;
		minimax(inicial, nivel);
		inicial = inicial.melhorSucessor;
		
		fim = System.currentTimeMillis();
		long ff = fim - ini;
		conta = conta  + ff;
		System.out.println("");
		System.out.println("tempo em milisegundos " + conta);
		System.out.println("");

		return inicial.coluna;

	}
	
	private int minimax(Robo inicial, int nivel) {
		if (inicial.naoFinal() && nivel > 0) {
			inicial.melhorValor = 0;
			inicial.melhorSucessor = null;
			
			int valor;
			List<Robo> lista = inicial.sucessores();
			for (Robo e : lista) {
				valor = minimax(e, nivel - 1);
				if ((e.corDaMinhaBola == 1)
						&& (valor < inicial.melhorValor)
						|| ((e.corDaMinhaBola == 2) && (valor > inicial.melhorValor))
						|| (inicial.melhorSucessor == null)) {
					inicial.melhorValor = valor;
					inicial.melhorSucessor = e;
				}
				// TODO Auto-generated method stub
			}
			return inicial.melhorValor;
		} else {
			inicial.melhorValor = inicial.custo();
			inicial.melhorSucessor = inicial;
				return inicial.melhorValor;
		}

	}
}
