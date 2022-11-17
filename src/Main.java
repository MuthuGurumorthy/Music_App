import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Album album1 = new Album("album1", "yuvan");
        album1.addSong("Song 1", 7.1);
        album1.addSong("Song 2", 2.5);
        album1.addSong("Song 3", 4.5);
        album1.addSong("Song 4", 4.2);
        album1.addSong("Song 5",2.4);
        album1.addSong("Song 6",23.34);

        LinkedList<song> myPlayList = new LinkedList<>();
        album1.addToPlayList("Song 1", myPlayList);
        album1.addToPlayList("Song 2", myPlayList);
        album1.addToPlayList("Song 3",myPlayList);
        album1.addToPlayList("Song 4",myPlayList);
        album1.addToPlayList("Song 5",myPlayList);
        album1.addToPlayList("Song 6",myPlayList);
        play(myPlayList);
    }
    public static void play(LinkedList<song> playList) {
        ListIterator<song> itr = playList.listIterator();

        Scanner sc=new Scanner(System.in);

        if (!itr.hasNext())
        {
            System.out.println("Playlist is Empty");
            return;
        }
        System.out.println("You are now listening to "+ itr.next().getTitle());

        boolean forward=true;
        showMenu();

        while(true)
        {
            int option =sc.nextInt();

            switch(option)
            {
                case 0:
                    System.out.println("Thank you for listening");
                    return;
                case 1:
                    showMenu();
                    break;
                case 2:
                    printList(playList);
                    break;
                case 3:
                    if(!forward)
                        if (itr.hasNext())
                            itr.next();

                    if(!itr.hasNext())
                        System.out.println("Reached end of playlist");
                    else
                        System.out.println("You are listening to "+itr.next().getTitle());
                    forward=true;
                    break;
                case 4:
                    if(forward)
                        if(itr.hasPrevious())
                            itr.previous();
                    if(!itr.hasPrevious())
                        System.out.println("Reached begining of playlist");
                    else
                        System.out.println("You are listening to "+ itr.previous().getTitle());
                    forward=false;
                    break;
                case 5:
                    if(itr.hasNext())
                    {
                        itr.next();
                        System.out.println("You are listening to "+itr.previous().getTitle());
                    }
                    else
                    {
                        itr.previous();
                        System.out.println("You are listening to "+itr.next().getTitle());
                    }
                    break;
                case 6:
                    if(itr.hasNext())
                    {
                        System.out.println("Successfully deleted teh song "+itr.next().getTitle());
                        itr.previous();
                        itr.remove();
                    }
                    else
                    {
                        System.out.println("Succesfully deleted the song " + itr.previous().getTitle());
                        itr.next();
                        itr.remove();
                    }
                    break;
                default:
                    break;
            }
        }
    }
    public static void printList(LinkedList<song> playList)
    {
        ListIterator<song> itr=playList.listIterator();

        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }

    }
    public static void showMenu()
    {
        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show the list of all songs in playlist");
        System.out.println("3. Play next song");
        System.out.println("4. Play previous song");
        System.out.println("5. Repeat the song");
        System.out.println("6. Delete the song");
    }
}