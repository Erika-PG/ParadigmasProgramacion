package Project_Books;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamIntroduction {
    public static void main(String[] args) {
        List<Book> books= new ArrayList<>();
        books.add(new Book("The alchemist", "Paulo Coelho", "Adventure", 4.4));
        books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.1));
        books.add(new Book("Horror Coktail", "Robert Bloch", "Horror", 2.6));
        books.add(new Book("House of Leaves", "Mark Danielewski", "Horror", 4.0));
        System.out.println();

        //How do you print the list
        books.forEach(System.out::println);

        // Mostrar los libros que sean de genero romance y cuyo rating sea mayor a 3.
        // El resultado se guarda en la lista

        List<Book> popularRomanticBooks = books.stream()
                .filter(book-> book.getGenre().equalsIgnoreCase("Romance"))
                .filter(book -> book.getRating() > 3)
                .collect(Collectors.toList());
        // Lista de libros de romance y con rating mayor a 3
        System.out.println();
        popularRomanticBooks.forEach(book->System.out.println(book));

        //Exercise: mostrar los libros de horror cuyo rating sea menor a 3.
        // guardar en una lista y mostrarla
        List<Book> popularHorrorBooks = books.stream()
                .filter(book-> book.getGenre().equalsIgnoreCase("Horror"))
                .filter(book -> book.getRating() < 3)
                .collect(Collectors.toList());
        // Lista de libros de horror y con rating mayor a 3
        System.out.println();
        popularHorrorBooks.forEach(book->System.out.println(book));

        // mostrar los libros que sean del autor "Paulo Coelho"
        List<Book> PauloCoelhoBooks = books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase("Paulo Coelho"))
                .collect(Collectors.toList());
        System.out.println();
        PauloCoelhoBooks.forEach(book -> System.out.println(book));
        
    }
}
