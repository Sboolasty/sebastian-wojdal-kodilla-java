package com.example.kodillagoodpatterns2.adapter.bookclassifier;



import com.example.kodillagoodpatterns2.adapter.bookclassifier.librarya.Book;
import com.example.kodillagoodpatterns2.adapter.bookclassifier.librarya.Classifier;
import com.example.kodillagoodpatterns2.adapter.bookclassifier.libraryb.BookSignature;
import com.example.kodillagoodpatterns2.adapter.bookclassifier.libraryb.Statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends Statistics implements Classifier {

    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.example.kodillagoodpatterns2.adapter.bookclassifier.libraryb.Book> books = new HashMap<>();
        for (Book book : bookSet) {
            BookSignature signature = new BookSignature(book.getSignature());
            com.example.kodillagoodpatterns2.adapter.bookclassifier.libraryb.Book libraryBBook =
                    new com.example.kodillagoodpatterns2.adapter.bookclassifier.libraryb.Book(
                            book.getAuthor(), book.getTitle(), book.getPublicationYear());
            books.put(signature, libraryBBook);
        }
        return medianPublicationYear(books);
    }
}