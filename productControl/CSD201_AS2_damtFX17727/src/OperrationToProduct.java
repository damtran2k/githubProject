import java.util.Queue;
import java.util.Scanner;

public class OperrationToProduct {

    public Mylist<Product> readFile(String fileName,Mylist<Product> list){
        return  list.readFromFile(fileName,list,true);
    }
    public void inputProduct(Product newProduct,Mylist<Product> list, Scanner sc){
        // nhập thông tin sản phẩm và thêm vào cuối danh sách
        System.out.println("Bcode: ");
        //sc.nextLine();
        String bcode = sc.nextLine();
        newProduct.setbCode(bcode);
        System.out.println("Title: ");
        String title = sc.nextLine();
        newProduct.setTitle(title);
        System.out.println("Quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());
        newProduct.setQuantity(quantity);
        System.out.println(" Price ");
        double price = Double.parseDouble(sc.nextLine());
        newProduct.setPrice(price);
        // thêm sản phẩm vào đuôi danh sách liên kết
        list.insertAtTAil(newProduct);
    }
    public  void addLast(Product newProduct,Mylist<Product> list){
        list.insertAtTAil(newProduct);
    }

    public void searchById(String id,Mylist<Product> list){
        if (list.search(id) != null){
            System.out.println(list.search(id).getProduct());
        }else {
            System.out.println(-1);
        }
    }
    public  void removeProductByid(String id,Mylist<Product> list){
        list.removeNode(id);
    }
    public void sortById(Mylist<Product> list){
        list.sortById();
        list.display();
    }
    public void changeToBinary(Mylist mylist){
        //  số lượng sản phẩm của  phần tử đầu  tiên trong Link List
        int x = mylist.head.getProduct().getQuantity();
        System.out.println("so luong san pham dau tien cua linked list theo he nhi phan la");
        System.out.println(mylist.convertToBinary(x));
    }
    public void loadToStack(String fileName,MyStack stack){
        stack.readFromFileToStack(fileName,stack);
    }
    public void loadToQueue(String fileName, MyQueue queue){
        queue.readFromFileToQueue(fileName,queue);
    }
}
