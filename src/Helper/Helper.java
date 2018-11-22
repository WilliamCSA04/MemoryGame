
package Helper;
import java.util.Arrays;

public class Helper {
 
    
    public static String[][] deepClone(String[][] original) {
        if (original == null) {
            return null;
        }
        final String[][] result = new String[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
     }
    
}
