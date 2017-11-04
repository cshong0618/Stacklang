package vm;

/**
 * Created by shaong on 11/5/17.
 */

public class CacheSingleton {
    private static Cache _c = null;
    public static synchronized Cache getInstance() {
        if (_c == null) {
            _c = new Cache();
        }
        return _c;
    }
}
