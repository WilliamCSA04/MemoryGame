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
    private int missTimes = 0;
    
    public static Player getInstance(){
        if(player == null){
            player = new Player();
        }
        return player;
    }

    public int getMissTimes() {
        return missTimes;
    }

    public void setMissTimes(int missTimes) {
        this.missTimes = missTimes;
    }
    
    
}
