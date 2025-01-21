public class EvenOdd_5386{
	public static void main(String args[]){
		int even_5386=0;
		int odd_5386=0;
		for(int i=0;i<10;i++){
			int num=Integer.parseInt(args[i]);
			int temp =num%2==0?even_5386++:odd_5386++;
		}
		System.out.println("The no. of even numbers are :"+even_5386);		
		System.out.println("The no. of odd numbers are :"+odd_5386);
		}
	}