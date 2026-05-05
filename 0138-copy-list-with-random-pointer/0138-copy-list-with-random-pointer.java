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

// class Solution {
//     public Node copyRandomList(Node head) {
//         if(head==null) return head;

//         HashMap<Node, Node> map = new HashMap<>();
//         Node curr = head;
//         Node prev = null;
//         Node newHead = null;

//         while(curr!=null){
//             Node temp = new Node(curr.val);

//             map.put(curr, temp);

//             if(newHead == null){
//                 newHead = temp;
//                 prev = newHead;
//             }else{
//                 prev.next = temp;
//                 prev = temp;
//             }
//             curr = curr.next;
//         }

//         //fill random
//         curr = head;
//         Node newCurr = newHead;

//         while(curr!=null){
//             if(curr.random==null){
//                 newCurr.random = null;
//             }else{
//                 // Node rNode = curr.random;
//                 newCurr.random = map.get(curr.random);
//             }

//             curr = curr.next;
//             newCurr = newCurr.next;
//         }
//         return newHead;
//     }
// }







class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;

        //Insert new Nodes b/w LL
        Node curr = head;
        while(curr!=null){
            Node currNext = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = currNext;

            curr = currNext;
        }

        //Deep copy of Random pointers
        curr= head;
        while(curr!=null && curr.next !=null){

            if(curr.random==null){
                curr.next.random = null;
            }else{
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        //seperate LL
        Node newHead = head.next;
        Node newCurr = newHead;
        curr = head;

        while(curr!=null && newCurr!=null){
            curr.next = curr.next==null?null:curr.next.next;
            newCurr.next = newCurr.next==null?null:newCurr.next.next;
            
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }
}