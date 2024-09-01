/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctdl_gt;
import java.util.Scanner;
/**
 *
 * @author allec
 */
    

// Một nút trong cây
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

//Cây tìm kiếm nhị phân
class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Hàm chèn một ptu vào cây
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Hàm đệ quy để chèn 1 ptu vào cây
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // Hàm duyệt cây theo thứ tự trước (preorder)
    void preorder() {
        preorderRec(root);
        System.out.println();
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Hàm duyệt cây theo thứ tự giữa (inorder)
    void inorder() {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Hàm duyệt cây theo thứ tự sau (postorder)
    void postorder() {
        postorderRec(root);
        System.out.println();
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap cac so nguyen (nhap 0 de dung):");
        int num;
        do {
            num = scanner.nextInt();
            if (num != 0) {
                tree.insert(num);
            }
        } while (num != 0);

        
        System.out.println("Duyet cay theo thu tu truoc:");
        tree.preorder();

        System.out.println("Duyet cay theo thu tu giua:");
        tree.inorder();

        System.out.println("Duyet cay theo thu tu sau:");
        tree.postorder();

        // Nhập một số nguyên x và chèn vào cây
        System.out.println("Nhap so nguyen x de chen vao cay:");
        int x = scanner.nextInt();
        tree.insert(x);

        
        System.out.println("Duyet cay theo thu tu giua sau khi chen x:");
        tree.inorder();

        scanner.close();
    }
}

