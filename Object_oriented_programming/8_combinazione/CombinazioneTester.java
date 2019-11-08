public class CombinazioneTester{

	public CombinazioneTester(){
		a= new Combinazione();
	}

	public boolean getState(){
		return a.isOpen();
	}

	public void unlockAttempt(){
		System.out.println("you're trying to open:");
		String word= a.inSet();
		a.unlock(word);
	}

	public void locking(){
		a.lock();
	}

	public void changeLock(){
		a.newComb();
	}

	private Combinazione a;
	
	public static void main(String args[]){

		CombinazioneTester b= new CombinazioneTester();
		System.out.println();
		System.out.println();

		int count= 1;
		while(count  <  4){
			b.unlockAttempt();
			if( b.getState() ){
				System.out.println("it's open");
				break;			
			}
			else{
                if(count  ==  3)
                    break;
				System.out.println("try again");
            count++;
            }
		}

		if(count  ==  3  &&  !b.getState())
			System.out.println("you can not access anymore");
		else
			System.out.println("you gotta inside");
    }
}
