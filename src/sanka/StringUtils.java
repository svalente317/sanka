package sanka;

public class StringUtils {

    public static String replaceDot(String s, char ch) {
        int prev = 0;
        while (true) {
            int idx = s.indexOf('.', prev);
            if (idx < 0) {
                break;
            }
            s = s.substring(0, idx) + ch + s.substring(idx+1);
            prev = idx+1;
        }
        return s;
    }
}