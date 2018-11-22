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
    
    private boolean didLoss(){
        return MISS_LIMIT <= player.getMissTimes();
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
