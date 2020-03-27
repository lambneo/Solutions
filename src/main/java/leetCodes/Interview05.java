package leetCodes;

/**
 * 替换空格
 *
 * @author ziyuy
 */
public class Interview05 {
    public String replaceSpace(String s) {

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();

    }

}
