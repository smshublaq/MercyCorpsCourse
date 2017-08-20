package com.app.xmlparsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iSaleem on 8/20/17.
 */

public class MySAXParser extends DefaultHandler{

    List<Book> books;
    Book book;
    String value;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("catalog")){
            books = new ArrayList<>();
        }
        else if (qName.equals("book")){
            book = new Book();
            String id = attributes.getValue("id");
            book.setId(id);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = new String(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("author")){
            book.setAuthor(value);
        }
        else if(qName.equals("genre")){
            book.setGenre(value);
        }
        else if(qName.equals("price")){
            book.setPrice(Double.parseDouble(value));
        }
        else if(qName.equals("title")){
            book.setTitle(value);
        }
        else if(qName.equals("book")){
            books.add(book);
        }
    }

    public List<Book> getBooks(){
        return books;
    }
}
