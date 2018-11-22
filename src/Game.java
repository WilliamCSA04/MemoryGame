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
    
    public int play(String firstCoord[], String secondCoord[]){
        int gameStatus = 0; //If has no winner or losser
        if(firstCoord.length != 2 || secondCoord.length != 2){
            return Integer.MIN_VALUE; //invalid play
        }
        if(firstCoord[0] == secondCoord[0] && firstCoord[1] == secondCoord[1]){
            return Integer.MIN_VALUE; //invalid play
        }
        if(didLose()){
            gameStatus = -1;
        }else{
            if(didWin()){
                gameStatus = 1;
            }
        }
        return gameStatus;
    }
    
    private boolean didWin(){
        String table[][] = board.getHiddenTable();
        for(int i=0; i<table.length; i++){
            for(int j=0; j<table[i].length; j++){
                if(table[i][j].equals("?")){
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
    
}
