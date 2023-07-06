package com.example.kodillagoodpatterns2.adapter.company;

import com.example.kodillagoodpatterns2.adapter.bookclassifier.MedianAdapter;
import com.example.kodillagoodpatterns2.adapter.bookclassifier.librarya.Book;
import com.example.kodillagoodpatterns2.adapter.bookclassifier.librarya.Classifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        // Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Author 1", "Title 1", 2000, "A1T1"));
        bookSet.add(new Book("Author 2", "Title 2", 1995, "A2T2"));
        bookSet.add(new Book("Author 3", "Title 3", 2010, "A3T3"));
        bookSet.add(new Book("Author 4", "Title 4", 1990, "A4T4"));
        bookSet.add(new Book("Author 5", "Title 5", 2020, "A5T5"));

        Classifier adapter = new MedianAdapter();

        // When
        int medianYear = adapter.publicationYearMedian(bookSet);

        // Then
        Assertions.assertEquals(2000, medianYear);
    }
}