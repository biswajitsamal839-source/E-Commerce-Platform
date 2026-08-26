import java.util.*;
class Product
{
    int productId;
    String productName;
    double productPrice;
    Product(int PID,String name, double price)
    {
        this.productId=PID;
        this.productName=name;
        this.productPrice=price;
    }
}
class Electronics extends Product
{
    int warrenty;
    Electronics(int PID,String name,double p,int Warrenty)
    {
        super(PID,name,p);
        this.warrenty=Warrenty;
    }
    public void displayElectronics()
    {
        System.out.println("-----------------------");
        System.out.println("PRODUCT ID:"+productId);
        System.out.println("PRODUCT NAME:"+productName);
        System.out.println("PRODUCT PRICE:"+productPrice);
        System.out.println("WARRENTY:"+warrenty);
        System.out.println("-----------------------");
    }
}
class Clothing extends Product
{
    int size;
    Clothing(int PID,String name,double p,int Size)
    {
        super(PID,name,p);
        this.size=Size;
    }
    public void displayClothing()
    {
        System.out.println("-----------------------");
        System.out.println("PRODUCT ID:"+productId);
        System.out.println("PRODUCT NAME:"+productName);
        System.out.println("PRODUCT PRICE:"+productPrice);
        System.out.println("SIZE:"+size);
        System.out.println("-----------------------");
    }
}
class Books extends Product
{
    String author;
    Books(int PID,String name,double p,String Author)
    {
        super(PID,name,p);
        this.author=Author;
    }
    public void displayBooks()
    {
        System.out.println("-----------------------");
        System.out.println("PRODUCT ID:"+productId);
        System.out.println("PRODUCT NAME:"+productName);
        System.out.println("PRODUCT PRICE:"+productPrice);
        System.out.println("AUTHOR:"+author);
        System.out.println("-----------------------");
    }
}
class User
{
    int userId;
    String name;
    /*static ArrayList <Electronics> electric1=new ArrayList<>();
    static ArrayList <Clothing> cloths1=new ArrayList<>();
    static ArrayList <Books> books=new ArrayList<>();*/
    User(int UID ,String Name)
    {
        this.userId=UID;
        this.name=Name;
    }
}
class Admin extends User
{
    int adminId;
    Admin(int AUID,String AName, int AID)
    {
        super(AUID,AName);
        this.adminId=AID;
    }
    public void addProduct()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to add electronic product:");
        System.out.println("Enter 2 to add clothing product:");
        System.out.println("Enter 3 to add books products:");
        System.out.println("Enter your choice:");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:
                System.out.println("Enter the product Id");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the product name");
                String n=sc.nextLine();
                System.out.println("Enter the product price:");
                double p=sc.nextDouble();
                System.out.println("Enter the product warrenty");
                int w=sc.nextInt();
                Electronics electric =new Electronics(id,n,p,w);
                E_Commerce.electric1.add(electric);
                break;
            case 2:
                System.out.println("Enter the product Id");
                int id1=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the product name");
                String n1=sc.nextLine();
                System.out.println("Enter the product price:");
                double p1=sc.nextDouble();
                System.out.println("Enter the size:");
                int s=sc.nextInt();
                Clothing cloths=new Clothing(id1,n1,p1,s);
                E_Commerce.cloths1.add(cloths);
                break;
            case 3:
                System.out.println("Enter the product Id");
                int id2=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the product name");
                String n2=sc.nextLine();
                System.out.println("Enter the product price:");
                double p2=sc.nextDouble();
                sc.nextLine();
                System.out.println("Enter the author name:");
                String aname=sc.nextLine();
                Books book=new Books(id2,n2,p2,aname);
                E_Commerce.books.add(book);
                break;
            default:
                System.out.println("INVALID INPUT");
                break;
        }
    }
    public void deleteProduct()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to delete electronic product:");
        System.out.println("Enter 2 to delete clothing product:");
        System.out.println("Enter 3 to delete books products:");
        System.out.println("Enter your choice:");
        int ch=sc.nextInt();
        int a=0;
        switch(ch)
        {
            case 1:
                System.out.println("Enter the product id that is to be removed:");
                int remove=sc.nextInt();
                for(int i=0;i<E_Commerce.electric1.size();i++)
                {
                    Electronics rv=E_Commerce.electric1.get(i);
                    if(remove==rv.productId)
                    {
                        E_Commerce.electric1.remove(i);
                        a=a+1;
                        break;
                    }
                }
                if(a==0)
                {
                    System.out.println("Product Not Found");
                }
        }
    }
    public void displayProd()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to view all electronic product:");
        System.out.println("Enter 2 to view all clothing product:");
        System.out.println("Enter 3 to view all books products:");
        System.out.println("Enter your choice:");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:
                if(E_Commerce.electric1.size()>0)
                {
                    System.out.println("NAME             PRODUCT ID             PRICE");
                    for(int i=0;i<E_Commerce.electric1.size();i++)
                    {
                        Electronics obj=E_Commerce.electric1.get(i);
                        System.out.println(obj.productName+"          "+obj.productId+"            "+obj.productPrice);
                    }
                }
                else
                {
                    System.out.println("NO PRODUCT LISTED");
                }
                break;
            case 2:
                if(E_Commerce.cloths1.size()>0)
                {
                    System.out.println("NAME             PRODUCT ID             PRICE");
                    for(int i=0;i<E_Commerce.cloths1.size();i++)
                    {
                        Clothing obj1=E_Commerce.cloths1.get(i);
                        System.out.println(obj1.productName+"          "+obj1.productId+"            "+obj1.productPrice);
                    }
                }
                else
                {
                    System.out.println("NO PRODUCT LISTED");
                }
                break;
            case 3:
                if(E_Commerce.books.size()>0)
                {
                    System.out.println("NAME             PRODUCT ID             PRICE");
                    for(int i=0;i<E_Commerce.books.size();i++)
                    {
                        Books obj2=E_Commerce.books.get(i);
                        System.out.println(obj2.productName+"          "+obj2.productId+"            "+obj2.productPrice);
                    }
                }
                else
                {
                    System.out.println("NO PRODUCT LISTED");
                }
                break;
            default:
                System.out.println("INVALID INPUT ");
                break;
        }
    }
}
class Customer extends User
{
    int customerId;
    
    Customer(int UID,String name,int CID)
    {
        super(UID,name);
        this.customerId=CID;
    }
    public void displayCustomer()
    {
            System.out.println("------------------------------------");
            System.out.println("NAME:"+name);
            System.out.println("CUSTOMER ID:"+customerId);
            System.out.println("------------------------------------");
    }
}
class Cart
{
    int z=0;
    static ArrayList<Product> cart=new ArrayList<>();
    public void addCart(Product add1)
    {
        cart.add(add1);
    }
    public void displayCart()
    {
        for(int i=0;i<cart.size();i++)
        {
            Product display=cart.get(i);
            System.out.println("------------------------------------");
            System.out.println("PRODUCT ID:"+display.productId);
            System.out.println("PRODUCT NAME:"+display.productName);
            System.out.println("PRODUCT ID:"+display.productPrice);
            System.out.println("------------------------------------");
        }
    }
    public void deleteCart(int d)
    {
        for(int i=0;i<cart.size();i++)
        {
            Product delete1=cart.get(i);
            if(d == delete1.productId)
            {
                cart.remove(i);
                z=z+1;
                break;
            }
        }
        if(z==0)
        {
            System.out.println("Invalid Product Product Not Found");
        }
    }
}
class Order
{
    ArrayList<Product> order=new ArrayList<>();
    public void addOrder(int size,Cart order1)
    {
        for(int j=0;j<size;j++)
        {
            order.add(order1.cart.get(j));
        }
    }
    public void displayOrder()
    {
        double sum=0.0;
        System.out.println("PRODUCT NAME             PRICE");
        System.out.println("-------------           ------");
        for(int k=0;k<order.size();k++)
        {
            Product orders=order.get(k);
            System.out.println(orders.productName+"             "+orders.productPrice);
            sum=sum+orders.productPrice;
        }
        System.out.println("-------------------------------");
        System.out.println("TOTAL AMOUNT:"+sum);
    }
}
public class E_Commerce
{
    public static ArrayList<Admin> admin=new ArrayList<>();
    public static ArrayList<Customer> customer=new ArrayList<>();
    public static ArrayList <Electronics> electric1=new ArrayList<>();
    public static ArrayList <Clothing> cloths1=new ArrayList<>();
    public static ArrayList <Books> books=new ArrayList<>();
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Cart display=new Cart();
        int choice;
        boolean loop;
        loop=true;
        while(loop)
        {
            System.out.println("Enter 1 for add admin:");
            System.out.println("Enter 2 for add customer:");
            System.out.println("Enter 3 for admin login:");
            System.out.println("Enter 4 for customer login:");
            System.out.println("Enter 5 for exit:");
            System.out.println("Enter your choice:");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    {
                        System.out.println("Enter the User ID:");
                        int UID=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the User Name:");
                        String name=sc.nextLine();
                        System.out.println("Enter the Admin ID:");
                        int AID=sc.nextInt();
                        E_Commerce.admin.add(new Admin(UID,name,AID));
                        break;
                    }
                case 2:
                    {
                        System.out.println("Enter the User ID:");
                        int UID=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the Customer Name:");
                        String name=sc.nextLine();
                        System.out.println("Enter the customer ID:");
                        int CID=sc.nextInt();
                        E_Commerce.customer.add(new Customer(UID,name,CID));
                        break;
                    }
                case 3:
                    {
                        System.out.println("Enter the User ID:");
                        int userID=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the Admin Name:");
                        String AName=sc.nextLine();
                        System.out.println("Enter the Admin ID:");
                        int adminID1=sc.nextInt();
                        for(int i=0;i<admin.size();i++)
                        {
                            Admin obj=admin.get(i);
                            if(adminID1==obj.adminId && AName.equals(obj.name) && userID==obj.userId)
                            {
                                boolean loop1;
                                loop1=true;
                                while(loop1)
                                {
                                    System.out.println("Enter 1 to add product:");
                                    System.out.println("Enter 2 to delete product:");
                                    System.out.println("Enter 3 to view customers:");
                                    System.out.println("Enter 4 to view products:");
                                    System.out.println("Enter 5 to exit:");
                                    System.out.println("Enter your choice:");
                                    int c=sc.nextInt();
                                    switch(c)
                                    {
                                        case 1:
                                            Admin ProductAdd=new Admin(userID,AName,adminID1);
                                            ProductAdd.addProduct();
                                            break;
                                        case 2:
                                            Admin ProductDelete=new Admin(userID,AName,adminID1);
                                            ProductDelete.deleteProduct();
                                            break;
                                        case 3:
                                            for(int j=0;j<customer.size();j++)
                                            {
                                                Customer custobj=customer.get(j);
                                                custobj.displayCustomer();
                                            }
                                            break;
                                        case 4:
                                            Admin show=new Admin(userID,AName,adminID1);
                                            show.displayProd();
                                            break;
                                        case 5:
                                            loop1=false;
                                            System.out.println("PLATFORM UPDATED");
                                            break;
                                        default:
                                            System.out.println("INVALID INPUT");
                                            break;
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("ADMIN NOT FOUND INVALID ADMIN");
                            }
                        }
                        break;

                    }
                case 4:
                    {
                        System.out.println("Enter User ID:");
                        int CId=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter the customer name:");
                        String CN=sc.nextLine();
                        System.out.println("Enter the Customer ID:");
                        int Cid=sc.nextInt();
                        Customer customer1 =new Customer(CId,CN,Cid);
                        User objuser=new User(CId,CN);
                        for(int i=0;i<customer.size();i++)
                        {
                            Customer cust=E_Commerce.customer.get(i);
                            if(CId == cust.userId && CN.equals(cust.name) && Cid == cust.customerId)
                            {    
                                Order object=new Order();

                                boolean loop2;
                                loop2=true;
                                while(loop2)
                                {
                                System.out.println("Enter 1 for Electronics");
                                System.out.println("Enter 2 for Clothing");
                                System.out.println("Enter 3 for Books");
                                System.out.println("Enter 4 to view cart");
                                System.out.println("Enter 5 to delete product from cart");
                                System.out.println("Enter 6 to place order");
                                System.out.println("Enter 7 for view placed orders and order details");
                                System.out.println("Enter 8 to exit");
                                System.out.println("Enter your choice:");
                                int choiceC=sc.nextInt();
                                switch(choiceC)
                                {
                                    case 1:
                                        System.out.println("=====CATLOGUE=====");
                                        for(int k=0;k<E_Commerce.electric1.size();k++)
                                        {
                                            Electronics print=E_Commerce.electric1.get(k);
                                            print.displayElectronics();
                                        }
                                        System.out.println("Enter 1 if you want to add anything to cart:");
                                        System.out.println("Enter 2 if you don't want to add anything to cart:");
                                        int n=sc.nextInt();
                                        if(n==1)
                                        {
                                            System.out.println("Enter the product ID that is to be added:");
                                            int idadd=sc.nextInt();
                                            for(int l=0;i<E_Commerce.electric1.size();i++)
                                            {
                                                Electronics add1=E_Commerce.electric1.get(l);
                                                if(idadd == add1.productId)
                                                {
                                                    //Cart add2=new Cart();
                                                    display.addCart(add1);
                                                    System.out.println("Product Added Successfully");
                                                }
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Exit Successful from Electronics Catlogue");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("=====CATLOGUE=====");
                                        for(int k=0;k<E_Commerce.cloths1.size();k++)
                                        {
                                            Clothing print=E_Commerce.cloths1.get(k);
                                            print.displayClothing();
                                        }
                                        System.out.println("Enter 1 if you want to add anything to cart:");
                                        System.out.println("Enter 2 if you don't want to add anything to cart:");
                                        int n1=sc.nextInt();
                                        if(n1==1)
                                        {
                                            System.out.println("Enter the product ID that is to be added:");
                                            int idadd=sc.nextInt();
                                            for(int l=0;i<E_Commerce.cloths1.size();i++)
                                            {
                                                Clothing add1=E_Commerce.cloths1.get(l);
                                                if(idadd == add1.productId)
                                                {
                                                    //Cart add2=new Cart();
                                                    display.addCart(add1);
                                                    System.out.println("Product Added Successfully");
                                                }
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Exit Successful from Electronics Catlogue");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("=====CATLOGUE=====");
                                        for(int k=0;k<E_Commerce.books.size();k++)
                                        {
                                            Books print=E_Commerce.books.get(k);
                                            print.displayBooks();
                                        }
                                        System.out.println("Enter 1 if you want to add anything to cart:");
                                        System.out.println("Enter 2 if you don't want to add anything to cart:");
                                        int n2=sc.nextInt();
                                        if(n2==1)
                                        {
                                            System.out.println("Enter the product ID that is to be added:");
                                            int idadd=sc.nextInt();
                                            for(int l=0;i<E_Commerce.books.size();i++)
                                            {
                                                Books add1=E_Commerce.books.get(l);
                                                if(idadd == add1.productId)
                                                {
                                                    //Cart add2=new Cart();
                                                    display.addCart(add1);
                                                    System.out.println("Product Added Successfully");
                                                }
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Exit Successful from Electronics Catlogue");
                                        }
                                        break;
                                    case 4:
                                        System.out.println("=====YOUR CART=====");
                                        display.displayCart();
                                        break;
                                    case 5:
                                        System.out.println("Enter the product ID that is to be deleted :");
                                        int del=sc.nextInt();
                                        display.deleteCart(del);
                                        break;
                                    case 6:
                                        //Order object=new Order();
                                        object.addOrder(display.cart.size(),display);
                                        display.cart.clear();
                                        break;
                                    case 7:
                                        int OID=100001;
                                        //Order print=new Order();

                                        System.out.println("ORDER ID:"+OID);
                                        System.out.println("-----------------------------");
                                        object.displayOrder();
                                        OID++;
                                        break;
                                    case 8:
                                        loop=false;
                                        System.out.println("THANK YOU VISIT AGAIN");
                                        break;
                                    default:
                                        System.out.println("INVALID INPUT");
                                        break;
                                }
                            }
                        }
                    }
                    break;
                }
                default:
                    {
                        System.out.println("INVALID INPUT");
                        break;
                    }
            }
        }
    }
}
