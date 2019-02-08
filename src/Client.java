
public class Client {

	public static void main(String[] args) {
		ICICIBank bank=new ICICIBank();
		try {
			System.out.println(bank.createAccount(203, 5000));
			System.out.println(bank.createAccount(204,3000));
			System.out.println(bank.depositAmount(203, 2000));
			System.out.println(bank.fundTransfer(203,204,1000));
			
		}
		catch(InvalidAccountNumberException an) {
			System.out.println("Invalid Account Number");
		}
		catch(InsufficientBalanceException ib) {
			System.out.println("Insufficient Balance");
		}
		catch(InsufficientOpeningBalanceException iob) {
			System.out.println("Minimum opening amount is 500");
		}

	}

}
