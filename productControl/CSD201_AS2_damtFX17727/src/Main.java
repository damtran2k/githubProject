import java.util.Scanner;

public class Main {
    public  static  final String  PRODUCTFILE = "data.txt";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OperrationToProduct p = new OperrationToProduct();
        Product newProduct = new Product();
        Mylist<Product> list = new Mylist<>();
        int n = 0;

        do {
            boolean isContinue = true;
            // hàm hiển thị danh sách Menu
            showMenu();
            do {
                // Bắt lỗi khi người dùng nhập sai kiểu dữ liệu
                // và yêu cầu nhập lại
                try{
                    System.out.println("Please input");
                    n = Integer.parseInt(sc.nextLine());
                    isContinue = false;
                }catch (Exception e){
                    System.out.println("Type input is Wrong");
                }
            }while (isContinue);

            switch (n){
                case 1:
                    // đọc dữ liệu từ file và in ra màn hình
                    System.out.println("Function 1: Load data from file and display");
                    p.readFile(PRODUCTFILE,list);
                    break;
                case 2:
                    // Thêm sản phẩm vào cuối danh sách
                    System.out.println("Function 2: Input & add to the end");
                    p.inputProduct(newProduct,list,sc);
                    System.out.println("Add to success");
                    list.display();
                    break;
                case 3:
                    System.out.println("Function 3: Display data");
                    list.display();
                    break;
                case 4:
                    System.out.println("Function 4:Save product list to file");
                    if(list.isEmpty()){
                        System.out.println("list is empty");
                    }else {
                        list.writeToFile(PRODUCTFILE);
                        System.out.println("Save to success");
                    }
                    break;
                case 5:
                    System.out.println("Function 5");
                    String id ="";
                    if(list.isEmpty()){
                        System.out.println("list is empty");
                    }else {
                        System.out.println("Search by ID");
                        id = sc.nextLine();
                        p.searchById(id, list);
                    }
                    break;
                case 6:
                    System.out.println("Function 6: Delete by ID");
                    String data ="";
                    if(list.isEmpty()){
                        System.out.println("list is empty");
                    }else {
                        //sc.nextLine();
                        System.out.println("Input delete ID");
                        data = sc.nextLine();
                        p.removeProductByid(data,list);
                        System.out.println("Deleted Link list");
                        list.display();
                    }
                    break;
                case 7:
                    System.out.println("Function 7.Sort by ID");
                    p.sortById(list);
                    break;
                case 8:
                    System.out.println("Function 8. Convert to Binary");
                    p.changeToBinary(list);
                    break;
                case 9:
                    MyStack<Product> myStack = new MyStack<Product>();
                    p.loadToStack(PRODUCTFILE,myStack);
                    break;
                case 10:
                    MyQueue<Product> myQueue = new MyQueue<Product>();
                    p.loadToQueue(PRODUCTFILE,myQueue);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Your choice incorrect");
                    break;
            }
        }while (n!=0);

    }
    public static  void showMenu(){
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7.Sort by ID.");
        System.out.println("8. Convert to Binary ");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
    }



}