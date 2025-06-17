package com.khdour;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    // @Test
    // public void shouldAnswerWithTrue()
    // {
    //     assertTrue( true );
    // }

    @Test
    public void searchBookwithIBN1211()
    {  
        // setup
        BookStore store = new BookStore();
        Book book1211 = new Book("1211", "hello", "khdour", 20);
        store.addBook(book1211);
        //exercise
        Book searched = store.searchByISBN("1211");
        //verify
        assertEquals( book1211,searched );
        //tear down
      //  store.deleteByISBN("1211");
    }
}
