
class Solution {
    public boolean isUnivalTree(TreeNode root) {
       return isUnivalTree(root, root.val);
        
    }
    
    public boolean isUnivalTree(TreeNode root, int value) {
        if(root.val != value){
            return false;
        }
        isUnivalTree(root.right);
        isUnivalTree(root.left);
    }
  
}