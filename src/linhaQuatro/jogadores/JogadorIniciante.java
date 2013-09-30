package linhaQuatro.jogadores;

public class JogadorIniciante implements Jogador{

	public int jogada(int[][] tabuleiro, int corDaMinhaBola) 
	{
		//Percorro o tabuleiro buscando situa��es que o meu oponente ou eu ven�a
		for(int i = 6; i >= 0; i--)
		{			
			for(int j = 0; j <= 6; j++)
			{
				//Verifico se h� uma sequ�ncia de tr�s posi��es com a bolinha do oponente � direita
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
				//Verifico se h� uma sequ�ncia de uma posi��o com a bolinha do oponente � direita seguida de uma vazia e duas preenchidas
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a bolinha do oponente � direita seguida de uma vazia e uma preenchida
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
				//Verifico se h� uma sequ�ncia de tr�s posi��es com a bolinha do oponente � esquerda
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
				//Verifico se h� uma sequ�ncia de uma posi��o com a bolinha do oponente � esquerda seguida de uma vazia e duas preenchidas
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a bolinha do oponente � esquerda seguida de uma vazia e uma preenchida
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
				//Verifico se h� uma sequ�ncia de tr�s posi��es com a bolinha do oponente acima
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
				//Verifico se h� uma sequ�ncia de tr�s posi��es com a bolinha do oponente na diagonal � esquerda
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
				//Verifico se h� uma sequ�ncia de uma posi��o com a bolinha do oponente � esquerda seguida de uma vazia e duas preenchidas na diagonal
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a bolinha do oponente � esquerda seguida de uma vazia e uma preenchida na diagonal
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
				//Verifico se h� uma sequ�ncia de tr�s posi��es com a bolinha do oponente na diagonal � direita
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
				//Verifico se h� uma sequ�ncia de uma posi��o com a bolinha do oponente � direita seguida de uma vazia e duas preenchidas na diagonal
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a bolinha do oponente � direita seguida de uma vazia e uma preenchida na diagonal
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
				//Verifico se h� uma sequ�ncia de tr�s posi��es com a minha bolinha � direita
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
				//Verifico se h� uma sequ�ncia de uma posi��o com a minha bolinha � direita seguida de uma vazia e duas preenchidas
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a minha bolinha � direita seguida de uma vazia e uma preenchida
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
				//Verifico se h� uma sequ�ncia de tr�s posi��es com a minha bolinha � esquerda
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
				//Verifico se h� uma sequ�ncia de uma posi��o com a minha bolinha � esquerda seguida de uma vazia e duas preenchidas
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a minha  bolinha � esquerda seguida de uma vazia e uma preenchida
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
				//Verifico se h� uma sequ�ncia de tr�s posi��es com a minha bolinha acima
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
				//Verifico se h� uma sequ�ncia de tr�s posi��es com a minha bolinha na diagonal � esquerda
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
				//Verifico se h� uma sequ�ncia de uma posi��o com a minha bolinha � esquerda seguida de uma vazia e duas preenchidas na diagonal
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a minha bolinha � esquerda seguida de uma vazia e uma preenchida na diagonal
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
				//Verifico se h� uma sequ�ncia de tr�s posi��es com a minha bolinha na diagonal � direita
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
				//Verifico se h� uma sequ�ncia de uma posi��o com a minha bolinha � direita seguida de uma vazia e duas preenchidas na diagonal
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a minha bolinha � direita seguida de uma vazia e uma preenchida na diagonal
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
		
		//Percorro o tabuleiro buscando situa��es que impe�a o avan�o do meu oponente e me aproxime da vit�ria
		for(int i = 6; i >= 0; i--)
		{			
			for(int j = 0; j <= 6; j++)
			{
				//Verifico se h� uma sequ�ncia de duas posi��es com a minha bolinha � direita
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a minha bolinha � esquerda
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a minha bolinha acima
				if(copiaTabuleiro(tabuleiro)[i][j] == corDaMinhaBola && i - 2 >= 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j] == corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 2][j] == 0)
					{
						return j;
					}
				}
				//Verifico se h� uma sequ�ncia de duas posi��es com a bolinha do oponente � direita
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a bolinha do oponente � esquerda
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a bolinha do oponente acima
				if(copiaTabuleiro(tabuleiro)[i][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i][j] != 0 && i - 2 >= 0 
						&& copiaTabuleiro(tabuleiro)[i - 2][j] == 0)
				{
					if(copiaTabuleiro(tabuleiro)[i - 1][j] != corDaMinhaBola && copiaTabuleiro(tabuleiro)[i - 1][j] != 0)
					{
						return j;
					}
				}
				//Verifico se h� uma sequ�ncia de duas posi��es com a bolinha do oponente na diagonal � esquerda
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
				//Verifico se h� uma sequ�ncia de duas posi��es com a bolinha do oponente na diagonal � direita
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
		
		//Caso n�o haja situa��o que ocasione a vit�ria do oponente nem a minha vit�ria, fa�o uma jogada aleat�rio na regi�o central do 
		//tabuleiro se houver espa�o ou busco por um espa�o livre e efetuo minha jogada
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
					//Verifico se h� uma posi��o livre no tabuleiro e jogo a bola
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
	
	//Copia o tabuleiro e retorna a c�pia
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