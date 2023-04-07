import java.util.Arrays;
import java.util.Scanner;
public class S200315015 {
	public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	System.out.println("Enter number:");
	int num = sc.nextInt();
	String[][] customers = createCustomer(num);
	
	int []customerState = createCustomerState(num);
	
	displayCustomer(customerState ,num);
	
	long [] Balance  = customerBalance( num );
	
	 customerDues( Balance ,customerState,  num);
	 
	 String[] fameleMale =trueFalse( customers, num);
	
	
	 

}

	
	public static String [] [] createCustomer( int num) {
	Scanner sc = new Scanner (System.in);
	
	
	String [][] result = new String [num][2];
	for(int i = 0 ; i<num;i++) {
		System.out.println("Please,Enter the name and surname for "+ (i+1) +". customer :");
		result[i][0]= sc.nextLine().toUpperCase().trim();
		for(int j = 1;j<2;j++) {
			System.out.println("Please ,Enter the gender for "+ (i+1) +". customer :(F or M)");
			result[i][j] = sc.nextLine().toUpperCase().trim();
		}
	}
    System.out.println("NAME"+"\t"+"\t"+"GENDER");
	for(int i =0 ;i<result.length;i++) {
		int c = result[i][0].lastIndexOf(" ");
		System.out.println(result[i][0].substring(0,2)+"***" +"\t" +result[i][0].substring(c+1,c+3)+"***" +"\t" +result[i][1]  );
	}
	return result;

}
	
	public static int[] createCustomerState(int num ) {
	System.out.println("--- Customer State---");
	Scanner sc = new Scanner(System.in);
	int [] result =new int[num];
	
	
	
	for(int i =0 ;i<num;i++) {
		System.out.println("1- Student");
		System.out.println("2- Retired");
		System.out.println("3- Employed");
		System.out.println("4- Unemployed");
		result[i]=sc.nextInt();
		
		
		
			
		}
	return result;
	}
	
	
	public static void displayCustomer(int []customerState ,int num) {
		System.out.println();
		for(int i=0 ; i<num;i++) {
			if(customerState[i]==1) {
				System.out.println("Student");
			}
			else if(customerState[i]==2) {
				System.out.println("Retired");
			}
			else if( customerState[i]==3) {
				System.out.println("Employed");
			}else if(customerState[i]==4) {
				System.out.println("Unemployed");
				
			}
		}
	}
	

	public static long[] customerBalance( int num ) {
		System.out.println("--- Customer Balance---");
	Scanner sc = new Scanner(System.in);
	long [] result = new long[num];
	
	int i =0;
	long avr = 0;
	for( i =0 ; i<num;i++) {
		result[i]= (int)((10000)+Math.random()*90001);
		System.out.println((i+1)+ " .customer's money: "+ result[i]);
		avr+=result[i];

	}
	long average = (avr/result.length);
	System.out.println("Average Money =" + average);
	System.out.println("How many  years Do you want to apply?  :");
	int year = sc.nextInt();
	for(int j =0 ; j<num;j++) {
		if(result[j]>average) {
			
			result[j]= result[j]+ ((result[j]*2)/100)*year;
			System.out.println((result[j]) + "  interest for  " + (j+1) +".costumer.");
		}
		else if(result[j]< average) {
			System.out.println();

		}
		

	}
	return result;

}
	
	
	public static void customerDues(long [] Balance ,int []customerState , int num) {
		System.out.println("--- New Balance ---");
	
	int i=0;
	for( i = 0; i<num;i++) {
		if(customerState[i] == 1) {
			System.out.println("There is not dues for " + (i+1)  + " .customer ");
		}
		else if( customerState[i]== 2) {
			System.out.println("There is not dues for"  + (i+1)  + " .customer ");
		}
		else if( customerState[i]==3) {
			System.out.println("We must apply to dues !!");
		 	Balance[i]= Balance[i] - ((Balance[i]/100)*1);
		 	System.out.println("New Balance for" +  (i+1)  +  "  . customers =  " + Balance[i]);
		}
		else if(customerState[i]==4) {
			System.out.println("We must apply to dues !!");
			Balance[i] = Balance[i]- ((Balance[i]/100)*1);
			System.out.println("New Balance for "+  (i+1)  +  "  . customers =  " + Balance[i]);
		}
		
	}
			
	
}
	
	
	public static String[] trueFalse(String[][] customers,int num) {
		System.out.println("--- Number Of Gender ---");
	String[] result= new String[num];
	int woman=0;
	int man =0;
	for(int i = 0 ; i<num;i++) {
		if(customers[i][1].charAt(0)=='F') {
			result[i]="F";
			woman++;
		}
		else if(customers[i][1].charAt(0)=='M') {
			result[i]="M";
			man++;
			
		}
		else {
			
			System.out.println("Please,Enter the correct character for your gender !!! TRY AGAİN....");
			
		}
	}
	System.out.println("Number of man :"+ man);
	
	System.out.println("Number of woman :"+ woman);
	return result;
	
	
}


	

}
