package org.example;
//TODO TODO TODO TODO TODO TODO TODO TODO TODO TODO
public class PaperBook extends Book{
    private int numOfPages;

    public PaperBook(String title, String author, int publication_year, float price, int numOfPages) {
        super(title, author, publication_year, price);
        if (numOfPages < 0){
            throw new IllegalArgumentException("Кількість сторінок має бути невід'ємною");
        } else{
            this.numOfPages = numOfPages;
        }
    }

    public PaperBook(PaperBook paperBook) {
        super(paperBook);
        if (numOfPages < 0){
            throw new IllegalArgumentException("Кількість сторінок має бути невід'ємною");
        } else{
            this.numOfPages = paperBook.numOfPages;
        }
    }

    public int getNumOfPages() {return numOfPages;}

    public void setNumOfPages(int numOfPages){
        if (numOfPages < 0){
            throw new IllegalArgumentException("Кількість сторінок має бути невід'ємною");
        } else{
            this.numOfPages = numOfPages;
        }
    }
    //TODO TODO TODO TODO TODO TODO TODO TODO TODO TODO
}
