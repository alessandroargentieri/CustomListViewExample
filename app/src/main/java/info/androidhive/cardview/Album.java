package info.androidhive.cardview;

public class Album {
    private String name;
    private int numOfSongs;
    //private int thumbnail;
    private String link;

    public Album() {
    }

    public Album(String name, int numOfSongs, String link){//int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
      //  this.thumbnail = thumbnail;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


   // public int getThumbnail() {
   //     return thumbnail;
   // }

   // public void setThumbnail(int thumbnail) {
     //   this.thumbnail = thumbnail;
    //}
}
