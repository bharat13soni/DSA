package com.practice.array;

public class Sort012 {
    public static void main(String[] args) {
        int a[] = {0, 2, 1, 2, 0};
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < a.length; i++) {
            switch (a[i]) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + a[i]);
            }
        }
        int i = 0;
        while (count0 > 0) {
            a[i++] = 0;
            count0--;
        }
        while (count1 > 0) {
            a[i++] = 1;
            count1--;
        }
        while (count2 > 0) {
            a[i++] = 2;
            count2--;
        }
        for (int i1 : a) {
            System.out.print(i1 + ", ");
        }
    }
}
