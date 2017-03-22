/**
 * Created by Alexey on 21.03.2017.
 */
public class hello {
    private static hello ourInstance = new hello();

    public static hello getInstance() {
        return ourInstance;
    }

    private hello() {
    }
}
