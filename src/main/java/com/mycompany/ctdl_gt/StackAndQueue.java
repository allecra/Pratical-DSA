/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctdl_gt;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author allec
 */
public class StackAndQueue {
    
    private Stack<Integer> stack;

    // Constructor
    public StackAndQueue() {
        stack = new Stack<>();
    }

    // 1. boolean isEmpty() - trả về true nếu ngăn xếp là trống và false nếu ngược lại.
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // 2. void clear() - xóa sạch ngăn xếp.
    public void clear() {
        stack.clear();
    }

    // 3. void push(int x) - chèn một nút có giá trị x vào đỉnh của ngăn xếp.
    public void push(int x) {
        stack.push(x);
    }

    // 4. int pop() - loại bỏ phần tử ở đỉnh ngăn xếp và trả về giá trị của nó; ném ra EmptyStackException nếu ngăn xếp rỗng.
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.pop();
    }

    // 5. int top() - trả về giá trị của một nút ở đỉnh của ngăn xếp; ném ra EmptyStackException nếu ngăn xếp rỗng.
    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }

    // 6. void traverse() - hiển thị tất cả các giá trị trong ngăn xếp từ đỉnh đến đáy.
    public void traverse() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements (from top to bottom):");
            for (int i = stack.size() - 1; i >= 0; i++) {
                System.out.println(stack.get(i));
            }
        }
    }

    // 7. Chuyển đổi số nguyên từ hệ thập phân sang hệ nhị phân và hiển thị trên màn hình.
    public static void convertDecimalToBinary(int decimal) {
        StackAndQueue stack = new StackAndQueue();
        
        if (decimal == 0) {
            System.out.println("Binary: 0");
            return;
        }

        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal = decimal / 2;
        }

        System.out.print("Binary: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
    
    public static void Test(){
        StackAndQueue myStack = new StackAndQueue();

        // Testing stack operations
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.traverse();

        System.out.println("Top element: " + myStack.top());
        System.out.println("Popped element: " + myStack.pop());
        myStack.traverse();

        System.out.println("Is stack empty? " + myStack.isEmpty());
        myStack.clear();
        System.out.println("Is stack empty after clear? " + myStack.isEmpty());

        // Testing decimal to binary conversion
        int decimalNumber = 42;
        System.out.println("Decimal: " + decimalNumber);
        convertDecimalToBinary(decimalNumber);
    }

    // Main method to test the stack and conversion
    public static void main(String[] args) {
      //  StackAndQueue();
        Test();
    }
}
