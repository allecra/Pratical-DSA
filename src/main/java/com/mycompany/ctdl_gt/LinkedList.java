/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ctdl_gt;

/**
 *
 * @author allec
 */
public class LinkedList {
    public static class Person{

        private String name;
        private int age;
        
        private Person next = null; 
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
            this.next = null;
        }
        
         public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Person getNext() {
            return next;
        }

        public void setNext(Person next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "name =" + name + ", age =" + age;
        }
        
    }
    
    public static class Node<T> {

        public T data;
        public Node<T> next;
        public Node(){}
 
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }    
        
        public T getData(){
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
        
    }
    
    public static void testNode(){
         Person p1 = new Person("Meomeo",25);
        Person p2 = new Person("Hehe",12);
        Person p3 = new Person("Gaugau",66);
        Person p4 = new Person("Haha",21);
        Person p5 = new Person("Huhu",14);
        
        
        Node<Person> n1 = new Node<>();
        n1.setData(p1);
        
        Node<Person> n2 = new Node<>();
        n2.setData(p2);
        
        Node<Person> n3 = new Node<>();
        n3.setData(p3);
        
        Node<Person> n4 = new Node<>();
        n4.setData(p4);
        
        Node<Person> n5 = new Node<>();
        n5.setData(p5);
        
        n1.setNext(n5);
        n5.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n2);
        
        Node<Person> head = n1;
        while (true) {            
            System.out.println(head.getData());
            head = head.getNext();
            if(head == null){
                break;
    }
    
    
    }
}
    
    
    
   
}
