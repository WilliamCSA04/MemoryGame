/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William
 */
public class Player {
    
    private static Player player;
    
    public static Player getInstance(){
        if(player == null){
            player = new Player();
        }
        return player;
    }
    
}