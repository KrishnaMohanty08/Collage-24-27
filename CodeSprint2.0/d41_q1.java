import java.util.*;

class TreeNode{
  int val;
  TreeNode left,right;
  TreeNode(int val){this.val=val;}
}
public class d41_q1{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    String[] input=sc.nextLine().trim().split("\\s+");
    TreeNode root=buildTree(input);
    System.out.println(maxDepth(root));
  }
  public static int maxDepth(TreeNode root){
    if(root==null)return 0;
    return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
  }
  public static TreeNode buildTree(String[] nodes){
    if(nodes.length==0||nodes[0].equals("null"))return null;
    TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(root);
    int i=1;
    while(!queue.isEmpty() && i<nodes.length){
      TreeNode curr=queue.poll();
      if(i<nodes.length && !nodes[i].equals("null")){
        curr.left=new TreeNode(Integer.parseInt(nodes[i]));
        queue.offer(curr.left);
      }
      i++;
      if(i<nodes.length &&!nodes[i].equals("null")){
        curr.right=new TreeNode(Integer.parseInt(nodes[i]));
        queue.offer(curr.right);
      }
      i++;
    }
    return root;
  }
}