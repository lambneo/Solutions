package leetCodes;

public class Interview58_ll {
    public String reverseLeftWords(String s, int n) {
        return  s.substring(n) + s.substring(0, n);
    }
}
