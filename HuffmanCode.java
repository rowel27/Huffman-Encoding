/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package huffmancode;
import java.util.Scanner;

/**
 *
 * @author rowele
 */
public class HuffmanCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a message: ");
        String s = input.nextLine();
        HuffmanTree a = new HuffmanTree();
        HuffmanTree t = a.createTree(s);
        t.codeTable(t.root, "");
        System.out.print("Encoded Message: ");
        t.encode(s);
        t.decode(t.root, t.encode(s));     
    }
    
}
