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
class Solution {
    public TreeNode createParentMapping(TreeNode root, Map<TreeNode,TreeNode> map, int target) {

        TreeNode res = null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        map.put(root, null);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(node.val == target) {
                res = node;
            }
            if(node.left!=null) {
                q.add(node.left);
                map.put(node.left, node);
            }
            if(node.right!=null) {
                q.add(node.right);
                map.put(node.right, node);
            }
        }
        return res;
    }
    
    
    public int burnTree(TreeNode root, Map<TreeNode, TreeNode> map) {

        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        vis.put(root, true);

        int ans = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            
            boolean flag = false;
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.left!=null && !vis.containsKey(node.left)) {
                    flag = true;
                    q.add(node.left);
                    vis.put(node.left, true);
                }
                if(node.right!=null && !vis.containsKey(node.right)) {
                    flag = true;
                    q.add(node.right);
                    vis.put(node.right, true); 
                }
                if(map.get(node)!= null && !vis.containsKey(map.get(node))) {
                    flag = true;
                    q.add(map.get(node));
                    vis.put(map.get(node), true);
                }
            }
            if(flag == true)
                ans++;
        }
        return ans;
    }
    
    public int amountOfTime(TreeNode root, int start) {
        int ans = 0;
        Map<TreeNode, TreeNode> hm = new HashMap<>();
        
        TreeNode target = createParentMapping(root, hm, start);
        return burnTree(target, hm);

        //return ans;
    }
}