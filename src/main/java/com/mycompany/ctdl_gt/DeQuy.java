package com.mycompany.ctdl_gt;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author allec
 */
public class DeQuy {
    
    static int count = 0;

    static void welcome() {
        count++;
        // Phần cơ sở: Điều kiện thoát khỏi đệ quy
        if (count <= 5) {
            System.out.println(count + ". Hello anh em 23IT2");
            // Phần đệ quy: Thân hàm có chứa lời gọi đệ quy
            welcome();
        }
    }
    


    public static void main(String[] args) {

        // welcome();
        int n = 10;                        // số lượng phần tử của chuỗi Fibonacci
        System.out.println("Chuỗi Fibonacci sử dụng đệ quy:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    
    public class FibonacciIterative {

    public static void main(String[] args) {
        int n = 10;                  // số lượng phần tử của chuỗi Fibonacci
        System.out.println("Chuỗi Fibonacci không sử dụng đệ quy:");
        fibonacci(n);
    }

    public static void fibonacci(int n) {
        int first = 0, second = 1;
        System.out.print(first + " " + second + " ");

        for (int i = 2; i < n; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
    }
}
    
    public class GCDRecursive {

    public static void main(String[] args) {
        int a = 24, b = 36;
        System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + gcdRecursive(a, b));
    }

    public static int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcdRecursive(b, a % b);
        }
    }
}
    
    public class GCDIterative {

    public static void main(String[] args) {
        int a = 24, b = 36;
        System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + gcdIterative(a, b));
    }

    public static int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
    

public class PermutationsRecursive {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        permuteRecursive(nums, 0, result);
        
        System.out.println("Các hoán vị của dãy số:");
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    public static void permuteRecursive(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num);
            }
            result.add(perm);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permuteRecursive(nums, start + 1, result);
                swap(nums, start, i);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


public class PermutationsIterative {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permuteIterative(nums);
        
        System.out.println("Các hoán vị của dãy số:");
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }

    public static List<List<Integer>> permuteIterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());  
        
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> currentPermutations = new ArrayList<>();
            
            for (List<Integer> perm : result) {
                for (int j = 0; j <= perm.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(perm);
                    newPermutation.add(j, nums[i]);
                    currentPermutations.add(newPermutation);
                }
            }
            
            result = currentPermutations;
        }
        
        return result;
    }
}


}


 

