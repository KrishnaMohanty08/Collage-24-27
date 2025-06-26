import java.util.*;
public class d42_q1{
  static class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int x){val=x;}
  }
  public static TreeNode buildBST(int[] nums,int left,int right){
    if(left>right)return null;
    int mid=(left+right)/2;
    TreeNode root=new TreeNode(nums[mid]);
    root.left=buildBST(nums,left,mid-1);
    root.right=buildBST(nums,mid+1,right);
    return root;
  }
  public static List<Integer>levelOrder(TreeNode root){
    List<Integer> result =new ArrayList<>();
    Queue <TreeNode>q=new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
      TreeNode node=q.poll();
      if(node !=null){
        result.add(node.val);
        q.add(node.left);
        q.add(node.right);
      }else{
        result.add(null);
      }
    }
    while(!result.isEmpty() && result.get(result.size()-1)==null){
      result.remove(result.size()-1);
    }
    return result;
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    String[] parts=sc.nextLine().split(" ");
    int[] nums=new int[parts.length];
    for(int i=0;i<parts.length;i++){
      nums[i]=Integer.parseInt(parts[i]);
    }
    TreeNode root=buildBST (nums,0,nums.length-1);
    List<Integer> result=levelOrder(root);
    System.out.println(result);
  }
}