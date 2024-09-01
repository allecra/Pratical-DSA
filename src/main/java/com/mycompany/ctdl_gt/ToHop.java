package com.mycompany.ctdl_gt;

 //Tính tổ hợp chập k của n theo công thức hồi quy:
    // C(k,n)= C(n-1,n-1)+ C(k,n-1) với C(0,n) = C(n

import java.util.Scanner;

public class ToHop {

    // Phương thức tính tổ hợp chập k của n (Đệ quy)
    public static int tohop(int k, int n) {
        // Điều kiện biên
        if (k == 0 || k == n) {
            return 1;
        }
        // Tính tổ hợp chập k của n theo công thức hồi quy
        return tohop(k - 1, n - 1) + tohop(k, n - 1);
    }

    // Phương thức tính tổ hợp chập k của n (Lặp)
    public static int tohoplap(int k, int n) {
        // Nếu k lớn hơn n, trả về 0 vì không có tổ hợp nào
        if (k > n) {
            return 0;
        }
        // Điều kiện biên
        if (k == 0 || k == n) {
            return 1;
        }
        
        // Mảng để lưu giá trị các tổ hợp
        int[][] C = new int[n + 1][k + 1];
        
        // Tính toán giá trị tổ hợp
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                // Điều kiện biên
                if (j == 0 || j == i) {
                    C[i][j] = 1;
                } else {
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                }
            }
        }
        return C[n][k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n:");
        int n = sc.nextInt();
        System.out.println("Nhap k: ");
        int k = sc.nextInt();

        // Sử dụng phương thức đệ quy
        int kqDeQuy = tohop(k, n);
        System.out.println("C(" + k + ", " + n + ") (De quy) = " + kqDeQuy);

        // Sử dụng phương thức lặp
        int kqLap = tohoplap(k, n);
        System.out.println("C(" + k + ", " + n + ") (Lap) = " + kqLap);
    }
}
