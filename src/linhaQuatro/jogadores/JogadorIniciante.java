package linhaQuatro.jogadores;

public class JogadorIniciante implements Jogador{

	public int jogada(int[][] tabuleiro, int corDaMinhaBola) 
	{
		//Percorro o tabuleiro buscando situações que o meu oponente ou eu vença
		for(int i = 6; i >= 0; i--)
		{			
			for(int j = 0; j <= 6; j++)
			{
				//Verifico se há uma sequência de três posições com a bolinha do oponente à direita
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && j + 2 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i][j + 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j + 1] != 0
							&& copiaTabuleiro(tabuleiro)[i][j + 2] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j + 2] != 0)
					{
						if(j + 3 <= 6 && copiaTabuleiro(tabuleiro)[i][j + 3] == 0)
						{
							return j + 3;
						}
					}
				}
				//Verifico se há uma sequência de uma posição com a bolinha do oponente à direita seguida de uma vazia e duas preenchidas
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && j + 3 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i][j + 1] == 0
							&& copiaTabuleiro(tabuleiro)[i][j + 2] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j + 2] != 0
							&& copiaTabuleiro(tabuleiro)[i][j + 3] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j + 3] != 0)
					{
						if(i + 1 <= 6)
						{
							if(copiaTabuleiro(tabuleiro)[i + 1][j + 1] != 0)
							{
								return j + 1;
							}
						}
						else
						{
							return j + 1;
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a bolinha do oponente à direita seguida de uma vazia e uma preenchida
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && j + 3 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i][j + 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j + 1] != 0
							&& copiaTabuleiro(tabuleiro)[i][j + 2] == 0
							&& copiaTabuleiro(tabuleiro)[i][j + 3] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j + 3] != 0)
					{
						if(i + 1 <= 6)
						{
							if(copiaTabuleiro(tabuleiro)[i + 1][j + 2] != 0)
							{
								return j + 2;
							}
						}
						else
						{
							return j + 2;
						}
					}
				}
				//Verifico se há uma sequência de três posições com a bolinha do oponente à esquerda
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && j - 2 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i][j - 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j - 1] != 0
							&& copiaTabuleiro(tabuleiro)[i][j - 2] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j - 2] != 0)
					{
						if(j - 3 >= 0 && copiaTabuleiro(tabuleiro)[i][j - 3] == 0)
						{
							return j - 3;
						}
					}
				}
				//Verifico se há uma sequência de uma posição com a bolinha do oponente à esquerda seguida de uma vazia e duas preenchidas
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && j - 3 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i][j - 1] == 0
							&& copiaTabuleiro(tabuleiro)[i][j - 2] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j - 2] != 0
							&& copiaTabuleiro(tabuleiro)[i][j - 3] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j - 3] != 0)
					{
						if(i + 1 <= 6)
						{
							if(copiaTabuleiro(tabuleiro)[i + 1][j - 1] != 0)
							{
								return j - 1;
							}
						}
						else
						{
							return j - 1;
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a bolinha do oponente à esquerda seguida de uma vazia e uma preenchida
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && j - 3 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i][j - 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j - 1] != 0
							&& copiaTabuleiro(tabuleiro)[i][j - 2] == 0
							&& copiaTabuleiro(tabuleiro)[i][j - 3] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j - 3] != 0)
					{
						if(i + 1 <= 6)
						{
							if(copiaTabuleiro(tabuleiro)[i + 1][j - 2] != 0)
							{
								return j - 2;
							}
						}
						else
						{
							return j - 2;
						}
					}
				}
				//Verifico se há uma sequência de três posições com a bolinha do oponente acima
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && i - 2 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 1][j] != 0
							&& copiaTabuleiro(tabuleiro)[i - 2][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 2][j] != 0)
					{
						if(i - 3 >= 0 && copiaTabuleiro(tabuleiro)[i - 3][j] == 0)
						{
							return j;
						}
					}
				}
				//Verifico se há uma sequência de três posições com a bolinha do oponente na diagonal à esquerda
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && i - 2 >= 0 && j - 2 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j - 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 1][j - 1] != 0
							&& copiaTabuleiro(tabuleiro)[i - 2][j - 2] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 2][j - 2] != 0)
					{
						if(i + 1 <= 6 && j + 1 <= 6 && copiaTabuleiro(tabuleiro)[i + 1][j + 1] == 0)
						{
							return j + 1;
						}
						else if(i - 3 >= 0 && j - 3 >= 0 && copiaTabuleiro(tabuleiro)[i - 3][j - 3] == 0 && copiaTabuleiro(tabuleiro)[i - 2][j - 3] != 0)
						{
							return j - 3;
						}
					}
				}
				//Verifico se há uma sequência de uma posição com a bolinha do oponente à esquerda seguida de uma vazia e duas preenchidas na diagonal
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && i - 3 >= 0 && j - 3 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j - 1] == 0
							&& copiaTabuleiro(tabuleiro)[i - 2][j - 2] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 2][j - 2] != 0
							&& copiaTabuleiro(tabuleiro)[i - 3][j - 3] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 3][j - 3] != 0)
					{
						if(copiaTabuleiro(tabuleiro)[i][j - 1] != 0)
						{
							return j - 1;
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a bolinha do oponente à esquerda seguida de uma vazia e uma preenchida na diagonal
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && i - 3 >= 0 && j - 3 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j - 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 1][j - 1] != 0
							&& copiaTabuleiro(tabuleiro)[i - 2][j - 2] == 0
							&& copiaTabuleiro(tabuleiro)[i - 3][j - 3] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 3][j - 3] != 0)
					{
						if(copiaTabuleiro(tabuleiro)[i - 1][j - 2] != 0)
						{
							return j - 2;
						}
					}
				}
				//Verifico se há uma sequência de três posições com a bolinha do oponente na diagonal à direita
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && i - 2 >= 0 && j + 2 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j + 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 1][j + 1] != 0
							&& copiaTabuleiro(tabuleiro)[i - 2][j + 2] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 2][j + 2] != 0)
					{							
						if(i + 1 <= 6 && j - 1 >= 0 && copiaTabuleiro(tabuleiro)[i + 1][j - 1] == 0)
						{
							return j - 1;
						}
						else if(i - 3 >= 0 && j + 3 <= 6 && copiaTabuleiro(tabuleiro)[i - 3][j + 3] == 0 && copiaTabuleiro(tabuleiro)[i - 2][j + 3] != 0)
						{
							return j + 3;
						}
					}
				}
				//Verifico se há uma sequência de uma posição com a bolinha do oponente à direita seguida de uma vazia e duas preenchidas na diagonal
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && i - 3 >= 0 && j + 3 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j + 1] == 0
							&& copiaTabuleiro(tabuleiro)[i - 2][j + 2] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 2][j + 2] != 0
							&& copiaTabuleiro(tabuleiro)[i - 3][j + 3] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 3][j + 3] != 0)
					{
						if(copiaTabuleiro(tabuleiro)[i][j + 1] != 0)
						{
							return j + 1;
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a bolinha do oponente à direita seguida de uma vazia e uma preenchida na diagonal
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && i - 3 >= 0 && j + 3 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j + 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 1][j + 1] != 0
							&& copiaTabuleiro(tabuleiro)[i - 2][j + 2] == 0
							&& copiaTabuleiro(tabuleiro)[i - 3][j + 3] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 3][j + 3] != 0)
					{
						if(copiaTabuleiro(tabuleiro)[i - 1][j + 2] != 0)
						{
							return j + 2;
						}
					}
				}
				//Verifico se há uma sequência de três posições com a minha bolinha à direita
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && j + 2 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i][j + 1] == corDaMinhaBola 
							&& copiaTabuleiro(tabuleiro)[i][j + 2] == corDaMinhaBola)
					{
						if(j + 3 <= 6 && copiaTabuleiro(tabuleiro)[i][j + 3] == 0)
						{
							return j + 3;
						}
					}
				}
				//Verifico se há uma sequência de uma posição com a minha bolinha à direita seguida de uma vazia e duas preenchidas
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && j + 3 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i][j + 1] == 0
							&& copiaTabuleiro(tabuleiro)[i][j + 2] == corDaMinhaBola 
							&& copiaTabuleiro(tabuleiro)[i][j + 3] == corDaMinhaBola)
					{
						if(i + 1 <= 6)
						{
							if(copiaTabuleiro(tabuleiro)[i + 1][j + 1] != 0)
							{
								return j + 1;
							}
						}
						else
						{
							return j + 1;
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a minha bolinha à direita seguida de uma vazia e uma preenchida
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && j + 3 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i][j + 1] == corDaMinhaBola 
							&& copiaTabuleiro(tabuleiro)[i][j + 2] == 0
							&& copiaTabuleiro(tabuleiro)[i][j + 3] == corDaMinhaBola)
					{
						if(i + 1 <= 6)
						{
							if(copiaTabuleiro(tabuleiro)[i + 1][j + 2] != 0)
							{
								return j + 2;
							}
						}
						else
						{
							return j + 2;
						}
					}
				}
				//Verifico se há uma sequência de três posições com a minha bolinha à esquerda
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && j - 2 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i][j - 1] == corDaMinhaBola
							&& copiaTabuleiro(tabuleiro)[i][j - 2] == corDaMinhaBola)
					{
						if(j - 3 >= 0 && copiaTabuleiro(tabuleiro)[i][j - 3] == 0)
						{
							return j - 3;
						}
					}
				}
				//Verifico se há uma sequência de uma posição com a minha bolinha à esquerda seguida de uma vazia e duas preenchidas
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && j - 3 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i][j - 1] == 0
							&& copiaTabuleiro(tabuleiro)[i][j - 2] == corDaMinhaBola 
							&& copiaTabuleiro(tabuleiro)[i][j - 3] == corDaMinhaBola)
					{
						if(i + 1 <= 6)
						{
							if(copiaTabuleiro(tabuleiro)[i + 1][j - 1] != 0)
							{
								return j - 1;
							}
						}
						else
						{
							return j - 1;
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a minha  bolinha à esquerda seguida de uma vazia e uma preenchida
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && j - 3 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i][j - 1] == corDaMinhaBola
							&& copiaTabuleiro(tabuleiro)[i][j - 2] == 0
							&& copiaTabuleiro(tabuleiro)[i][j - 3] == corDaMinhaBola)
					{
						if(i + 1 <= 6)
						{
							if(copiaTabuleiro(tabuleiro)[i + 1][j - 2] != 0)
							{
								return j - 2;
							}
						}
						else
						{
							return j - 2;
						}
					}
				}
				//Verifico se há uma sequência de três posições com a minha bolinha acima
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && i - 2 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j] == corDaMinhaBola 
							&& copiaTabuleiro(tabuleiro)[i - 2][j] == corDaMinhaBola)
					{
						if(i - 3 >= 0 && copiaTabuleiro(tabuleiro)[i - 3][j] == 0)
						{
							return j;
						}
					}
				}
				//Verifico se há uma sequência de três posições com a minha bolinha na diagonal à esquerda
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && i - 2 >= 0 && j - 2 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j - 1] == corDaMinhaBola 
							&& copiaTabuleiro(tabuleiro)[i - 2][j - 2] != corDaMinhaBola)
					{
						if(i + 1 <= 6 && j + 1 <= 6 && copiaTabuleiro(tabuleiro)[i + 1][j + 1] == 0)
						{
							return j + 1;
						}
						else if(i - 3 >= 0 && j - 3 >= 0 && copiaTabuleiro(tabuleiro)[i - 3][j - 3] == 0 && copiaTabuleiro(tabuleiro)[i - 2][j - 3] != 0)
						{
							return j - 3;
						}
					}
				}
				//Verifico se há uma sequência de uma posição com a minha bolinha à esquerda seguida de uma vazia e duas preenchidas na diagonal
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && i - 3 >= 0 && j - 3 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j - 1] == 0
							&& copiaTabuleiro(tabuleiro)[i - 2][j - 2] == corDaMinhaBola 
							&& copiaTabuleiro(tabuleiro)[i - 3][j - 3] == corDaMinhaBola)
					{
						if(copiaTabuleiro(tabuleiro)[i][j - 1] != 0)
						{
							return j - 1;
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a minha bolinha à esquerda seguida de uma vazia e uma preenchida na diagonal
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && i - 3 >= 0 && j - 3 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j - 1] == corDaMinhaBola 
							&& copiaTabuleiro(tabuleiro)[i - 2][j - 2] == 0
							&& copiaTabuleiro(tabuleiro)[i - 3][j - 3] == corDaMinhaBola)
					{
						if(copiaTabuleiro(tabuleiro)[i - 1][j - 2] != 0)
						{
							return j - 2;
						}
					}
				}
				//Verifico se há uma sequência de três posições com a minha bolinha na diagonal à direita
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && i - 2 >= 0 && j + 2 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j + 1] == corDaMinhaBola 
							&& copiaTabuleiro(tabuleiro)[i - 2][j + 2] != corDaMinhaBola)
					{							
						if(i + 1 <= 6 && j - 1 >= 0 && copiaTabuleiro(tabuleiro)[i + 1][j - 1] == 0)
						{
							return j - 1;
						}
						else if(i - 3 >= 0 && j + 3 <= 6 && copiaTabuleiro(tabuleiro)[i - 3][j + 3] == 0 && copiaTabuleiro(tabuleiro)[i - 2][j + 3] != 0)
						{
							return j + 3;
						}
					}
				}
				//Verifico se há uma sequência de uma posição com a minha bolinha à direita seguida de uma vazia e duas preenchidas na diagonal
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && i - 3 >= 0 && j + 3 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j + 1] == 0
							&& copiaTabuleiro(tabuleiro)[i - 2][j + 2] == corDaMinhaBola 
							&& copiaTabuleiro(tabuleiro)[i - 3][j + 3] == corDaMinhaBola)
					{
						if(copiaTabuleiro(tabuleiro)[i][j + 1] != 0)
						{
							return j + 1;
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a minha bolinha à direita seguida de uma vazia e uma preenchida na diagonal
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && i - 3 >= 0 && j + 3 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j + 1] == corDaMinhaBola 
							&& copiaTabuleiro(tabuleiro)[i - 2][j + 2] == 0
							&& copiaTabuleiro(tabuleiro)[i - 3][j + 3] == corDaMinhaBola)
					{
						if(copiaTabuleiro(tabuleiro)[i - 1][j + 2] != 0)
						{
							return j + 2;
						}
					}
				}
			}
		}
		
		//Percorro o tabuleiro buscando situações que impeça o avanço do meu oponente e me aproxime da vitória
		for(int i = 6; i >= 0; i--)
		{			
			for(int j = 0; j <= 6; j++)
			{
				//Verifico se há uma sequência de duas posições com a minha bolinha à direita
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && j + 2 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i][j + 1] == corDaMinhaBola)
					{
						if(copiaTabuleiro(tabuleiro)[i][j + 2] == 0)
						{
							if(i + 1 <= 6)
							{
								if(copiaTabuleiro(tabuleiro)[i + 1][j + 2] != 0)
								{
									return j + 2;
								}
							}
							else
							{
								return j + 2;
							}
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a minha bolinha à esquerda
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && j - 2 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i][j - 1] == corDaMinhaBola)
					{
						if(copiaTabuleiro(tabuleiro)[i][j - 2] == 0)
						{
							if(i + 1 <= 6)
							{
								if(copiaTabuleiro(tabuleiro)[i + 1][j - 2] != 0)
								{
									return j - 2;
								}
							}
							else
							{
								return j - 2;
							}
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a minha bolinha acima
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && i - 2 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j] == corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 2][j] == 0)
					{
						return j;
					}
				}
				//Verifico se há uma sequência de duas posições com a bolinha do oponente à direita
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && j + 2 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i][j + 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j + 1] != 0)
					{
						if(copiaTabuleiro(tabuleiro)[i][j + 2] == 0)
						{
							if(i + 1 <= 6)
							{
								if(copiaTabuleiro(tabuleiro)[i + 1][j + 2] != 0)
								{
									return j + 2;
								}
							}
							else
							{
								return j + 2;
							}
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a bolinha do oponente à esquerda
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && j - 2 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i][j - 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j - 1] != 0)
					{
						if(copiaTabuleiro(tabuleiro)[i][j - 2] == 0)
						{
							if(i + 1 <= 6)
							{
								if(copiaTabuleiro(tabuleiro)[i + 1][j - 2] != 0)
								{
									return j - 2;
								}
							}
							else
							{
								return j - 2;
							}
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a bolinha do oponente acima
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && i - 2 >= 0 
						&& copiaTabuleiro(tabuleiro)[i - 2][j] == 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 1][j] != 0)
					{
						return j;
					}
				}
				//Verifico se há uma sequência de duas posições com a bolinha do oponente na diagonal à esquerda
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && i - 2 >= 0 && j - 2 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j - 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 1][j - 1] != 0
							&& copiaTabuleiro(tabuleiro)[i - 2][j - 2] == 0)
					{
						if(i + 1 <= 6 && j + 1 <= 6 && copiaTabuleiro(tabuleiro)[i + 1][j + 1] == 0)
						{
							return j + 1;
						}
						else if(copiaTabuleiro(tabuleiro)[i - 1][j - 2] != 0)
						{
							return j - 2;
						}
					}
				}
				//Verifico se há uma sequência de duas posições com a bolinha do oponente na diagonal à direita
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && i - 2 >= 0 && j + 2 <= 6)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j + 1] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 1][j + 1] != 0
							&& copiaTabuleiro(tabuleiro)[i - 2][j + 2] == 0)
					{							
						if(i + 1 <= 6 && j - 1 >= 0 && copiaTabuleiro(tabuleiro)[i + 1][j - 1] == 0)
						{
							return j - 1;
						}
						else if(copiaTabuleiro(tabuleiro)[i - 1][j + 2] != 0)
						{
							return j + 2;
						}
					}
				}
			}
		}
		
		//Caso não haja situação que ocasione a vitória do oponente nem a minha vitória, faço uma jogada aleatório na região central do 
		//tabuleiro se houver espaço ou busco por um espaço livre e efetuo minha jogada
		double value = Math.random();
		if(value >= 0.0 && value <= 0.14)
		{
			return 2;
		}
		else if(value >= 0.15 && value <= 0.29 && copiaTabuleiro(tabuleiro)[0][2] == 0)
		{
			return 2;
		}
		else if(value >= 0.3 && value <= 0.44 && copiaTabuleiro(tabuleiro)[0][3] == 0)
		{
			return 3;
		}
		else if(value >= 0.45 && value <= 0.59 && copiaTabuleiro(tabuleiro)[0][3] == 0)
		{
			return 3;
		}
		else if(value >= 0.6 && value <= 0.74 && copiaTabuleiro(tabuleiro)[0][4] == 0)
		{
			return 4;
		}
		else if(value >= 0.75 && value <= 0.89 && copiaTabuleiro(tabuleiro)[0][4] == 0)
		{
			return 4;
		}
		else
		{
			for(int i = 6; i >= 0; i--)
			{			
				for(int j = 0; j <= 6; j++)
				{
					//Verifico se há uma posição livre no tabuleiro e jogo a bola
					if(copiaTabuleiro(tabuleiro)[i][j] == 0)
					{
						return j;
					}
				}
			}
			return 4;
		}
	}

	@Override
	public String getNome() 
	{
		return "Iniciante";
	}
	
	//Copia o tabuleiro e retorna a cópia
	private static int[][] copiaTabuleiro(int tabuleiro[][])
	{
		int[][] copia = new int[7][7];
		for(int i = 0; i <= 6; i++)
		{
			for(int j = 0; j <= 6; j++)
			{
				copia[i][j] = tabuleiro[i][j];
			}
		}
		return copia;
	}
}