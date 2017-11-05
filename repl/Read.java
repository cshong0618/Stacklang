package repl;

/**
 * Created by shaong on 11/5/17.
 */

public class Read {
    private static Read read = null;

    public static Read getInstance() {
        if(read == null) {
            read = new Read();
        }
        return read;
    }

    private String currentLine;

    private Read() {

    }

    public void readLine(String line) {
        currentLine = line;
    }

    public String getCurrentLine() {
        return currentLine;
    }
}
