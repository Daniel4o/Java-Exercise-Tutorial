import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title,  double duration) {
       return this.songs.add(new Song(title,duration));
    }

   public boolean addToPlayList(int trackNum, LinkedList<Song> playlist) {
        Song checkedSong = this.songs.findSong(trackNum);
        if(checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
       System.out.println("This album does not have a track" + trackNum);
        return false;
   }

   public boolean addToPlayList(String title, LinkedList<Song> playlist) {
       Song checkedSong = songs.findSong(title);
       if(checkedSong != null) {
           playlist.add(checkedSong);
           return true;
       }
       return false;
   }

   public static class SongList{
       private ArrayList<Song> songs;

       private SongList()  {
           this.songs = new ArrayList<Song>();
       }

       private boolean add(Song song) {
            if(songs.contains(song)) return false;
            this.songs.add(song);
            return true;
       }
    private Song findSong(String title) {
          for(int i =0; i<songs.size();i++) {
              Song currSong = songs.get(i);
              if(currSong.getTitle() == title) return currSong;
          }
          return null;
    }

       private Song findSong(int trackNum) {
           int index = trackNum -1;
           if((index >= 0) && (index<songs.size())) {
               return songs.get(index);
           }
           return null;
       }
   }
}
