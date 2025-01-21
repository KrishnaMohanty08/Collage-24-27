class static_5386{
	public static void main(String args[]){
		object ob1=new object();
		object ob2=new object();
		object ob3=new object();
		System.out.println("The number of objects are :"+object.count);

	}
}
class object{
	static int count=0;
	object(){
		count++;
	}
}