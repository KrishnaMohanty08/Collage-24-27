public class largest3_5386{
	public static void main(String args[]){
		int num1=Integer.parseInt(args[0]);
		int num2=Integer.parseInt(args[1]);
		int num3=Integer.parseInt(args[2]);
		String result=(num1>num2 && num1>num3)?"The NUM1 id greatest ="+num1:	
		(num2>num1 && num2>num3)?"The NUM2 id greatest="+num2:"The NUM3 id greatest="+num3;
		System.out.println(result);
		}
	}
		