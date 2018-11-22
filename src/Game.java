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
    
    private Game(){
        this.board = Board.getInstance();
    }
    
    public static Game getInstance(){
        if(game == null){
            game = new Game();
        }
        return game;
    }
    
    
    
}
