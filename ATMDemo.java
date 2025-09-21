import java.util.Scanner;
class ATM{
     private BankAccount account;
     private Scanner sc;
     public ATM(BankAccount account){
          this.account=account;
           this.sc=new Scanner(System.in);
     }
     public void start(){
          int choice;
          do{
               System.out.println("\n--- ATM Menu---");
               System.out.println("1.Check Balance:");
               System.out.println("2.Deposit");
               System.out.println("3.Withdrawl");
               System.out.println("4.Exit");
               System.out.print("Enter your choice: ");
               choice=sc.nextInt();
               switch(choice){
                    case 1:
                         checkBalance();
                         break;
                    case 2:
                         deposit();
                         break;
                    case 3:
                         withdraw();
                         break;
                    case 4:
                         System.out.println("Thank You for using ATM.Goodbye!");
                         break;
                    default:
                         System.out.println("Invalid choice! Please try again:");
               }
          }while(choice!=4);
     }
          private void checkBalance(){
               System.out.println("Your current balance is: $"+account.getBalance());
          }
          private void deposit(){
               System.out.println("Enter amount for deposit: ");
               double amount=sc.nextDouble();
               account.deposit(amount);
          }
          private void withdraw(){
               System.out.println("Enter amount for withdrawl: ");
               double amount=sc.nextDouble();
               account.withdraw(amount);
          }
     }
class BankAccount{
     private String accountNumber;
     private double balance;
     public BankAccount(String accountNumber,double balance){
          this.accountNumber=accountNumber;
          if(balance>0){
               this.balance=balance;
          }
          else{
               System.out.println("initial balance must be pos");
          }
     }
     public String getAccountNumber(){
          return accountNumber;
     }
     public double getBalance(){
          return balance;
     }
     public void deposit(double amount){
          if(amount>0){
               balance+=amount;
               System.out.println("deposited: "+amount+"$");
          }
          else{
               System.out.println("deposit amount must be pos");
          }
     }
     public void withdraw(double amount){
          if(amount>0 && amount<=balance){
               balance-=amount;
               System.out.println("withdrawl: "+amount+"$");
          }
          else{
               System.out.println("invalid withdrawl");
          }
     }
}

public class ATMDemo{
     public static void main(String[]args){
          BankAccount account=new BankAccount("1234567890",1000);
          ATM atm=new ATM(account);
          atm.start();
     }
}
