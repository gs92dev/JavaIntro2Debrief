package com.example.bankaccount;

public class BankAccount {

    /*
        RULES:
        1. No direct souts in our methods, only returns
        2. Do not allow for negative balances!

        Requirements:
            Instance fields(data type):
                balance(double)
                nameOnAccount(String)
                accountNumber(int)
                accountType(String)

            Class methods(return types):
                withdraw(boolean)
                deposit(boolean)
                constructor
                getters(field type)
                toString(String)
     */

    /*
        Instance field declarations should go here
        balance(double), nameOnAccount(String), accountNumber(int), accountType(String)
        These fields should not be able to be manipulated or access outside this class!*/

    private String nameOnAccount;
    private double balance;

    private int accountNumber;
    private String accountType;

    /*
        Constructor method should go here
        remember to take proper input for each instance field
        then, assign that input to the appropriate field
     */
    public BankAccount(String name, double balance, int number, String atype){
        nameOnAccount = name;
        this.balance = balance;
        accountNumber = number;
        accountType = atype;
    }

    /*
        All your getter methods can go below
        The return type for your getter methods depends on which instance field you are getting!
     */
    //Getters
    public String getName(){
        return nameOnAccount;
    }
    public double getBalance(){
        return balance;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public String getAccountType(){
        return accountType;
    }
    //setters
    public void setNameOnAccount(String nameOnAccount) {
        this.nameOnAccount = nameOnAccount;
    }

    public void setBalance(double balance) {
        this.balance = this.balance + balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    /*
        Here you should write your withdraw method
        requirements:
            1. no negatives as input
            2. depending on accountType:
                calculate transaction fee of $1.50 (checking only)
            3. check balance, do not allow for overdrafting
            4. update balance
            5. return true if successful
                otherwise, return false
     */
    public boolean withdraw(double value){
        double ischecking = this.accountType.equalsIgnoreCase("checking")?value+1.50:value ;
        if (value < 0 || ischecking > this.balance  ){
            return false;
        }
        if (ischecking == value) {
            this.balance = this.balance-value;
        }else {this.balance = this.balance - ischecking;
        }
        System.out.println("Your balance now is: " + balance);
        return true;


    }



    /*
        Here you should write your deposit method
        requirements:
            1. no negatives as input
            3. update balance
            2. return true if successful
                otherwise, return false
     */
    public boolean deposit(double amout){
        if(amout<0){
            return false;
        }
        this.balance = this.balance+amout;
        return true;
    }

    /*
        Here you should write you toString method
        requirements:
            1. returns a String that represents all your instance field values
     */

    public String toString() {
        return "This account is owned by: " + getName() +" it is a "+ getAccountType() + " the account number is: "+ getAccountNumber() + " and the balance is " + getBalance();
    }



}
