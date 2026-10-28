package org.example;
public class EBook extends Book{
    private String link;

    public EBook(String title, String author, int publication_year, float price, String link) {
        super(title, author, publication_year, price);
        if (link.trim().length() < 6
                || !link.contains(".")){
            throw new IllegalArgumentException("Це посилання занадто коротке (менше 6 символів) або не містітить '.'");
        } else{
            this.link = link;
        }
    }

    public EBook(EBook ebook) {
        super(ebook);
        this.link = ebook.link;
    }

    public String getLink() {return link;}

    public void setLink(String link){
        if (link.trim().length() < 6
        || !link.contains(".")){
            throw new IllegalArgumentException("Це посилання занадто коротке (менше 6 символів) або не містітить '.'");
        } else{
            this.link = link;
        }
    }

    @Override
    public String toString(){
        return "Назва електронної книги: '" + title +
                "' і вона була написана автором " + author +
                " в " + publication_year +
                " році, " +
                "її посилання: " + link +
                " її ціна " + price + "гривень\n";
    }

    public boolean equals(EBook b){
        return title.equals(b.title) &&
                author.equals(b.author) &&
                publication_year == b.publication_year &&
                Float.compare(price, b.price)==0 &&
                link.equals(b.link);
    }

}
