package com.mycompany.ctdl_gt;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    private static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }System.out.println("Bubble Sort, sau lan lap " + (i + 1) + ": " + Arrays.toString(arr));
        }
    }

     public static void InsertionSort(int[] arrI) {
        for (int i = 1; i < arrI.length; i++) {
            int chen = arrI[i]; // cái cần chèn
            int j;
            for (j = i; j > 0 && arrI[j - 1] > chen; j--) {
                arrI[j] = arrI[j - 1];
            }
            arrI[j] = chen;
            System.out.println("Insertion Sort, sau lan lap " + i + ": " + Arrays.toString(arrI));
        }
    }

    
    public static void SelectionSort(int [] arrS){
        for(int i = 0; i<arrS.length;i++){
            int min = i;
            //tìm min trong vế trái 
             for(int j = i+1; j < arrS.length; j++){
                 if (arrS[j]<arrS[min]){
                     min = j;
                 }
             }
               int swap = arrS[min];
               arrS[min]=arrS[i];
               arrS[i]=swap;
               
               System.out.println("Selection Sort, sau lan lap " + (i + 1) + ": " + Arrays.toString(arrS));
        }
    }
    
     //sắp xếp
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    //tách ra
    private int[] mergeSort(int[] arr, int L, int R) {
        if (L >= R) {
            return new int[]{arr[L]};
        }
        
        int K = L + (R - L) / 2;
        System.out.println("Chia mang: " + Arrays.toString(Arrays.copyOfRange(arr, L, R+1)));
        int[] arr1 = mergeSort(arr, L, K);
        int[] arr2 = mergeSort(arr, K + 1, R);
        
        System.out.println("Tron mang: " + Arrays.toString(arr1) + " va " + Arrays.toString(arr2));
        int[] result = merge(arr1, arr2);
        System.out.println("Ket qua sau khi tron: " + Arrays.toString(result));
        return result;
    }
    
    //mix lại
    private int[] merge(int[] arr1, int[] arr2) {
            //mảng mới = tổng độ dài 2 mảng để lưu gtri sau khi sắp xếp
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        /*i: Đây là chỉ số (index) dùng để duyệt qua mảng arr1.
        Bắt đầu từ 0 và tăng dần khi ta lấy phần tử từ arr1.
        
        j: Đây là chỉ số dùng để duyệt qua mảng arr2.
        Bắt đầu từ 0 và tăng dần khi ta lấy phần tử từ arr2.
        
        k: Đây là chỉ số dùng để điền vào mảng kết quả result.
        Bắt đầu từ 0 và tăng dần mỗi khi ta thêm một phần tử vào result. */
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++]; //thêm i vào mảng kq
            } else {
                result[k++] = arr2[j++]; //thêm j vào mảng kq
            }
        }
        // Xử lý các phần tử còn lại trong arr1 (nếu có)
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        
        return result;
    }
    
    public static void TestMergeSort(){
         Sort sorting = new Sort();
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Nhap so luong phan tu cua mang: ");
            int n = sc.nextInt();
            
            int[] test = new int[n];
            System.out.println("Nhap cac phan tu cua mang:");
            for (int i = 0; i < n; i++) {
                System.out.print("Phan tu thu " + (i+1) + ": ");
                test[i] = sc.nextInt();
            }
            
            System.out.println("Mang ban dau: " + Arrays.toString(test));
            
            int[] sortedArray = sorting.sortArray(test);
            
            System.out.println("Mang sau khi sap xep: " + Arrays.toString(sortedArray));
        }
    }
    
    public static void QuickSort(int[] a, int L, int R){
        //B1: Chọn khóa
        if(L<R){
        int key = a[(L+R)/2];
        
        //B2: Phân bổ lại mảng theo khoa, lớn hơn khóa 1 bên, nhỏ hơn khóa 1 bên
        int p = Phanvung(a, L, R, key);
        System.out.println("L = "+L+" R = "+R+" key = "+ key+" p = "+p);
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, L, R-1)));
            System.out.println("================================    ");
        //B3: Chia đôi mang => Lặp lại
        QuickSort(a, L, p-1);
        QuickSort(a, p ,L);
        }
    }
    
    public static int Phanvung(int [] a, int L, int R, int key){
        int iL = L;
        int iR = R;
        while(iL<=iR){
            //với iL, đi tìm phần tử >= key để đổi chỗ
            while(a[iL]<key) iL++;
            //với ỉR, đi tìm phần tử <= key để đỏio chỗ
            while(a[iR]>key) iR--;
            //đổi chỗ 2 ptu đang đứng k đúng vị trí
            if(iL<=iR){
                int temp = a[iL];
                a[iL] = a[iR];
                a[iR]= temp;
                iL++; iR--;
            }
        }
        return iL;
    }
    
    public static void TestQuickSort(){
        Scanner sc = new Scanner(System.in);
        Sort QSort = new Sort();
        System.out.print("Nhap so luong phan tu cua mang: ");
            int n = sc.nextInt();
            
            int[] test = new int[n];
            System.out.println("Nhap cac phan tu cua mang:");
            for (int i = 0; i < n; i++) {
                System.out.print("Phan tu thu " + (i+1) + ": ");
                test[i] = sc.nextInt();
            }
            
            System.out.println("Mang ban dau: " + Arrays.toString(test));
            System.out.println("Start: ");
            QuickSort(test, 0, test.length - 1);  // Gọi QuickSort trực tiếp
            System.out.println("Finish.");
            System.out.println("Mang sau khi sap xep: " + Arrays.toString(test));
            sc.close();  // Đóng Scanner
    }
    
    
    public static void TestSort() {
        Scanner sc = new Scanner(System.in);
        int dodaimang;
        do {
            System.out.print("Nhap do dai cua mang: ");
            dodaimang = sc.nextInt();
            if (dodaimang <= 0) {
                System.out.println("Do dai cua mang > 0. Vui long nhap lai...");
            }
        } while (dodaimang <= 0);

        int[] arr = new int[dodaimang];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Gia tri cua phan tu a[" + i + "]: ");
            arr[i] = sc.nextInt();
        }
        System.out.println();
        //System.out.println("Sap xep bang BUBBLE SORT: ");
        //bubbleSort(arr);
        //System.out.println();
        //System.out.println("Sap xep bang INSERT SORT: ");
        //InsertionSort(arr);
        System.out.println();
        System.out.println("Sap xep bang SELECTION SORT: ");
        SelectionSort(arr);
    }

    public static void main(String[] args) {
     //  TestSort();
        TestMergeSort();
        //TestQuickSort();
    }
}
