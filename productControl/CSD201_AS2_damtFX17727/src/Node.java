public class Node<T> {
    Product product;
    Node next;

    public Node(T product) {
        this.product = (Product) product;
        this.next = null;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
