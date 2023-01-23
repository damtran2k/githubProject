import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Stack;

public class Mylist<T> {
    Node<T> head,tail;
    public Mylist(){
        this.head = this.tail = null;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public Mylist(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;

    }

    // kiểm tra danh sách có rỗng hay không
    public  boolean isEmpty(){
        return  this.head == null;
    }
    // thêm sản phẩm vào cuối danh sách
    public void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.product.toString());
            temp = temp.next;
        }
    }
    public  int length(){
        // hàm chiều dài link list
        int length =0;
        Node current = this.head;
        while (current!= null){
            length++;
            current = current.next;
        }
        return length;
    }
    public  void deleteFromHead(){
        //   hàm xóa ở đầu
        this.head = this.head.next;
    }
    public  void deleteFromTail(){
        //  hàm xóa ở đuôi
        if (isEmpty()){
            System.out.println("list  Empty");
        }else {
            Node node = null;
            node.next = null;
            this.tail = node;
        }
    }
    public void insertAtHead(Product product){
        // hàm thêm ở đầu
        Node newNode = new Node<>(product);
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }
    public void insertAtTAil(Product product){
        // hàm thêm ở đuôi
        Node newNode = new Node<>(product);
        // kiểm tra List có rỗng hay không
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
            return;
        }else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }
    public Mylist<T> readFromFile(String fileName,Mylist<T> list,boolean addLast) {
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true){
                line = br.readLine();
                if (line == null){
                    break;
                }
                String[] txt =line.split(";");
                String bcode = txt[0];
                String title = txt[1];
                //System.out.println(bcode);
                int quantity = Integer.parseInt(txt[2]);
                double price = Double.parseDouble(txt[3]);
                // thêm giá trị đọc được vào sản phẩm
                Product newProduct = new Product(bcode,title,quantity,price);
                System.out.println(newProduct);
                if (addLast){
                    list.insertAtTAil(newProduct);
                }else {
                    list.insertAtHead(newProduct);
                }
            }

        }catch (Exception e){
            System.out.println("Error");
            System.out.println(e);
        }
        return list;
    }
    public void writeToFile(String fileName){
        try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            // dùng vòng for để quét qua tất cả các node;
            for( var node = head;node != null;node=node.getNext()){
                bw.write(String.valueOf(node.getProduct()));
                bw.newLine();
            }
            bw.close();
            fw.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public Node<T> search(String data){
        for (var node = head; node != null;node = node.getNext()){
            if (node.getProduct().getbCode().equals(data)){
                return node;
           }
        }
        System.out.println("Can not find");
        return  null;
    }
    public  boolean removeNode(String data){
        // hàm xóa Node ( product)
        Node<T> currentNode = head;
        Node<T> prevNode = null;
        boolean isContinue = false;
        if (isEmpty()){
            System.out.println("list is empty");
            return  false;
        }else {
            while (currentNode!= null){
                // kiểm tra id xóa có tồn tại hay không
                if(currentNode.getProduct().getbCode().equals(data)){
                    isContinue =true;
                    break;
                }
                prevNode =currentNode;
                currentNode =currentNode.next;

            }
            // xét tiến hàng so sánh để tìm được vị trí cần xóa
            // và triển khai phương thức phù hợp
            while (isContinue){
                if(currentNode == head){
                    head = currentNode.next;
                    currentNode.next = null;
                    return  true;
                } else if (currentNode == tail) {
                    prevNode.next = null;
                   // prevNode.setNext(null);
                    this.tail = prevNode;
                    return  true;
                }else {
                    prevNode.next =currentNode.next;
                    currentNode.next = null;
                    return  true;
                }
            }
            System.out.println("Id is not linkList");
            return  false;
            }
        }
    public  void sortById(){
        if(isEmpty()){
            System.out.println("Empty linked list");
            return;
        }else {
            int n = this.length();
            for(int i = 0;i<n;i++){
                Node currentNode = this.head;
                Node nextNode = head.next;
                for (int j = 0;j< n-1;j++){
                    String currentId = currentNode.getProduct().getbCode();
                    String nextId = nextNode.getProduct().getbCode();
                    // Nếu id currentNode và nextNode không được sắp xếp tăng dần  theo từ điển thì đổi vị trí
                    if(currentId.compareTo(nextId) > 0){
                        Product temp = currentNode.getProduct();
                        currentNode.setProduct(nextNode.getProduct());
                        nextNode.setProduct(temp);
                    }
                    currentNode = nextNode;
                    nextNode = nextNode.next;
                }
            }

            }
        }
    public String convertToBinary(int x){
        int a;
        if(x>0){
            a =x%2;
            // dùng hàm đệ qui để gọi lại phương thức chia lấy số dư
            return (convertToBinary(x/2) + a);
        }
        return "";
    }
}
