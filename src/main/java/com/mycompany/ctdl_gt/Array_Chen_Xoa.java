package com.mycompany.ctdl_gt;

import java.util.Scanner;

public class Array_Chen_Xoa {
    static Scanner sc = new Scanner(System.in);
    
    public static void NhapMang() {
        int dodaimang;
        
        do {
            System.out.print("Nhap do dai mang: ");
            dodaimang = sc.nextInt();
            if (dodaimang < 0) {
                System.out.println("Do dai mang phai > 0. Vui long nhap lai...");
            }
        } while (dodaimang <= 0);
        
        int[] arr = new int[dodaimang];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhap gia tri a[" + i + "]: ");
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Nhap vi tri muon chen: ");
        int vtri = sc.nextInt();
        System.out.print("Nhap gia tri muon chen vao vi tri " + vtri + ": ");
        int gtri = sc.nextInt();
        
        ChenMang(arr, vtri, gtri);
    }
    
    public static void ChenMang(int[] arr, int vtri, int gtri) {
        int[] newArr = new int[arr.length + 1];
        
        for (int i = 0; i < newArr.length; i++) {
            if (i < vtri) {
                newArr[i] = arr[i];
            } else if (i == vtri) {
                newArr[i] = gtri;
            } else {
                newArr[i] = arr[i - 1];
            }
        }
        
        System.out.println("Mang sau khi chen:");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }
    
    
 
    
    public static void XoaGtriMang() {
        int dodaimang;
        
        do {
            System.out.println("Nhap do dai mang: ");
            dodaimang = sc.nextInt();
            if (dodaimang < 0) {
                System.out.println("Do dai mang phai > 0. Vui long nhap lai...");
            }
        } while (dodaimang <= 0);
        
        int[] arr = new int[dodaimang];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhap gia tri a[" + i + "]: ");
            arr[i] = sc.nextInt();
        }
        
        System.out.print("Nhap vi tri muon xoa: ");
        int vtri = sc.nextInt();
        
        //goi ham xoa
        XoaMang(arr, vtri);
    }
    
    public static void XoaMang(int[] arr, int vtri){
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i<arr.length;i++){
            if(i != vtri){
                newArr[i]= arr[i];
            }
        }
        
        System.out.println("Mang sau khi xoa:");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
        
    }
    


    public static void main(String[] args) {
        System.out.println("Chen vao mang:");
        NhapMang();
        
        System.out.println("Xoa gia tri trong mang: ");
        XoaGtriMang();
    }
}

