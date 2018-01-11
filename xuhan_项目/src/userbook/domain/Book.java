package userbook.domain;

public class Book {
private String bid;
private String bname;
private String price;
private String author;
private String image;
private String cid;
private int count;
private String time;
private int oid;

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", cid='" + cid + '\'' +
                ", count=" + count +
                ", time='" + time + '\'' +
                ", did='" + oid + '\'' +
                '}';
    }

    public Book() {
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }
}
