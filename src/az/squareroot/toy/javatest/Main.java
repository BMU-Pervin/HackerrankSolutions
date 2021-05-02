package az.squareroot.toy.javatest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String capitalize(String A) {
        return A.substring(0,1).toUpperCase().concat(A.substring(1));
    }

    public static boolean palindrome(String s) {
        //sample rabbit rabbar madam
        //index  012345 012345 01234
        //even 6 means sub(0,3) sub(3)
        //odd 5 means sub(0,2) sub(3)
        int len = s.length();
        int middle = len / 2;
        if (len % 2 == 0) {
            return s.substring(0, middle).equals(new StringBuilder(s.substring(middle)).reverse().toString());
        }
        return s.substring(0, middle).equals(new StringBuilder(s.substring(middle+1)).reverse().toString());
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] A = a.toLowerCase().toCharArray();
        char[] B = b.toLowerCase().toCharArray();
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                return false;
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int l = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList();

        for (int i=0; i < l; i++) {
            list.add(scanner.nextInt());
        }
        int n = scanner.nextInt();

        for (int i=0; i < n; i++) {
            String ins = scanner.next();
            switch (ins) {
                case "Insert":
                    int pos = scanner.nextInt();
                    int num = scanner.nextInt();
                    System.out.println(pos + " " + num);
                    list.add(pos, num);
                    break;
                default:
                    int posDel = scanner.nextInt();
                    list.remove(posDel);
            }
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        scanner.close();
    }
}