import java.util.*;
public class d42_q2{
  static class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int x){val=x;}
  }
  public static int countNodes(TreeNode root){
    if(root==null)return 0;
    int leftDepth=getDepth(root,true);
    int rightDepth=getDepth(root,false);
    if(leftDepth==rightDepth){
      return (1<<leftDepth)-1;
    }return 1+countNodes(root.left)+countNodes(root.right);
  }
  private static int getDepth(TreeNode node,boolean left){
    int depth=0;
    while(node!=null){
      node=left?node.left:node.right;
      depth++;
    }
    return depth;
  }
  public static TreeNode buildTree(Integer[] arr){
    if(arr.length==0|| arr[0]==null)return null;
    TreeNode root=new TreeNode(arr[0]);
    Queue<TreeNode>queue=new LinkedList<>();
    queue.offer(root);
    int i=1;
    while(i<arr.length){
      TreeNode current=queue.poll();
      if(i<arr.length && arr[i]!=null){
        current.left=new TreeNode(arr[i]);
        queue.offer(current.left);
      }
      i++;
      if(i<arr.length && arr[i]!=null){
        current.right=new TreeNode(arr[i]);
        queue.offer(current.right);
      }i++;
    }return root;
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    Integer[] arr=Arrays.stream(sc.nextLine().split(" "))
      .map(s->s.equals("-1")?null:Integer.parseInt(s)).toArray(Integer[]::new);
    TreeNode root=buildTree(arr);
    System.out.println(countNodes(root));
  }
}