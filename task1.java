import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class ATM{
private double balance;
private double depositAmount;
private double withdrawAmount;

public ATM(){
}
public double getBalance(){
return balance;
}
public void setBalance(double balance){
this.balance = balance;
}
public double getDepositAmount(){
return depositAmount;
}
public void setDepositAmount(double depositAmount){
this.depositAmount = depositAmount;
}
public double getWithdrawAmount(){
return withdrawAmount;
}
public void setWithdrawAmount(double withdrawAmount){
this.withdrawAmount =  withdrawAmount;
}
}


interface AtmOperationInterf{
public void viewBalance();
public void withdrawAmount(double withdrawAmount);
public void depositAmount(double depositAmount);
public void viewMiniStatement();
}


class AtmOperationImpl implements AtmOperationInterf{
ATM aa=new ATM();
Map<Double,String> ministmt=new HashMap<>();
public void viewBalance(){
System.out.println("\nAvailable Balance is : "+aa.getBalance());
}
public void withdrawAmount(double withdrawAmount){
if(withdrawAmount <= aa.getBalance()){
ministmt.put(withdrawAmount," Amount Withdrawn");
System.out.println("\nCollect the Cash "+withdrawAmount);
aa.setBalance(aa.getBalance()-withdrawAmount);
viewBalance();
}
else{
System.out.println("\nInsufficient Balance !!");
}
}
public void depositAmount(double depositAmount){
System.out.println("\n");
ministmt.put(depositAmount," Amount Deposited");
System.out.println(depositAmount+" Deposited Successfully !!");
aa.setBalance(aa.getBalance()+depositAmount); 
viewBalance();
}
public void viewMiniStatement(){
for(Map.Entry<Double,String> m:ministmt.entrySet()){
System.out.println(m.getKey()+""+m.getValue());
}
}

}


class mainatm{
public static void main(String []args){

AtmOperationInterf op=new AtmOperationImpl();

int atmnumber=12345;
int atmpin=123;
Scanner sc=new Scanner(System.in);
System.out.println("\nWelcome to ATM Machine !!");
System.out.print("\nEntr your ATM number :");
int atmNumber=sc.nextInt();
System.out.print("Enter ATM Pin Number :");
int pin=sc.nextInt();


if((atmnumber == atmNumber)&&(atmpin == pin)){
while(true){
System.out.print("\n1.View Availabel Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Mini Statement\n5.Exit");
System.out.println("\n");
System.out.println("\nEnter Choice :");
int ch=sc.nextInt();
if(ch==1){
op.viewBalance();
}
else if(ch==2){
System.out.println("\nEnter amount to withdraw :");
double withdrawAmount=sc.nextDouble();
op.withdrawAmount(withdrawAmount); 
}
else if(ch==3){
System.out.println("Enter Amount to Deposit :");
double depositAmount=sc.nextDouble();
op.depositAmount(depositAmount);
}
else if(ch==4){
op.viewMiniStatement();
}
else if(ch==5){
System.out.println("\nCollect your ATM Card\nThank You for using ATM Machine !!");
break;
}
else{
System.out.println("Please enter correct choice");
}
}
}
else{
System.out.print("incorrect atm number or pin");
}
}
}