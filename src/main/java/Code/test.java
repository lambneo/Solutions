package Code;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        String[] numList = s.split("\\s");
        int[] radius = new int[numList.length];
        for (int i = 0; i < numList.length; i++)
            radius[i] = Integer.parseInt(numList[i]);
    }
}
