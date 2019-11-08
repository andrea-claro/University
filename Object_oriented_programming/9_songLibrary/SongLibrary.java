import java.util.Scanner;
import java.io.*;
public class SongLibrary{
	public SongLibrary(){
		this.songFileName= null;
	}

	public SongLibrary(String songFileName){
		this.songFileName= songFileName;
	}

	public void lookUp(String artist)throws Exception{
		Scanner in= new Scanner(new File(songFileName));
		
		Song song= Song.read(in);

		while(song  !=  null){
			if(artist.equals(song.getArtist()))
				System.out.println(song.getTitle());
			song= Song.read(in);
		}
	}

	private String songFileName;
}
