import java.util.Arrays;

public class Hallow_pyramid 
{
		public static void main(String[] args)
	{
	int a[]={5,4,3,10,14,6};
	int b[]=new int[a.length];
	for(int i=a.length-1;i>=0;i--){
		b[a.length-i-1]=a[i];
	}
	for(int i=a.length-1;i>=0;i--){
		System.out.print(b[a.length-i-1]);
	}


}
}
