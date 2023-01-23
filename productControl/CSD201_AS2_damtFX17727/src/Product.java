public class Product implements  Comparable<Product>{
    private String bCode;
    private String title;
    private int quantity;
    private  double price;

    public Product() {
    }

    public Product(String bCode, String title, int quantity, double price) {
        this.bCode = bCode;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
    public String getbCode() {
        return bCode;
    }

    public void setbCode(String bCode) {
        this.bCode = bCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return bCode + ";" + title +";" +quantity + ";" + price;
    }

    @Override
    public int compareTo(Product o) {
        return this.getbCode().compareTo(o.getbCode());
    }
}
