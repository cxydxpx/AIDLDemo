// BookManager.aidl
package com.example.apen.remoteaidl;
import com.example.apen.remoteaidl.Book;
// Declare any non-default types here with import statements

interface BookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
   List<Book> getBooks();

    void addBook(in Book book);
//
//     void setBookPrice(in Book book , int price);
//     void setBookName(in Book book , String name);
//     void addBookIn(in Book book);
//     void addBookOut(out Book book);
//     void addBookInout(inout Book book);
}
