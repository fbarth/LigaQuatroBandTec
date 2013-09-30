package linhaQuatro.jogadores;

import java.util.Collections;
import java.util.Vector;

public class Android implements Jogador	 {	
	
	private static int recurDepth = 0;   
    private static final int PROFUNDIDADE = 7;   
    private static int LARGURA, ALTURA;   
    private int[][] board;   
    private int[] columnALTURA;   
    private int me;

	@Override
	public int jogada(int[][] tabuleiro, int corDaMinhaBola) {   
        
		getBoardLength(tabuleiro);   
        getColumnALTURA(tabuleiro);   
  
        this.board = copyBoard(tabuleiro);   
        this.me = corDaMinhaBola;   
  
        int action = 0;   
        int value = 0;   
  
        Vector moves = new Vector();   
  
        moves.removeAllElements();   
        int prevValue = -PROFUNDIDADE - 1;   
  
        for (int col = 0; col < LARGURA; col++) {   
            if (columnALTURA[col] >= ALTURA) {   
                continue;   
            }   
  
            value = minimax(this.me, col);   
  
            if (value > prevValue) {   
                moves.removeAllElements();   
                prevValue = value;   
            }   
  
            if (value == prevValue) {   
                moves.add(new Integer(col));   
            }   
        }   
  
        if (moves.size() > 0) {   
            Collections.shuffle(moves);   
            action = ((Integer) moves.get(0)).intValue();   
        }   
  
        return action;   
    }   
  
    private void getBoardLength(int[][] board) {   
        LARGURA = board.length;   
        ALTURA = board[0].length;   
    }   
  
    private void getColumnALTURA(int[][] board) {   
        columnALTURA = new int[LARGURA];   
  
        int aux = 0;   
        for (int col = 0; col < LARGURA; col++) {   
            for (int row = 0; row < ALTURA; row++) {   
                if (board[row][col] == 0) {   
                    aux++;   
                }   
            }   
            columnALTURA[col] = ALTURA - aux;   
            aux = 0;   
        }   
    }   
  
    private int[][] copyBoard(int[][] board) {   
        int[][] copia = new int[LARGURA][ALTURA];   
  
        int aux = 0;   
        for (int row = LARGURA - 1; row >= 0; row--) {   
            for (int col = 0; col < ALTURA; col++) {   
                copia[col][aux] = board[row][col];   
            }   
            aux++;   
        }   
        return copia;   
    }   
  
    int minimax(int player, int column) {   
  
        if (columnALTURA[column] >= ALTURA) {   
            return 0;   
        }   
  
        int value = 0;   
  
        recurDepth++;   
        this.board[column][columnALTURA[column]] = player;   
        columnALTURA[column]++;   
  
        if (eval() > 0) {   
            if (player == this.me) {   
                value = PROFUNDIDADE + 1 - recurDepth;   
            } else {   
                value = -PROFUNDIDADE - 1 + recurDepth;   
            }   
        }   
  
        if (recurDepth < PROFUNDIDADE && value == 0) {   
            value = PROFUNDIDADE + 1;   
  
            for (int col = 0; col < LARGURA; col++) {   
  
                if (columnALTURA[col] >= ALTURA) {   
                    continue;   
                }   
                int v = minimax(3 - player, col);   
  
                if (value == (PROFUNDIDADE + 1)) {   
                    value = v;   
                } else if (player == this.me) {   
                    if (value > v) {   
                        value = v;   
                    }   
                } else if (v > value) {   
                    value = v;   
                }   
            }   
        }   
  
        recurDepth--;   
        columnALTURA[column]--;   
        this.board[column][columnALTURA[column]] = 0;   
  
        return value;   
    }   
  
    int eval() {   
        int num, player;   
  
        for (int y = 0; y < ALTURA; y++) {   
            num = 0;   
            player = 0;   
            for (int x = 0; x < LARGURA; x++) {   
                if (this.board[x][y] == player) {   
                    num++;   
                } else {   
                    num = 1;   
                    player = this.board[x][y];   
                }   
                if (num == 4 && player > 0) {   
                    return player;   
                }   
            }   
        }   
  
        for (int x = 0; x < LARGURA; x++) {   
            num = 0;   
            player = 0;   
            for (int y = 0; y < ALTURA; y++) {   
                if (this.board[x][y] == player) {   
                    num++;   
                } else {   
                    num = 1;   
                    player = this.board[x][y];   
                }   
                if (num == 4 && player > 0) {   
                    return player;   
                }   
            }   
        }   
  
        for (int xStart = 0, yStart = 2; xStart < 4;) {   
            num = 0;   
            player = 0;   
            for (int x = xStart, y = yStart; x < LARGURA && y < ALTURA; x++, y++) {   
                if (this.board[x][y] == player) {   
                    num++;   
                } else {   
                    num = 1;   
                    player = this.board[x][y];   
                }   
                if (num == 4 && player > 0) {   
                    return player;   
                }   
            }   
            if (yStart == 0) {   
                xStart++;   
            } else {   
                yStart--;   
            }   
        }   
  
        for (int xStart = 0, yStart = 3; xStart < 4;) {   
            num = 0;   
            player = 0;   
            for (int x = xStart, y = yStart; x < LARGURA && y >= 0; x++, y--) {   
                if (this.board[x][y] == player) {   
                    num++;   
                } else {   
                    num = 1;   
                    player = this.board[x][y];   
                }   
                if (num == 4 && player > 0) {   
                    return player;   
                }   
            }   
            if (yStart == ALTURA - 1) {   
                xStart++;   
            } else {   
                yStart++;   
            }   
        }   
        // Ninguem está ganhando   
        return 0;   
    }   
  
    public String getNome() {   
        return "Android";   
    }   
  
    public String printTabuleiro() {   
        String resultado = "";   
        for (int i = 0; i < 7; i++) {   
            for (int j = 0; j < 7; j++) {   
                resultado = resultado + " | " + this.board[i][j];   
            }   
            resultado = resultado + " | " + "\n";   
        }   
        return resultado;   
    }  
}


