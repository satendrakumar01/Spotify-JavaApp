import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Album {

    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

//    public boolean findSong(Song song) {
//        for (Song s : songs) {
//            if (s.equals(song)) {
//                return true;
//            }
//
//            return false;
//        }
public boolean findSong(String title) {

    for (Song s : songs) {
        if (s.getTitle().equals(title)) {
            return true;
        }



    }
    return false;

}


    void addSongtoAlbum(String title, double duration) {
        Song s = new Song(title, duration);
        if (findSong(s.getTitle()) == true) {
            System.out.println("song already exist in album");
        } else {
            songs.add(s);
            System.out.println("new has been added");
        }
        return;

    }
    public  void  addToPlaylistFromAlbum(String title, LinkedList<Song>playList){


        if(findSong(title)==true){
            for(Song s:songs){
                if(s.getTitle().equals(title))
                {
                playList.add(s);
            System.out.println("Song Added Successfully in Playlist");
                break;

                }
            }
        }
        else {
            System.out.println("Song is not present in album");
        }



    }
    public void addToPlaylistFromAlbum(int trackNo, LinkedList<Song> playList){

        int index=trackNo-1;
        if(index>=0 && index<songs.size()){
            playList.add(songs.get(index));
        }
        else {
            System.out.println("Invalid track number");
        }

    }


}

