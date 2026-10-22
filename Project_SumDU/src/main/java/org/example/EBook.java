package org.example;
//TODO TODO TODO TODO TODO TODO TODO TODO TODO TODO
public class EBook extends Book{
    private String link;

    public EBook(String title, String author, int publication_year, float price, String link) {
        super(title, author, publication_year, price);
        this.link = link;
    }

    public EBook(EBook ebook) {
        super(ebook);
        this.link = ebook.link;
    }

    public String getLink() {return link;}

    public void setLink(String link){
        this.link = link;
    }

    //TODO TODO TODO TODO TODO TODO TODO TODO TODO TODO
}
