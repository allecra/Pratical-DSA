/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ctdl_gt;

import java.util.Scanner;

/**
 *
 * @author allec
 */
public class CTDL_GT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.println("Nhap so luong phan tu trong mang: ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Nhap lai so phan tu mang lon hon 0: ");
            }
        } while (n <= 0);

        double[] Arr = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap gia tri phan tu thu " + (i + 1) + ":");
            Arr[i] = sc.nextDouble();
        }
        double max = Arr[0];
        for (int i = 1; i < n; i++) {
            if (Arr[i] > max) {
                max = Arr[i];
            }
        }
        System.out.println("Gia tri lon nhat trong mang la: " + max);
    }
}


