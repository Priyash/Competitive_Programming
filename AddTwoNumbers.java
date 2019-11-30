public class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        next = null;
    }
}

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode head = null;
        ListNode curr = null;
        while(l1 != null || l2 != null){
            int a = l1.data;
            int b = l2.data;
            sum = a + b + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            if(head == null){
                head = newNode;
                curr = head;
            }else{
                curr.next = newNode;
                curr = newNode;
            }
            if(l1 !=null || l2 != null){
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
            curr = newNode;
        }
       return head;
    }



    public static void main(String[] args) {
        
    }
}