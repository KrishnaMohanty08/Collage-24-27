// Find the no. of occurrence of each element in a user entered list of nos
public class occ_5386{
public static void main(String args[]){
    int n=args.length;
    int[] arr= new int[n];
    for(int i=0;i<n;i++){
        arr[i] = Integer.parseInt(args[i]);
    }
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-1;j++){
            if (arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
        int count_5386=1;
        for(int i=0;i<n;i++){
            if(i==n-1|| arr[i] != arr[i+1]){
                System.out.println("Occurence of " + arr[i]+ "is:" + count_5386);
                count_5386=1;
            }
            else{
                count_5386++;
            }
        }
    }
}