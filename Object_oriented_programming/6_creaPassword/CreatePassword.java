public class CreatePassword{
	
	public CreatePassword(){
		password= null;
	}

	public CreatePassword(String name, String surname, int birthDate){
		password= (name.substring(0, 2)  +  birthDate  +  surname.substring(0, 2)  +  birthDate);
	}

	public String getPassword(){
		return password;
	}

	private String password;
}
