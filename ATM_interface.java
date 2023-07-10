/*Name: M.Sandeep 

Internship name: OASIS INFOBYTE

Domain: JAVA DEVELOPMENT

Task-1 : Online Reservation System

Task-2 : Number Guessing Game

Task-3 : ATM Interface
*/
import java.util.*;
class Transaction{
    public void display( String s){
        System.out.println("-------------------------------------------");
        System.out.println("             TRANSACTIONS                  ");
        System.out.println("-------------------------------------------");
        System.out.println(s);
        System.out.println("-------------------------------------------");
        System.out.println("              THANK YOU                    ");
        System.out.println("-------------------------------------------");
    }
}
class Withdraw{
    public double with(double bal,double amount){
        if(bal>=amount){
            System.out.println(amount+" DEBITED FROM YOUR ACCOUNT");
            bal=bal-amount;
        }else{
            System.out.println("INSUFFICIENT BALANCE");
        }
        return bal;
    }
}
class Deposit{
    public double dep(double bal,double amount){
        System.out.println(amount +" CREDITED TO YOUR ACCOUNT");
        return amount;
    }
}
class transfer{
    public double trans(double bal,double amount,String acc){
        if(bal>=amount){
            System.out.println(amount+" HAS BEEN TRANSFERRED TO "+acc);
            bal=bal-amount;
        }else{
            System.out.println("INSUFFICIENT BALANCE ");
        }
        return bal;
    }
}
class quit{
    public boolean qt(){
        return false;
    }
}
class ATMInterface {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String name,Username,password,acc_no,tranHistory;
        tranHistory="";
        double bal=0;
        System.out.println("-------------------------------------------");
        System.out.println("      WELCOME TO ATM SERVICES                  ");
        System.out.println("-------------------------------------------");
        System.out.println("ENTER YOUR DETAILS CORRECTLY TO REGISTER");
        System.out.print("ENTER YOUR NAME:");
        name=sc.nextLine();
        System.out.print("CREATE A USER NAME:");
        Username=sc.nextLine();
        System.out.print("CREATE A PASSWORD:");
        password=sc.nextLine();
        System.out.print("ENTER ACCOUNT NUMBER:");
        acc_no=sc.nextLine();
        System.out.println("---------------------------");
        System.out.println("REGISTERED SUCCESSFULLY");
        System.out.println("---------------------------");
        Transaction tr=new Transaction();
        Withdraw w=new Withdraw();
        Deposit d=new Deposit();
        quit q=new quit();
        transfer t=new transfer();
        boolean f=true;
        while(f){
            String s;
            System.out.print("ENTER USERNAME:");
            s=sc.nextLine();
            if(Username.equals(s)){
                f=false;
            }else{
                System.out.println("ENTER VALID USERNAME!!!");
            }
        }
        f=true;
        while(f){
            String s;
            System.out.print("ENTER PASSWORD:");
            s=sc.nextLine();
            if(password.equals(s)){
                f=false;
            }else{
                System.out.println("INCORRECT PASSWORD!!!");
            }
        }
        System.out.println("--------------------------------");
        System.out.println("LOGGED IN SUCCESSFULLY");
        System.out.println("--------------------------------");
        f=true;
        while(f){
            System.out.println("ENTER YOUR CHOICE\n1.TRANSACTION HISTORY\n2.WITHDRAW\n3.DEPOSIT\n4.TRANSFER\n5.QUIT");
            int i=sc.nextInt();
            double amount;
            String st;
            String sr="";
            switch(i){
                case 1:
                    tr.display(tranHistory);
                    break;
                case 2:
                    System.out.print("ENTER AMOUNT TO WITHDRAW:");
                    amount=sc.nextDouble();
                    if(bal>=amount){
                        sr=amount+" has been withdrawn and available balance is "+(bal-amount)+"\n";
                    }else{
                        sr=amount+" transaction has been declined due to insufficient balance\n";
                    }
                    bal=w.with(bal,amount);

                    tranHistory=tranHistory.concat(sr);
                    break;
                case 3:
                    System.out.print("ENTER AMOUNT TO DEPOSIT:");
                    amount=sc.nextDouble();
                    bal=d.dep(bal,amount);
                    sr=amount+" has been deposited and available balance is "+bal+"\n";
                    tranHistory=tranHistory.concat(sr);
                    break;
                case 4:
                    System.out.println("ENTER ACCOUNT NUMBER TO TRANSFER:");
                    st=sc.next();
                    System.out.println("ENTER AMOUNT TO TRANSFER");
                    amount=sc.nextDouble();
                    bal=t.trans(bal,amount,st);
                    sr=amount+" is transferred and available balance is "+bal+"\n";
                    tranHistory=tranHistory.concat(sr);
                    break;
                case 5:
                    f=q.qt();
                    break;
                default:
                    System.out.println("ENTER VALID OPTION");
                    break;
            }
        }
        System.out.println("-------------------------------------------");
        System.out.println("       THANK YOU FOR USING ATM SERVICES      ");
        System.out.println("-------------------------------------------");
    }
}