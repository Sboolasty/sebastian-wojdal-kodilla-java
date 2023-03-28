package com.example.kodillapatterns.prototype;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //given
        Library library = new Library("Biblioteka Główna");

        Book book1 = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", LocalDate.of(2010, 1, 1));
        Book book2 = new Book("Krzyżacy", "Henryk Sienkiewicz", LocalDate.of(2011, 1, 1));
        Book book3 = new Book("Zemsta", "Aleksander Fredro", LocalDate.of(2012, 1, 1));
        Book book4 = new Book("Lalka", "Bolesław Prus", LocalDate.of(2013, 1, 1));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Biblioteka Główna 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }


        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Biblioteka Główna 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //when
        library.getBooks().remove(book2);
        //then
        assertEquals(3, library.getBooks().size());
        assertEquals(3, clonedLibrary.getBooks().size());
        assertEquals(4, deepClonedLibrary.getBooks().size());
        assertEquals(library.getBooks(), clonedLibrary.getBooks());
        assertNotEquals(library.getBooks(), deepClonedLibrary.getBooks());
    }
}