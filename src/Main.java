import java.util.*;

public class Main {



    public static List<Album> album=new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Welcome to music App");



        Album a1=new Album("Mossa","Siddhu Moosewala");
        a1.addSongtoAlbum("295",4.56);
        a1.addSongtoAlbum("Yaar Bathere",5.55);
        a1.addSongtoAlbum("LastRide",4.58);
        Album a2=new Album("Honey 3.0","YO YO Honey Singh");
        a2.addSongtoAlbum("First Kiss",3.5);
        a2.addSongtoAlbum("Jingle Jingle",6.6);
        a1.addSongtoAlbum("Mi Amor",4);

        album.add(a1);
        album.add(a2);

        System.out.println(a1.findSong("gerua"));

        LinkedList<Song> myPlaylist=new LinkedList<>();


        a1.addToPlaylistFromAlbum("295",myPlaylist);//ture
        a2.addToPlaylistFromAlbum("First Kiss",myPlaylist);//false
        a1.addToPlaylistFromAlbum(2,myPlaylist);//ture
        a2.addToPlaylistFromAlbum("Mi Amor",myPlaylist);
        a2.addToPlaylistFromAlbum("Jingle Jingle",myPlaylist);


        Song sample=new Song("Channa Merraya",5);
        System.out.println(sample);

        play(myPlaylist);




    }
    public  static  void printMenu(){
        System.out.println("Select your Choice ");
        System.out.println("1-play next song ");
        System.out.println("2-play previous song");
        System.out.println("3-Repeat the song");
        System.out.println("4-Show menu Again");
        System.out.println("5-Delete the current song");
        System.out.println("6-print all the songs  in playlst");
        System.out.println("7-Exist");
    }
    public static void play(LinkedList<Song>playList){

        ListIterator<Song> itr=playList.listIterator();
        Scanner sc=new Scanner(System.in);

        boolean isForward=false;
        if(playList.size()>0){
            System.out.println("Your are currently: ");
            System.out.println(itr.next());
            isForward=true;

        }else {
            System.out.println("Playlist is empty");
            return;
        }
        System.out.println("Enter your choice: ");

        printMenu();
        boolean quit=false;
        while (!quit){
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    if(isForward==false){
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    else {
                        System.out.println("you are the end of the playList");
                        isForward=false;
                    }
                    break;
                case 2:
                    if(isForward==true){
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());

                    }
                    else {
                        System.out.println("you are the start of the playList");
                        isForward=true;
                    }
                    break;
                case 3:
                    if(isForward==true){
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isForward=false;

                        }
                    }
                    else{
                        if(itr.hasNext()) {


                            System.out.println(itr.next());
                            isForward=true;
                        }

                    }

                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit=true;
                    break;


            }
        }

    }

    private static void printSongs(LinkedList<Song> playList) {


        for (Song s: playList){
            System.out.println(s);

        }
    }

}