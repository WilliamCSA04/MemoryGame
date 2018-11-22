
package Helper;
import java.util.Arrays;

public class Helper {
 
    
    public static String[][] deepClone(String[][] original) {
        if (original == null) {
            return null;
        }
        System.out.println(Arrays.deepToString(original));
        final String[][] result = new String[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
            // For Java versions prior to Java 6 use the next:
            // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        System.out.println(Arrays.deepToString(result));
        return result;
     }
    
}
