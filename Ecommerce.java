import java.util.*;
class User
{
    int userId;
    String name;
    String email;
    int password;
    User(int id,String Uname,String Uemail,int Upassword)
    {
        this.userId=id;
        this.name=Uname;
        this.email=Uemail;
        this.password=Upassword;
    }
    public void displayUser()
    {
        System.out.println("USER ID:"+userId);
        System.out.println("USER NAME:"+name);
        System.out.println("USER EMAIL:"+email);
        System.out.println("USER PASSWORD:"+password);
    }
}
class Customer extends User
{
    int customerId;
    Customer(int CUID, String CNAME, String CEMAIL, int CPASS, int CID)
    {
        super(CUID,CNAME,CEMAIL,CPASS);
        this.customerId=CID;
    }
    public void displayCustomer()
    {
        System.out.println("CUSTOMER ID="+customerId);
    }
}
class Admin extends User
{
    int AdminId;
    Admin(int AUID, String ANAME, String AEMAIL, int APASS, int AID)
    {
        super(AUID,ANAME,AEMAIL,APASS);
        this.AdminId=AID;
    }
    public void displayAdmin()
    {
        System.out.println("ADMIN ID="+AdminId);
    }
}
class Product
{
    int productId;
    String name;
    int price;
    int quantity;
    Product(int ProductId,String PName,int Price, int Quantity)
    {
        this.productId=ProductId;
        this.name=PName;
        this.price=Price;
        this.quantity=Quantity;
    }
    public void displayProduct()
    {
        System.out.println("PRODUCT ID:"+productId);
        System.out.println("PRODUCT NAME:"+name);
        System.out.println("PRODUCT PRICE:"+price);
        System.out.println("PRODUCT QUANTITY:"+quantity);
    }
}
class Electronics extends Product
{
    int warranty;
    Electronics(int EID,String ENAME,int EPRICE,int EQUANTITY, int EWARRANTY)
    {
        super(EID,ENAME,EPRICE,EQUANTITY);
        this.warranty=EWARRANTY;
    }
    public void displayElectronics()
    {
        System.out.println("WARRANTY:"+warranty);
    }
}
class Clothing extends Product
{
    String size;
    Clothing(int CID, String CNAME, int CPRICE,int CQUANTITY, String CSIZE)
    {
        super(CID,CNAME,CPRICE,CQUANTITY);
        this.size=CSIZE;
    }
    public void displayClothing()
    {
        System.out.println("SIZE:"+size);
    }
}
class Book extends Product
{
    String author;
    Book(int BID,String BNAME,int BPRICE,int BQUANTITY,String BAUTHOR)
    {
        super(BID,BNAME,BPRICE,BQUANTITY);
        this.author=BAUTHOR;
    }
    public void displayBook()
    {
        System.out.println("AUTHOR:"+author);
    }
}
class Cart
{
    Product products[]= new Product[10];
    int count;
    Cart()
    {
        count=0;
    }
    public void addProduct(Product product )
    {
        if(count < products.length)
        {
            products[count]=product;
            count++;
            System.out.println("PRODUCT ADDED SUCCESSFULLY");
        }
        else
        {
            System.out.println("CART FULL");
        }
    }
    public void displayCart()
    {
        System.out.println("=====YOUR PRODUCTS=====");
        for(int i=0;i<count;i++)
        {
            System.out.println("--------------------------------");
            products[i].displayProduct();
            System.out.println("--------------------------------");
        }
    }
    public void removeProduct()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the product index to remove:");
        int a=sc.nextInt();
        if(a>0 && a<count)
        {
            for(int i=a;i<count-1;i++)
            {
                products[i]=products[i+1];
            }
            count--;
        }
        else
        {
            System.out.println("NO PRODUCT LISTED AT THIS INDEX IN YOUR CART");
        }
    }
}
class Order
{
    int orderId;
    Product order[]=new Product[10];
    int total=0;
    int count=0;
    Order(int OID)
    {
        this.orderId=OID;
    }
    public void addProduct(Cart carts)
    {
        for(int i=0;i<carts.count;i++)
        {
            order[count]=carts.products[i];
            count++;
        }
    }
    public void displayOrder()
    {
        System.out.println("======YOUR ORDER======");
        System.out.println("==========================");
        System.out.println("Order ID:"+orderId);
        System.out.println("Product            Price");
        for(int i=0;i<count;i++)
        {
            System.out.println(order[i].name+"            "+order[i].price);
        }
        System.out.println("TOTAL:            "+calculateTotal());
    }
    double calculateTotal()
    {
       for(int i=0;i<count;i++)
       {
          total=total+order[i].price;
       }
       return total;
    } 
}
public class Ecommerce
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int choice;

        boolean loop;
        loop=true;
        int a=1001;
        Cart cartproducts=new Cart();
        Order addorder=new Order(a);
        while(loop)
        { 
          System.out.println("1. ELECTRONICS");
          System.out.println("2. CLOTHING");
          System.out.println("3. BOOKS");
          System.out.println("4. VIEW CART");
          System.out.println("5. DELETE PRODUCT FROM CART");
          System.out.println("6. PLACE ORDER");
          System.out.println("7. VIEW ORDER");
          System.out.println("8. EXIT");
          System.out.println("Enter your catogory choice:");
          int ch=sc.nextInt();
          switch(ch)
          { 
            case 1:
                {

                  Electronics electric[]=new Electronics[5];
                  electric[0]=new Electronics(101,"Laptop",50000,5,5);
                  electric[1]=new Electronics(102,"Headphone",1500,5,3);
                  electric[2]=new Electronics(103,"Microphone",50000,5,5);
                  electric[3]=new Electronics(104,"Phone",25000,5,3);
                  electric[4]=new Electronics(105,"Charger",1000,5,1);
                  for(int i=0;i<5;i++)
                   {
                       System.out.println("-----------------------------");
                       electric[i].displayProduct();
                       electric[i].displayElectronics();
                       System.out.println("-----------------------------");
                   }
                   System.out.println("Enter 1 if you want to add anything to cart:");
                    System.out.println("Enter 2 if you don't want to add anything to cart and exit from here :");
                    int n=sc.nextInt();
                    if(n==1)
                    {
                          System.out.println("Enter the product id to add to the cart:");
                          choice=sc.nextInt();
                          for(int j=0;j<5;j++)
                          {
                              if(choice == electric[j].productId)
                              {
                              cartproducts.addProduct(electric[j]);
                              }
                          }
                    } 
                    else
                    {
                        System.out.println("EXIT FROM ELECTRONICS ");
                    }
                    break;     
                }
             case 2:
                {
                    Clothing cloths[]=new Clothing[5];
                    cloths[0]=new Clothing(201,"Shirt",500,5,"M");
                    cloths[1]=new Clothing(202,"T-Shirt",600,5,"S");
                    cloths[2]=new Clothing(203,"Jeans",1200,5,"L");
                    cloths[3]=new Clothing(204,"Trousers",1000,5,"XL");
                    cloths[4]=new Clothing(205,"Shoes",2000,5,"8");
                    for(int i=0;i<5;i++)
                    {
                        System.out.println("---------------------------------- ");
                        cloths[i].displayProduct();
                        cloths[i].displayClothing();
                        System.out.println("---------------------------------- ");
                    }
                    System.out.println("Enter 1 if you want to add to cart: ");
                    System.out.println("Enter 2 if you dont want to add to cart and exit from here: ");
                    int m=sc.nextInt();
                    if(m==1)
                    {
                        System.out.println("Enter the product ID: ");
                        int choice1=sc.nextInt();
                        for(int j=0;j<5;j++)
                        {
                            if(choice1 == cloths[j].productId)
                            {
                                cartproducts.addProduct(cloths[j]);
                            }
                        }
                    }
                    else
                    {
                        System.out.println("EXIT FROM CLOTHING CATEGORY ");
                    }
                    break;
                }
             case 3:
                {
                    Book books[]=new Book[10];
                    books[0]=new Book(301,"Python",400,5,"Herbert Schildt");
                    books[1]=new Book(302,"Java",500,5,"AI Sweigart");
                    books[2]=new Book(303,"CSS",350,5,"John Duckett");
                    books[3]=new Book(304,"HTML",450,5,"John Duckett");
                    books[4]=new Book(305,"Java Script",550,5,"Douglas Crockford");
                    for(int i=0;i<5;i++)
                    {
                        System.out.println("---------------------------------- ");
                        books[i].displayProduct();
                        books[i].displayBook();
                        System.out.println("---------------------------------- ");
                    }
                    System.out.println("Enter 1 if you want to add items to the cart: ");
                    System.out.println("Enter 2 if you don't want to add items to the cart: ");
                    int ch2=sc.nextInt();
                    if(ch2==1)
                    {
                        System.out.println("Enter the product ID that is to be added: ");
                        int f=sc.nextInt();
                        for(int j=0;j<5;j++)
                        {
                            if(f == books[j].productId)
                            {
                                cartproducts.addProduct(books[j]);
                            }
                        }
                    }
                    else
                    {
                        System.out.println("EXIT FROM BOOKS CATEGORY");
                    }
                    break;
                }
             case 4:
                {;
                    cartproducts.displayCart();
                    break;
                }
             case 5:
                {
                    cartproducts.removeProduct();
                    break;
                }
             case 6:
                {
                    addorder.addProduct(cartproducts);
                    a++;
                    System.out.println("Order Placed SUccessfully");
                    break;
                }
             case 7:
                {
                    addorder.displayOrder();
                    a++;
                    break;
                }
             case 8:
                {
                    loop=false;
                    System.out.println("THANK YOU VISIT AGAIN");
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