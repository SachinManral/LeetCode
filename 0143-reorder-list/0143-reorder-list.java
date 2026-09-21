// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public void reorderList(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;

//         while(fast!=null && fast.next !=null){
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         ListNode sec = reverse(slow.next);
//         slow.next = null;

//         ListNode first = head;
//         while(sec!=null){
//             ListNode temp1 = first.next;
//             first.next =sec;

//             ListNode temp2 = sec.next;
//             sec.next = temp1;

//             first = temp1;
//             sec = temp2;
//         }

//     }
//     public ListNode reverse(ListNode node){
//         ListNode prev = null;
//         ListNode curr = node;

//         while(curr!=null){
//             ListNode next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
//         return prev;
//     }
// }





class Solution {
    ListNode curr;
    public void reorderList(ListNode head) {
        curr = head;
        solve(curr);
    }

    public void solve(ListNode head){
        if(head==null) return;

        solve(head.next);

        ListNode temp = curr.next;
        if(curr.next ==null) return;
        else if(curr==head){
            curr.next = null;
            return;
        }

        curr.next = head;
        head.next = (temp==head)?null:temp;
        curr = temp;

    }
}