/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huffmancode;

import javax.annotation.processing.Messager;

/**
 *
 * @author rowele
 */

public class HuffmanTree {
    public Node root;
    public String[] table = new String[27];
    public int frequency;
        public HuffmanTree(Node n){
        this.root = n;
        this.frequency = n.frequency;
    }
        public HuffmanTree(){
        
    }
    public HuffmanTree createTree(String text){
       PriorityQ Que = new PriorityQ(27);
        char arr[] = new char[text.length()];
        for(int i = 0; i < text.length(); i++){
            arr[i] = text.charAt(i);
        }
        for (int i = 0; i < arr.length; i++) {
            boolean counted = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    counted = true;
                    break;
                }
            }
            if (!counted) {
                int count = 1; 
                for (int k = i + 1; k < arr.length; k++) {
                    if (arr[i] == arr[k]) {
                        count++;
                    }
                
                }
                Node n = new Node(arr[i], count);
                HuffmanTree tree = new HuffmanTree(n);
                Que.insert(tree);
            }
        } 
        int temp = Que.getSize();
        while(temp > 1){
            HuffmanTree left = Que.delete();
            HuffmanTree right = Que.delete();
            Node mergedNodes = new Node(left, right);
            mergedNodes.left = left.root;
            mergedNodes.right = right.root;
            HuffmanTree merged = new HuffmanTree(mergedNodes);
            //System.out.println(merged.frequency + " " + merged.root.left);
            Que.insert(merged);
            temp = Que.getSize();
    }
        HuffmanTree n = Que.peek();
        n.root = Que.peek().root;
        
        return n;
    }
    public void decode(Node n, String s) {
    String message = "";
    Node curr = n;
    for (int i = 0; i < s.length(); i++) {
        System.out.print(s.charAt(i));
        char c = s.charAt(i);
        if(c == '0'){
            curr = curr.left;
        }
        else if(c == '1'){
            curr = curr.right;
        }
        if (curr.left == null && curr.right == null) {
            message += curr.c;     
            curr = n;
        }
    }
    System.out.println("\nDecoded message: " + message);
}

    public void codeTable(Node n, String code1) {
    if(n == null){
        return;
    }
    if (n.c != '\0' && n.c != ' ') {
        int index = 0;
        char targetChar = n.c;
        
        while (index < targetChar - 'a') {
            index++;
        }
        
        System.out.println(index);
        table[index] = code1;
        System.out.println("Char: " + n.c + ", Code: " + code1);
    }
    else if(n.c == ' '){
        int index = 26;
        table[index] = code1;

    }
    else {
        codeTable(n.left, code1 + "0");
        codeTable(n.right, code1 + "1");
}
    }
    public String encode(String s) {
        String binCode = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                String code = table[26];
                if(code != null){
                    binCode += code;
                }
            }
            else if (c >= 'a') {
                int index2 = c - 'a';
                String code = table[index2];
                
                if (code != null) {
                    binCode += code;
                }
                    
                }
            }
        return binCode;
    }
    
    public void displayFreq(String text){
        char arr[] = new char[text.length()];
        for(int i = 0; i < text.length(); i++){
            arr[i] = text.charAt(i);
        }
        for (int i = 0; i < arr.length; i++) {
            boolean counted = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    counted = true;
                    break;
                }
            }
            if (!counted) {
                int count = 1; 
                for (int k = i + 1; k < arr.length; k++) {
                    if (arr[i] == arr[k]) {
                        count++;
                    }
                }
                System.out.println("Char:" + arr[i] + " Count: " + count + " ");
            }
        }
    }
}
