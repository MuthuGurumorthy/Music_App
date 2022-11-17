import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean findSong(String title)
    {
        for (song checkSong: this.songs)
        {
            if(checkSong.getTitle().equals(title))
            {
                System.out.println("Song found!");
                return true;
            }
        }
        return false;
    }

    public boolean addSong(String title,double duration)
    {
        if(findSong(title))
        {
            System.out.println("Song already added");
            return false;
        }
        this.songs.add(new song(title,duration));
        return true;
    }
    public boolean addToPlayList(String title, LinkedList<song> playList)
    {
        for(song checkedSong:this.songs)
        {
            if(checkedSong.getTitle().equals(title))
            {
                playList.add(checkedSong);
                return true;
            }
        }
        return false;
    }
    public boolean addToPlayList(int trackNumber, LinkedList<song> playList)
    {
        int index=trackNumber-1;
        if(index>=0 && index<=this.songs.size()-1)
        {
            playList.add(this.songs.get(index));
            return true;
        }
        return false;
    }
}
