/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author William
 */
public class MemoryGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = Game.getInstance();
        int gameStatus = 0;
        while(gameStatus != 1 || gameStatus != -1){
            System.out.print("Diga a primeira posição (ex: 1,2):\t");
            String firstPosition = scanner.nextLine();
            if(firstPosition.equals("exit")){
                break;
            }
            System.out.print("Diga a segunda posição (ex: 3,2):\t");
            String secondPosition = scanner.nextLine();
            if(secondPosition.equals("exit")){
                break;
            }
            String firstPositions[] = firstPosition.split(",");
            String secondPositions[] = secondPosition.split(",");
            try {
                int[] firstCoord = new int[] {Integer.parseInt(firstPositions[0]), Integer.parseInt(firstPositions[1])};
                int[] secondCoord = new int[] {Integer.parseInt(secondPositions[0]), Integer.parseInt(secondPositions[1])};
                gameStatus = game.play(firstCoord, secondCoord);
            }catch(Exception e){
                System.out.println("Jogada invalida");
                continue;
            }       
            if(Integer.MIN_VALUE == gameStatus){
                System.out.println("Jogada invalida");
            }
        }
        
    }
    
}
