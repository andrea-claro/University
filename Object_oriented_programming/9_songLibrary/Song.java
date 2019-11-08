import java.util.Scanner;
public class Song{
	public Song(){
		this.title= null;
		this.artist= null;
	}
	
	public Song(String songName, String artistName){
		this.title= songName;
		this.title= artistName;
	}

	public String getArtist(){
		return this.artist;
	}

	public String getTitle(){
		return this.title;
	}

	public static Song read(Scanner in)throws Exception{
		if(!in.hasNext())
			return null;

		String songName= in.next();
		String artistName= in.next();

		return new Song(songName, artistName);
	}

	private String title, artist;
}
