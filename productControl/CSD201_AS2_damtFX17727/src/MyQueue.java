import java.io.BufferedReader;
import java.io.FileReader;

public class MyQueue<T> {
    public  int counter;
    public Mylist<T> data;
    public MyQueue(){
        this.counter =0;
        this.data = new Mylist<>();
    }
    public boolean isEmpty(){
        return  (counter==0);
    }
    public  int size(){
        return this.counter;
    }
    public void enQueue(T x){
        this.counter++;
        this.data.insertAtTAil((Product) x);
    }
    public  void showQueue(){
        this.data.display();
    }
    public MyQueue<T> readFromFileToQueue(String fileName, MyQueue<T> queue) {
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
                queue.enQueue((T) newProduct);
            }
            System.out.println("hien thi queue");
            queue.showQueue();


        }catch (Exception e){
            System.out.println("Error");
            System.out.println(e);
        }
        return queue;
    }
}
