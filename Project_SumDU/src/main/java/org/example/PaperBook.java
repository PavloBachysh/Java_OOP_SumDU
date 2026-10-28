package org.example;
//TODO TODO TODO TODO TODO TODO TODO TODO TODO TODO
public class PaperBook extends Book{
    private int num_of_pages;

    public PaperBook(String title, String author, int publication_year, float price, int num_of_pages) {
        super(title, author, publication_year, price);
        if (num_of_pages < 0){
            throw new IllegalArgumentException("Кількість сторінок має бути невід'ємною");
        } else{
            this.num_of_pages = num_of_pages;
        }
    }

    public PaperBook(PaperBook paperBook) {
        super(paperBook);
        if (num_of_pages < 0){
            throw new IllegalArgumentException("Кількість сторінок має бути невід'ємною");
        } else{
            this.num_of_pages = paperBook.num_of_pages;
        }
    }

    public int getNum_of_pages() {return num_of_pages;}

    public void setNum_of_pages(int num_of_pages){
        if (num_of_pages < 0){
            throw new IllegalArgumentException("Кількість сторінок має бути невід'ємною");
        } else{
            this.num_of_pages = num_of_pages;
        }
    }

    @Override
    public String toString(){
        return "Назва паперової книги: '" + title +
                "' і вона була написана автором " + author +
                " в " + publication_year +
                " році, " +
                "має " + num_of_pages + " сторінок, " +
                "її ціна " + price + "гривень\n";
    }

    public boolean equals(PaperBook b){
        return title.equals(b.title) &&
                author.equals(b.author) &&
                publication_year == b.publication_year &&
                Float.compare(price, b.price)==0 &&
                num_of_pages == b.num_of_pages;
    }
    //TODO TODO TODO TODO TODO TODO TODO TODO TODO TODO
}
