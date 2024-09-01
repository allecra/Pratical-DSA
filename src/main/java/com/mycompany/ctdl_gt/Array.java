/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctdl_gt;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author allec
 */
public class Array {
    public static void main(String[] args) {
 int[] numbers = new int[6];
 // Gán giá trị cho các phần tử của mảng
//numbers[0] = 2; numbers[1] = 4; numbers[2] = 10; 
//numbers[3] = 5; numbers[4] = 15; numbers[5] = 3;

// Nhập giá trị cho các phần tử của mảng
        System.out.println("Nhap lan luot cac phan tu mang: ");
        Scanner sc = new Scanner(System.in);
        //nhập
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Phan tu thu " + i + ": ");
            numbers[i] = sc.nextInt();
        }
        
      //  System.out.print("Cac phan tu mang la: ");
       // for(int i = 0; i<numbers.length;i++){
       //     System.out.print(numbers[i]+" ");
       // }
       
        System.out.println(Arrays.toString(numbers));
 }
 }
 

