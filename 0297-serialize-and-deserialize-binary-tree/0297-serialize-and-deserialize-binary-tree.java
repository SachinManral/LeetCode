/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null) {
                res.append("n ");
                continue;
            }

            res.append(node.val+ " ");
            q.offer(node.left);
            q.offer(node.right);
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] value = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(value[0]));
        q.offer(root);
        
        for(int i=1; i<value.length; i++){
            TreeNode curr = q.poll();

            if(!value[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(value[i]));
                curr.left = left;
                q.offer(left);
            }

            if(!value[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(value[i]));
                curr.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));