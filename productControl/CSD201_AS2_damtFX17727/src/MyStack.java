import java.io.BufferedReader;
import java.io.FileReader;

public class MyStack<T> {
    public  int counter;
    public  Mylist<T> data;
    public MyStack(){
        this.counter =0;
        this.data = new Mylist<>();
    }
    public  boolean isEmpty(){
        return (counter ==0);
    }
    public  int size(){
        return  this.counter;
    }
    public void push(T x){
        this.counter++;
        this.data.insertAtHead((Product) x);

    }
    public Node peek(){
        if(isEmpty()){
            return  null;
        }else {
            return  this.data.head;
        }
    }
    public Node pop(){
        if(isEmpty()){
            return  null;
        }else {
            counter--;
            Node  node = this.data.head;
            this.data.deleteFromHead();
            return node;
        }
    }
    public  void display(){
        System.out.println(this.pop().getProduct().toString());
    }

    public MyStack<T> readFromFileToStack(String fileName,MyStack<T> stack) {
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
                int quantity = Integer.parseInt(txt[2]);
                double price = Double.parseDouble(txt[3]);
                Product newProduct = new Product(bcode,title,quantity,price);
                System.out.println(newProduct);
                stack.push((T) newProduct);
            }
            System.out.println("hien thi stack");
            while (!stack.isEmpty()){
               stack.display();
            }


        }catch (Exception e){
            System.out.println("Error");
            System.out.println(e);
        }
        return stack;
    }

}
