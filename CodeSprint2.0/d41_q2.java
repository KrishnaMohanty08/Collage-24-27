import java.util.*;

class TreeNode{
  int val;
  TreeNode left,right;
  TreeNode (int val){this.val=val;}
}
public class d41_q2{
  public static TreeNode buildTree(String[] nodes){
    if(nodes.length==0||nodes[0].equals("null"))return null;
    TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
    Queue<TreeNode>queue=new LinkedList<>();
    queue.offer(root);
    int i=1;
    while(!queue.isEmpty()&& i<nodes.length){
      TreeNode current=queue.poll();
      if(i<nodes.length && !nodes[i].equals("null")){
        current.left=new TreeNode(Integer.parseInt(nodes[i]));
        queue.offer(current.left);
      }i++;
      if(i<nodes.length && !nodes[i].equals("null")){
        current.right=new TreeNode(Integer.parseInt(nodes[i]));
        queue.offer(current.right);
      }i++;
    }return root;
  }
  public static boolean isMirror(TreeNode root){
    if(root==null)return true;
    Queue<TreeNode>queue=new LinkedList<>();
    queue.offer(root.left);
    queue.offer(root.right);
    while(!queue.isEmpty()){
      TreeNode left=queue.poll();
      TreeNode right=queue.poll();
      if(left==null && right==null)  continue;
      if(left==null && right ==null || left.val!=right.val) return false;

      queue.offer(left.left);
      queue.offer(right.right);
      queue.offer(left.right);
      queue.offer(right.left);
    }
    return true;
  }
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().trim().split("\\s+");
        TreeNode root = buildTree(input);
        System.out.println(isMirror(root));
    }
}