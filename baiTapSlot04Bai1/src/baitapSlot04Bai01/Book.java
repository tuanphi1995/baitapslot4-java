package baitapSlot04Bai01;

public class Book {
    private String title;
    private String author;
    private double price;
    private String publishDate;
    private String status;

    public Book(String title, String author, double price, String publishDate, String status) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishDate = publishDate;
        this.status = status;
    }

    // Getters và Setters cho từng thuộc tính
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", price=" + price +
               ", publishDate='" + publishDate + '\'' +
               ", status='" + status + '\'' +
               '}';
    }
}

