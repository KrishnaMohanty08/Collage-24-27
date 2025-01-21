import java.util.Scanner;
public class sort_5386{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int arr[]=new int[10];

		for(int i=0;i<10;i++){
			System.out.println("Enter numbers:");
			arr[i]=sc.nextInt();
		}
		for (int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1-i;j++){
				if (arr[j]>arr[j+1]){
					int temp= arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i=0;i<10;i++){
			System.out.print(arr[i]+" ");
		}
	}
}