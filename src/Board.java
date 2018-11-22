import Helper.Helper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Board {
    
    private static Board board = null;
    private String table[][];
    private String hiddenTable[][];

    private Board(){
        this.table = initializeTable();
        this.hiddenTable = new String[][] {{"?", "?", "?", "?", "?", "?"}, {"?", "?", "?", "?", "?", "?"}, {"?", "?", "?", "?", "?", "?"}};
    }
    
    public static Board getInstance(){
        if(board == null){
            board = new Board();
        }
        return board;
    }
    
    private String[][] initializeTable(){
        Queue<String> options = getOptions();
        String table[][]  = new String[6][3];
        for(int i=0; i<table.length; i++){
            for(int j=0; j<table[i].length; j++){
                table[i][j] = options.remove();
            }
        }
        return table;
    }
    
    private Queue<String> getOptions(){
        String allOptions[] = new String[] {"A", "A", "B", "B", "C", "C", "D", "D", "E", "E", "F", "F", "G", "G", "H", "H", "I", "I"};
        Arrays.sort(allOptions);
        Queue<String> options = new LinkedList<>(Arrays.asList(allOptions));
        return options;
    }

    public String[][] getHiddenTable() {
        return hiddenTable;
    }

    public void setHiddenTable(String[][] hiddenTable) {
        this.hiddenTable = hiddenTable;
    }

    public String[][] getHiddenTableWithVisiblePositions(int[] firstCoord, int[] secondCoord) {
        String[][] cloned_table = Helper.deepClone(this.hiddenTable);
        cloned_table[firstCoord[0]][firstCoord[1]] = this.table[firstCoord[0]][firstCoord[1]];
        cloned_table[secondCoord[0]][secondCoord[1]] = this.table[secondCoord[0]][secondCoord[1]];
        if(cloned_table[firstCoord[0]][firstCoord[1]].equals(cloned_table[secondCoord[0]][secondCoord[1]])){
            this.hiddenTable = cloned_table;
        }
        return cloned_table;
    }
    
    
    
}
