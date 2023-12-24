package ATM_INTERFACE;
import java.util.Scanner;

class ATM
{
	float Balance1;
	float Balance2;
	
	int entrPIN;
	
	int PIN1=1234; //Rohit
	int PIN2=5678; //Shantanu
	
	
	Scanner sc=new Scanner(System.in);
	
	public void checkPin()
	{
		System.out.println("Please Enter your PIN");
		  entrPIN=sc.nextInt();
		
		if(PIN2==entrPIN)
		{
			System.out.println("--->How Can I help You Shantanu<---");
			menu();
		}
		
		else if(PIN1==entrPIN)
		{
			System.out.println("--->How Can I help You Rohit<---");
			menu();
		}
		else 
		{
			System.out.println("Your PIN is Invalid ");
			int Attempt=3;
			System.out.println("you Have 3 Attempt");
			while(Attempt>0)
			{
				System.out.println("Please Enter your valid PIN");
				entrPIN=sc.nextInt();
				 Attempt--;
				 if(entrPIN==PIN1||entrPIN==PIN2)
					{
					 System.out.println("your PIN Is valid");
						menu();
					    break;	
					}
				 else
				 {
					 
					if(Attempt==0)
					{
						System.out.println("Your Card is Block For 24 Hours");
						System.out.println("Place try After 24 Hours");
						break;
					}
					else 
					{
						 System.out.println("You Have only "+Attempt+" Attempt");
						
					}
				 }
			}

		}
		
	}
	
	public void menu()
	{
		
		
//		System.out.println("-->Enter your Choice<--");
		System.out.println("1. Check A/C Balance");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Deposit Money");
		System.out.println("4. Exit");
		
		Scanner sc=new Scanner(System.in);
		int opt=sc.nextInt();
		
		switch(opt)
		{
		case 1:
			CheckBalance();
			break;
			
		case 2:
			WithdrawMony();
			break;
			
		case 3:
			DepositeMoney();
			break;
			
		case 4:
			System.out.println("Thank You ");
		    break;
			
			
		default:
			System.out.println("Enter a Valid Choice");
			menu();
			break;
		}
		
	}
	
	
	public void CheckBalance()
	{
		float a=(PIN1==entrPIN) ? Balance1 : Balance2;
		System.out.println("Balance :"+ a );
		menu();
	}
	
	public void WithdrawMony()
	{
		
		System.out.println("Enter Amount to Withdraw :");
		
		
		float amount=sc.nextFloat();
		
		
			if((PIN1==entrPIN)&&(Balance1>=amount))
			{
				Balance1 = Balance1 - amount;
				
				System.out.println("Money Withdrawl Successful");
				
			}
			else if((PIN2==entrPIN)&&(Balance2>=amount))
			{
				Balance2 = Balance2 - amount;
				
				System.out.println("Money Withdrawl Successful");
			}
			else
			{
				System.out.println("Insufficient Balance");
			}
				
		
		                

		
		menu();
		
	}
	
	public void DepositeMoney()
	{
		System.out.println("How Much Money You Want to Deposit ? ");
		System.out.print("Please Enter the Amount: ");
		
		float amount = sc.nextFloat();
		
		
		if(PIN1==entrPIN)
		{
			 Balance1=Balance1 + amount;
		}
		else if(PIN2==entrPIN)
		{
			Balance2=Balance2 + amount;
		}
		
		
		
		System.out.println("Your Money Deposit Successful");
		System.out.println("Thank You");
		
		menu();
		
		
	}
	
}

public class ATMmachine
{
	public static void main(String []args)
	{
		ATM obj=new ATM();
		obj.checkPin();
		
	}
}

