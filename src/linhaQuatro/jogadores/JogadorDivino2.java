package linhaQuatro.jogadores;

public class JogadorDivino2 implements Jogador
{
	private static final int BOARD_LENGTH_X = 7;
	private static final int BOARD_LENGTH_Y = 7;
	private static final int SEARCH_DEPTH 	= 9; // profundidade

	private static final int EMPTY 		=     0;

	/* peso dos conjuntos */
	private static final int VALUE_2	=     2;
	private static final int VALUE_3	=    10;
	private static final int VALUE_4	=   100;

	/* limites para o alpha-beta */
	private static final int MIN		=-10;
	private static final int MAX		= 10;

	/* a ordem em que os movimentos serao testados */
	private static final int[] moveOrder = {3,4,2,1,5,6,0};

	private static int[][] board = new int[BOARD_LENGTH_X][BOARD_LENGTH_Y];

	private int solution;

	public String getNome(){ return "Divino"; }
	
	public int jogada(int[][] tabuleiro, int color)
	{
		for(int i : moveOrder)System.arraycopy(tabuleiro[i],0,board[i],0,BOARD_LENGTH_Y);
		minimax(color, SEARCH_DEPTH, MIN, MAX);
		return solution;
	}

	/* implementacao do negascout, uma variacao do algoritmo minimax alpha-beta  */
	private int minimax(int color, int depth, int alpha, int beta)
	{
		int v, b = beta, color2 = swapColor(color);

		if(won(color))return VALUE_4;
		if(won(color2))return -VALUE_4;
		if(isBoardFull())return 0;
		if(depth == 0)return evalState(color);

		for(int i : moveOrder)
		{
			if(!insertStone(color,i))continue;

			v = -minimax(color2,depth-1,-b,-alpha);

			if(alpha < v && v < beta && i!=moveOrder[0])
			{
				v = -minimax(color2,depth-1,-beta,-alpha);
			}
			removeStone(i);
			if(alpha < v)
			{
				if(depth == SEARCH_DEPTH)solution = i;
				alpha = v;
			}
			if(alpha >= beta)return alpha;
			b = alpha +1;
		}
		return alpha;
	}

	/* funcao que da peso relativo a situacao do jogo
	** o que ela faz na verdade e contar as possibilidades de
	** vitoria do jogador color e subtrair do oponente dando
	** peso diferente dependendo do numero de pcas em conjunto */
	private int evalState(int color)
	{
		int color2 = swapColor(color);

		int result = VALUE_3 * (horizontalScore(3,color) + verticalScore(3,color) + diagonalScore(3,color));

		result -= VALUE_3 * (horizontalScore(3,color2) + verticalScore(3,color2) + diagonalScore(3,color2));

		result += VALUE_2 * (horizontalScore(2,color) + verticalScore(2,color) + diagonalScore(2,color));
	
		result -= VALUE_2 * (horizontalScore(2,color2) + verticalScore(2,color2) + diagonalScore(2,color2));

		return result;
	}

	/* funcao que conta quantos conjuntos de length pcas
	** existem para o jogador color na horizontal */
	private int horizontalScore(int length, int color)
	{
		int hit, gap, score = 0;

		for(int i=0;i<BOARD_LENGTH_X;i++)
		{
			for(int j=0;j<BOARD_LENGTH_Y-3;j++)
			{
				hit = gap = 0;
				for(int t=0;t<4;t++)
				{
					if(board[i][j+t] == color)hit++;
					else if(board[i][j+t] == EMPTY)gap++;
					else break;
				}
				if(hit == length && gap >= 4-length)score++;
			}
		}
		return score;
	}

	/* funcao que conta quantos conjuntos de length pcas
	** existem para o jogador color na vertical */
	private int verticalScore(int length, int color)
	{
		int hit, gap, i, score = 0;

		for(int j=0;j<BOARD_LENGTH_Y;j++)
		{
			gap = i = hit = 0;
			for(;i<BOARD_LENGTH_X && board[i][j] == EMPTY;i++)gap++;
			for(;i<BOARD_LENGTH_X && board[i][j] == color;i++)hit++;

			if(hit == length && gap >= 4-length)score++;
		}
		return score;
	}

	/* funcao que conta quantos conjuntos de length pcas
	** existem para o jogador color na diagonal */
	private int diagonalScore(int length, int color)
	{
		int gap, hit, score = 0;

		// cima-esquerda -> baixo-direita
		for(int i=0;i<BOARD_LENGTH_Y-3;i++)
		{
			for(int j=0;j<BOARD_LENGTH_X-3;j++)
			{
				gap = hit = 0;
				for(int x=0;x<4;x++)
				{
					if(board[i+x][j+x] == color)hit++;
					else if(board[i+x][j+x] == EMPTY)gap++;
					else break;
				}
				if(hit == length && gap >= 4-length)score++;
			}
		}

		// baixo-esquerda -> cima-direita
		for(int i=0;i<BOARD_LENGTH_Y-3;i++)
		{
			for(int j=BOARD_LENGTH_X-1;j>BOARD_LENGTH_X-5;j--)
			{
				gap = hit = 0;
				for(int x=0;x<4;x++)
				{
					if(board[i+x][j-x] == color)hit++;
					else if(board[i+x][j-x] == EMPTY)gap++;
					else break;
				}
				if(hit == length && gap >= 4-length)score++;
			}
		}
		return score;
	}

	/* remove a ultima pca jogada na coluna column */
	private void removeStone(int column)
	{
		for(int x=0;x < BOARD_LENGTH_X;x++)
		{
			if(board[x][column] != EMPTY)
			{
				board[x][column] = EMPTY;
				return;
			}
		}
	}

	/* joga uma pca de cor color na coluna column */
	private boolean insertStone(int color, int column)
	{
		if(board[0][column] != EMPTY)return false;

		int x = 0;
		while(x < BOARD_LENGTH_X-1 && board[x+1][column] == EMPTY)x++;

		board[x][column] = color;
		return true;
	}

	/* verifica se o tabuleiro esta cheio */
	private boolean isBoardFull()
	{
		for(int x : moveOrder)
		if(board[0][x] == EMPTY)return false;
		return true;
	}

	/* retorna true se o jogador color venceu */
	private boolean won(int color)
	{
		return (diagonalScore(4,color) > 0 || horizontalScore(4,color) > 0 || verticalScore(4,color) > 0);
	}

	/* inverte a cor color e retorna */
	private static final int swapColor(int color)
	{
		return (3-color);
	}

	public static void main(String[]ar)
	{
		int[][]b = {
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0}
		};
		JogadorDivino2 j = new JogadorDivino2();
		System.out.println(j.jogada(b,1));
	}
}