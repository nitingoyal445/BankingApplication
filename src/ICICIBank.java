import java.util.LinkedList;

public class ICICIBank {

	LinkedList<Account> accountlist=new LinkedList<>();
	
	public String createAccount(int accountNumber,int amount) throws InsufficientOpeningBalanceException,InsufficientBalanceException,InvalidAccountNumberException {
		
		Account account=new Account(accountNumber,amount);
		if(amount>=500) {
		accountlist.add(account);
		
		return "Account created Successfully";
		}
		throw new InsufficientOpeningBalanceException();
		
	}
	private Account searchAccount(int accountNumber) throws InvalidAccountNumberException,InsufficientOpeningBalanceException,InsufficientBalanceException{
		for(Account account:accountlist) {
			if(account.getAccountNumber()==accountNumber) {
				return account;
			}
		}
		
		throw new InvalidAccountNumberException();
	}
	
	public int withdrawAmount(int accountNumber,int amount) throws InsufficientBalanceException,InvalidAccountNumberException,InsufficientOpeningBalanceException {
		
		Account account=searchAccount(accountNumber);
		
		if((account.getAmount()-amount)>=0) {
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		throw new InsufficientBalanceException();
	}
	
	public String fundTransfer(int senderAccountNumber,int recieverAccountNumber,int amount) throws InsufficientBalanceException,InvalidAccountNumberException, InsufficientOpeningBalanceException {
		Account account=searchAccount(senderAccountNumber);
		Account account1=searchAccount(recieverAccountNumber);
		
		if((account.getAmount()-amount)>=0) {
			account.setAmount(account.getAmount()-amount);
			account1.setAmount(account1.getAmount()+amount);
			return "amount after updation is "+senderAccountNumber+" = " + account.getAmount()+"," + recieverAccountNumber + " = " + account1.getAmount() ;
		}
		throw new InsufficientBalanceException();	
	}
	public int depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException,InsufficientOpeningBalanceException,InsufficientBalanceException{
		Account account=searchAccount(accountNumber);
		
		account.setAmount(account.getAmount()+amount);
		return account.getAmount();
		
	}
	
}
