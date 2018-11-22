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
        String table[][]  = new String[3][6];
        for(int i=0; i<table.length; i++){
            for(int j=0; j<table[i].length; j++){
                table[i][j] = options.remove();
            }
        }
        return table;
    }
    
    private Queue<String> getOptions(){
        String allOptions[] = new String[] {"C", "H", "B", "E", "A", "F", "D", "G", "G", "I", "C", "F", "A", "E", "D", "H", "B", "I"};
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
        String[][] clonedTable = Helper.deepClone(this.hiddenTable);
        System.out.println(Arrays.deepToString(this.table));
        String a1 = this.table[firstCoord[0]][firstCoord[1]];
        String a2 = this.table[secondCoord[0]][secondCoord[1]];
        clonedTable[firstCoord[0]][firstCoord[1]] = a1;
        clonedTable[secondCoord[0]][secondCoord[1]] = a2;
        if(a1.equals(a2)){
            this.hiddenTable = clonedTable;
        }
        return clonedTable;
    }
    
    
    
}
