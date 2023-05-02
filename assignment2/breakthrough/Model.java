package breakthrough;

public class Model {

    private int size;
    private Player actualPlayer;
    private Player[][] table;    
    private int x;
    private int y;
    
    
    public Model(int size) {
        this.size = size;
        actualPlayer = Player.X;

        table = new Player[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == 1) {
                    table[i][j] = Player.X;
                } else if (i == size - 2 || i == size - 1) {
                    table[i][j] = Player.Y;
                } else {
                    table[i][j] = Player.NOBODY;
                }
            }
        }
    }

    public Player getPlayer(int i, int j) {
        return table[i][j];
    }
 
    public void switchPlayer() {
        if (actualPlayer == Player.X) {
            actualPlayer = Player.Y;
        }else if (actualPlayer == Player.Y) {
            actualPlayer = Player.X;
        }
    }
  
    public int step(int row, int column) {
        System.out.println(actualPlayer);
        System.out.println(table[row][column]);
        x = row;
        y = column;
        eraseColoreds();
        if (actualPlayer == Player.X && table[row][column] == Player.X) {
            if (row + 1 < size && column < size && table[row + 1][column] == Player.Y) {
                table[row + 1][column] = Player.Y;
            }else {
                if (row + 1 < size && column < size && table[row + 1][column] != actualPlayer) {
                    table[row + 1][column] = Player.S;
                }
            }
            if (row + 1 < size && column + 1 < size && table[row + 1][column + 1] == Player.Y) {
                table[row + 1][column + 1] = Player.SY;
            }else {
                if (row + 1 < size && column + 1 < size && table[row + 1][column + 1] != actualPlayer) {
                    table[row + 1][column + 1] = Player.S;
                }
            }
            if (row + 1 < size && column - 1 >= 0 && table[row + 1][column - 1] == Player.Y) {
                table[row + 1][column - 1] = Player.SY;
            }else {
                if (row + 1 < size && column - 1 >= 0 && table[row + 1][column - 1] != actualPlayer) {
                    table[row + 1][column - 1] = Player.S;
                }
            }
        }else if (actualPlayer == Player.Y && table[row][column] == Player.Y){
            if (row - 1 >= 0 && column + 1 < size && table[row - 1][column] == Player.X) {
                table[row - 1][column] = Player.X;
            }else {
                if (row - 1 >= 0 && column < size && table[row - 1][column] != actualPlayer) {
                    table[row - 1][column] = Player.S;
                }
            }
            if (row - 1 >= 0 && column + 1 < size && table[row - 1][column + 1] == Player.X) {
                table[row - 1][column + 1] = Player.SX;
            }else {
                if (row - 1 >= 0 && column + 1 < size && table[row - 1][column + 1] != actualPlayer) {
                    table[row - 1][column + 1] = Player.S;
                }
            }
            if (row - 1 >= 0 && column - 1 >= 0 && table[row - 1][column - 1] == Player.X) {
                table[row - 1][column - 1] = Player.SX;
            }else {
                if (row - 1 >= 0 && column - 1 >= 0 && table[row - 1][column - 1] != actualPlayer) {
                    table[row - 1][column - 1] = Player.S;
                }
            }
        }
        return 0;
    }
    public void move(int row, int col) {
        if (table[row][col] != actualPlayer && table[row][col] != Player.NOBODY) {
            table[row][col] = actualPlayer;
            switchPlayer();
            table[x][y] = Player.NOBODY;
            eraseColoreds();
        }
    }
  
    public Player findWinner() {
        Player result = Player.NOBODY;
        for (int i = 0; i < size; i++) {
            if (table[size - 1][i] == Player.X) {
                return result = Player.X;
            }
            if (table[0][i] == Player.Y) {
                return result = Player.Y;
            }
        }
        return result;
    }

    public Player getActualPlayer() {
        return actualPlayer;
    }
    
    public void eraseColoreds() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == Player.S) {
                    table[i][j] = Player.NOBODY;
                }else if (table[i][j] == Player.SX) {
                    table[i][j] = Player.X;
                }else if (table[i][j] == Player.SY) {
                    table[i][j] = Player.Y;
                }
            }
        }
    }

}
