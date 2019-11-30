/**
 * LinkedList
 */
public class LinkedList {
    Node head = null;
    
    public LinkedList(){
    }

    public static class Node{
        int item;
        Node next;
        public Node(){

        }
        
    }

    public void add(int data){
        Node newNode = new Node();
        newNode.item = data;
        newNode.next = null;

        if(head == null){
            head = new Node();
            head = newNode;
        }
        else{
            Node currNode = head;
            while(currNode.next != null){
                currNode = currNode.next;
            }
            if(currNode.next == null){
                currNode.next = newNode;
            }
        }
    }

    public void printNodes(){
        Node currNode = head;
        while(currNode !=null){
            System.out.println(currNode.item);
            currNode = currNode.next;
        }
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.printNodes();
    }
}