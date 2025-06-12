import java.util.*;
public class d28_q1{
  public static String rearrangeString(String s){
    int[] freq=new int[26];
    for(char c:s.toCharArray()){
      freq[c-'a']++;
    }
    PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[0]-a[0]);
    for(int i=0;i<26;i++){
      if(freq[i]>0){
        if(freq[i]>(s.length()+1)/2){
          return "";
        }maxHeap.offer(new int[]{freq[i],i});
      }
    }
    StringBuilder ans=new StringBuilder();
    while(maxHeap.size()>=2){
      int[] first=maxHeap.poll();
      int[] second=maxHeap.poll();
      ans.append((char)(first[1]+'a'));
      ans.append((char)(second[1]+'a'));
      if(--first[0]>0)maxHeap.offer(first);
      if(--second[0]>0)maxHeap.offer(second);
    }
    if(!maxHeap.isEmpty()){
      int[]last =maxHeap.poll();
      if(last[0]>1)return "";
      ans.append((char)(last[1]+'a'));
    }return ans.toString();      
  }
  public static void main(String args[]){
    System.out.print(rearrangeString(args[0]));
  }
}