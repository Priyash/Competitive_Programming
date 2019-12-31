/**
 * removeDuplicateFromLinkedList
 */
public class removeDuplicateFromLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    
    public static ListNode removeElements(ListNode head, int value) {
        ListNode currNode = head;
        ListNode prevNode = head;
        while(head != null && head.val == value){
            head = head.next;
        }

        while (currNode != null) {
            if (currNode.val != value) {
                prevNode = currNode;
            }
            currNode = currNode.next;
            if (prevNode != null) {
                prevNode.next = currNode;
            }
        }
        return head;
    }


    public static ListNode generateData(int[] arr) {
        ListNode l1 = new ListNode(arr[0]);
        ListNode l2 = new ListNode(arr[1]);
        ListNode l3 = new ListNode(arr[2]);
        ListNode l4 = new ListNode(arr[3]);
        ListNode l5 = new ListNode(arr[4]);
        ListNode l6 = new ListNode(arr[5]);
        ListNode l7 = new ListNode(arr[6]);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;
        return l1;
    }

    public static ListNode generateData_v2(int[] arr) {
        ListNode l1 = new ListNode(arr[0]);
        ListNode l2 = new ListNode(arr[1]);
        ListNode l3 = new ListNode(arr[2]);

        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        return l1;
    }

    public static ListNode generateData_v3(int[] arr) {
        ListNode l1 = new ListNode(arr[0]);

        l1.next = null;
        return l1;
    }

    public static ListNode generateData_v4(int[] arr) {
        ListNode l1 = new ListNode(arr[0]);
        ListNode l2 = new ListNode(arr[1]);

        l1.next = l2;
        l2.next = null;
        return l1;
    }

    public static void main(String[] args) {
        // 
        int[] arr1 = {1,2,2};
        int value = 1;
        ListNode l1 = generateData_v2(arr1);
        ListNode result = removeElements(l1, value);
    }
}