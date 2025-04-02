/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huffmancode;

/**
 *
 * @author rowele
 */
    public class Node {
    int frequency;
    char c;
    Node left;
    Node right;
    public Node(char c, int frequency){
        this.c = c;
        this.frequency = frequency;
    } 
    public Node(HuffmanTree left, HuffmanTree right) {
        this.frequency = left.frequency + right.frequency;
        this.c = '\0';
    }
    public void display(Node n){
        System.out.println("Char:" + c + " Count: " + frequency + " ");
    }
  
}
