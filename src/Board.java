
public class Board {
    
    private static Board board = null;
    
    public static Board getInstance(){
        if(board == null){
            board = new Board();
        }
        return board;
    }
    
}
