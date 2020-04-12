package leetCodes;

//将字符串反转
public class Interview58_l {
    public String reverseWords(String s) {
        String[] tmp = s.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--){
            //需要注意的是 如果字符串前面有空格 split() 会产生一个 ""
            //如果中间有连续的三个空格 会产生两个""
            if (!tmp[i].equals(""))
                sb.append(tmp[i] + " ");
        }
        return sb.toString().trim();
    }
}
