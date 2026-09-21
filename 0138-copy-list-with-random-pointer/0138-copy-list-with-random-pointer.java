/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;

        HashMap<Node, Node> map = new HashMap<>();         //original, copy
        Node cur = head;
        Node prev = null;
        Node newHead = null;

        while(cur!=null){
            Node temp = new Node(cur.val);
            map.put(cur, temp);

            if(newHead==null){
                newHead = temp;
                prev = newHead;
            }else{
                prev.next = temp;
                prev = prev.next;
            }
            cur = cur.next;
        }

        //fill random
        cur = head;
        Node newCur = newHead;

        while(cur!=null){
            if(cur.random==null){
                newCur.random=null;
            }else{
                newCur.random = map.get(cur.random);
            }

            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}