/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huffmancode;

/**
 *
 * @author rowele
 */
public class PriorityQ {
    private HuffmanTree[] q;
    private int front;
    private int back;
    private int numOfItems;

    public PriorityQ(int data){
        q = new HuffmanTree[data];
        numOfItems = 0;
    }
    public int getSize(){
        return numOfItems;
    }
    public boolean isEmpty(){
        return numOfItems == 0;
    }   
    public boolean isFull(){
        return numOfItems == q.length;
    }
    public HuffmanTree delete(){
        numOfItems--;
        HuffmanTree temp = q[numOfItems];
        return temp;
    }
    public HuffmanTree peek(){
        return q[numOfItems - 1];
    }
    public void insert(HuffmanTree tree){
        int i;
        if(isEmpty()){
        q[numOfItems] = tree;
        numOfItems = 1;
    }
        else{
            for(i = numOfItems - 1; i >= 0 ; i--){
                if(tree.frequency > q[i].frequency)
                q[i+1] = q[i];
            else
                break;
        }
            q[i+1] = tree;
            numOfItems++;
        }
    }
}
