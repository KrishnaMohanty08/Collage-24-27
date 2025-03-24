public class q3 
{
    public static void main(String[] args)
    {
        System.out.println("Enter the value of n");
        int n=Integer.parseInt(args[0]);
        int prev=0;
        int next=1;
        int current=0;
        for(int i=2;i<n;i++)
        {
            current=prev+next;
            prev=next;
            next=current;
        }
        System.out.println("The nth number of fibonaaci series is:"+current);
    }
    
}
