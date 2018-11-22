
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class Game {
    
    private static Game game;
    private Board board;
    private Player player;
    private final int MISS_LIMIT = 10;
    
    private Game(){
        this.board = Board.getInstance();
        this.player = Player.getInstance();
    }
    
    public static Game getInstance(){
        if(game == null){
            game = new Game();
        }
        return game;
    }
    
    private boolean didLose(){
        return MISS_LIMIT <= player.getMissTimes();
    }
    
    public int play(int firstCoord[], int secondCoord[]){
        try{
            int gameStatus = 0; //If has no winner or losser
            reveal(firstCoord, secondCoord);
            if(didLose()){
                gameStatus = -1;
            }else{
                if(didWin()){
                    gameStatus = 1;
                }
            }
            return gameStatus;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Integer.MIN_VALUE;
        }
        
    }
    
    private boolean didWin(){
        String table[][] = board.getHiddenTable();
        for (String[] row : table) {
            for (String item : row) {
                if (item.equals("?")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean finishGame(boolean isWinner){
        if(isWinner){
            System.out.println("Parabéns, você venceu!");
        }else{
            System.out.println("GAME OVER");
        }
        return isWinner;
    }
    
    private void reveal(int firstCoord[], int secondCoord[]){
        String[][] table = board.getHiddenTableWithVisiblePositions(firstCoord, secondCoord);
        for(String[] row : table){
            System.out.println(Arrays.toString(row));
        }
    }
    
}
