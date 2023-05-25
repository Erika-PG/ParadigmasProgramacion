package Project_Books;

public class Book {
    private String name;
    private String author;
    private String genre;
    private double rating;


 public Book(String name, String author, String genre, double rating){
     this.name= name;
     this.author= author;
     this.genre= genre;
     this.rating= rating;
 }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}
