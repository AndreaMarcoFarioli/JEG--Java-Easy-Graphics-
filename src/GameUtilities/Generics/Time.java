package GameUtilities.Generics;

public class Time {
    protected static float scale = 1, refreshRate = 16;

    public static float getRefreshRate() {
        return refreshRate;
    }

    public static float getScale() {
        return scale;
    }

    public static void setRefreshRate(float refreshRate) {
        Time.refreshRate = refreshRate;
    }

    public static void setScale(float scale) {
        Time.scale = scale;
    }
}
