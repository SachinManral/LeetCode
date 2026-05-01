/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public List<Integer> largestValues(TreeNode root) {
//         List<Integer> res = new ArrayList<>();
//         if(root==null) return res;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);

//         while(!q.isEmpty()){
//             int size = q.size();
//             int max = Integer.MIN_VALUE;

//             while(size-- > 0){
//                 TreeNode node = q.poll();
//                 max = Math.max(node.val, max);
//                 if(node.left != null) q.offer(node.left);
//                 if(node.right!=null) q.offer(node.right);
//             }
//             res.add(max);
//         }
//         return res;
//     }
// }








class Solution {
    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int depth){
        if(root==null) return;

        if(depth==res.size()){
            res.add(root.val);
        }else {
            res.set(depth, Math.max(res.get(depth), root.val));
        }

        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}