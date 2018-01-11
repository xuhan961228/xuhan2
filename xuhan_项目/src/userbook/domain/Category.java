package userbook.domain;

public class Category {
    private String cname;
    private int cid;

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "cname='" + cname + '\'' +
                ", cid=" + cid +
                '}';
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

}
