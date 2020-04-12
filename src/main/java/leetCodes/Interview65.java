package leetCodes;


/**
 * 不用四则运算符实现整数求和
 * 99 + 111 = ？
 * 个、十、百位 的数字分别相加先不管进位的问题：
 * 个位：9 + 1 = 0
 * 十位：9 + 1 = 0
 * 百位：0 + 1 = 1
 * 得到临时结果：100
 *
 * 计算进位的数字：
 * 1 + 9 = 10;
 * 10 + 90 = 100;
 * 得到进位结果：110
 *
 * 相加得到结果
 * 100 + 110 = 210
 */
public class Interview65 {
    public int add(int a, int b) {
       while (b != 0){
          int temp = a ^ b;
          int carrytemp = (a & b) << 1;
          a = temp;
          b = carrytemp;
       }
       return a;
    }
}
