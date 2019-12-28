/**
 * MergeSortedLinkedList
 */

 


public class MergeSortedLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }
    

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }else if(l2 == null) {
            return l1;
        }else{
            if(l1.val <= l2.val) {
               l1.next = mergeTwoLists(l1.next, l2);
               return l1;
            }else{
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    public static ListNode generateData(int[] arr) {
        ListNode l1 = new ListNode(arr[0]);
        ListNode l2 = new ListNode(arr[1]);
        ListNode l3 = new ListNode(arr[2]);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        return l1;
    }



    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode l1 = generateData(arr1);
        ListNode l2 = generateData(arr2);
        mergeTwoLists(l1, l2);
    }    
}


