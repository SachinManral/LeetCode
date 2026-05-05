/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        if(k==0) return head;
        ListNode dummy = head;
        int size = 1;

        while(dummy.next!=null){
            size++;
            dummy = dummy.next;
        }

        k=k%size;
        if(k==0) return head;

        ListNode curr = head;
        int t = size-k-1;
        while(t-- > 0){
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        dummy.next = head;

        return newHead;
    }
}