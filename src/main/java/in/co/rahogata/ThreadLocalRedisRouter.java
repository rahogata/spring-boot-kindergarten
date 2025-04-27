package in.co.rahogata;

public class ThreadLocalRedisRouter {
    private static final ThreadLocal<String> CURRENT_KEY = new ThreadLocal<>();

    public void setCurrentKey(String key) {
        CURRENT_KEY.set(key);
    }

    public void clear() {
        CURRENT_KEY.remove();
    }

    public String getKey() {
        return CURRENT_KEY.get();
    }
}
