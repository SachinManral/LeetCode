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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list = new ArrayList<>();

        for(ListNode l:lists){
            while(l!=null ){
                list.add(l.val);
                l = l.next;
            }
        }
        if(list.size()==0) return null;
        Collections.sort(list);

        ListNode head = new ListNode(list.get(0));
        ListNode dummy = head;
        for(int i=1; i<list.size(); i++){
            dummy.next = new ListNode(list.get(i));
            dummy = dummy.next;
        }
        return head;
    }
}