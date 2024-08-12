package org.example.main;

import org.example.cart.Cart;
import org.example.dataBase.DataBase;
import org.example.product.Product;
import org.example.user.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public  static Scanner sc =new Scanner(System.in);
    public static boolean notLoggedIn=true;
    public static void main(String[] args) {

        while (notLoggedIn){
            System.out.println("1.register\n2.login");
            System.out.println("enter your choice");
            int choice=sc.nextInt();
            switch (choice){
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
            }
            if(!notLoggedIn){
                if(!DataBase.users.get(DataBase.loggedInUserId).getrole().equals("customer")){
                    while (!notLoggedIn){
                        System.out.println("1.addProduct\n2.show\n3.logout\n4.deleteProduct");
                         choice =sc.nextInt();
                        switch (choice){
                            case 1:
                                addproduct();
                                break;
                            case 2:
                                showMyProducts();
                                break;
                            case 3:
                                logout();
                                break;
                            case 4:
                                deleteProduct();
                                break;
                            case 5:
                                updateProduct();
                                break;
                        }
                    }
                }else {

                    while (!notLoggedIn){
                        System.out.println("1.view Products\n2.add to cart \n3.buy\n4.logout\n5.show history");
                        System.out.println("enter your choice:");
                         choice =sc.nextInt();
                        switch (choice){
                            case 1:
                                showProducts();
                                break;
                            case 2:
                                addToCart();
                                break;
                            case 3:
                                buyProduct();
                                break;
                            case 4:
                                logout();
                                break;

                            case 5:
                                showHistory();
                                break;
                            case 6:
                                viewCart();
                                break;
                        }
                    }
                }
            }
        }
        //System.out.println(DataBase.loggedInUserId);



    }

    private static void viewCart() {
        if(DataBase.cart.containsKey(DataBase.loggedInUserId)) {
            for (Cart cart : DataBase.cart.get(DataBase.loggedInUserId)) {
                System.out.println(cart.toString());
            }
        }
        else {
            System.out.println("you have no products in cart");
        }
    }

    private static void showHistory() {
        if( DataBase.history.containsKey(DataBase.loggedInUserId)) {
            for (Cart cart : DataBase.history.get(DataBase.loggedInUserId)) {
                System.out.println(cart.toString());
            }
        }
        else {
            System.out.println("you have no history");
        }
    }

    private static void buyProduct() {
        if(DataBase.cart.containsKey(DataBase.loggedInUserId)) {
            ArrayList<Cart> al=DataBase.history.getOrDefault(DataBase.loggedInUserId,new ArrayList<Cart>());
            for(Cart cart:DataBase.cart.get(DataBase.loggedInUserId)){
                al.add(cart);
                //DataBase.history.getOrDefault(DataBase.loggedInUserId,new ArrayList<>()).add(cart);
                Product product=DataBase.products.get(cart.getProductId());
                product.setQuantity(product.getQuantity()- cart.getQuantity());
            }
            DataBase.history.put(DataBase.loggedInUserId,al);
            DataBase.cart.remove(DataBase.loggedInUserId);
            System.out.println("buy successfully");

        }
        else {
            System.out.println("cart is empty");
        }
    }

    private static void addToCart() {
        System.out.println("enter your product id:");
        int pid =sc.nextInt();
        System.out.println("enter quantity:");
        int quantity=sc.nextInt();
        if(DataBase.products.containsKey(pid) && DataBase.products.get(pid).getQuantity()>=quantity){
            Product product=DataBase.products.get(pid);
            Cart cart=new Cart(pid,DataBase.loggedInUserId,quantity,product.getPrice()*quantity);
            ArrayList<Cart> al=DataBase.cart.getOrDefault(DataBase.loggedInUserId,new ArrayList<Cart>());
            al.add(cart);
            DataBase.cart.put(DataBase.loggedInUserId,al);

        } else if (!DataBase.products.containsKey(pid)) {
            System.out.println("product not found");
        }
        else{
            System.out.println("not sufficient quantity, quantity available:"+DataBase.products.get(pid).getQuantity());
        }

    }


    private static void updateProduct() {
        System.out.println("enter product id to update:");
        int id=sc.nextInt();
        if(DataBase.products.containsKey(id) && DataBase.products.get(id).getSellerId()==DataBase.loggedInUserId){
            System.out.println("enter product name");
            String name=sc.next();
            System.out.println("enter price");
            long price=sc.nextLong();
            System.out.println("enter quantity");
            int quantity=sc.nextInt();
            Product product=DataBase.products.get(id);
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
        }
        else{
            System.out.println("id not found");
        }
    }

    private static void deleteProduct() {
        System.out.println("enter product id to delete:");
        int id=sc.nextInt();
        if(DataBase.products.containsKey(id) && DataBase.products.get(id).getSellerId()==DataBase.loggedInUserId){
            DataBase.products.remove(id);
        }
        else{
            System.out.println("id not found");
        }
    }


    private static void logout() {
        notLoggedIn=true;
    }

    private static void showProducts() {
        for(Map.Entry<Integer,Product>entry:DataBase.products.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    private static void showMyProducts() {
        for(Map.Entry<Integer,Product>entry :DataBase.products.entrySet()){
            if(entry.getValue().getSellerId()==DataBase.loggedInUserId){
                System.out.println(entry.getValue().toString());

            }
        }
    }

    private static void addproduct() {
        System.out.println("enter product name");
        String name=sc.next();
        System.out.println("enter quantity");
        int quantity=sc.nextInt();
        System.out.println("enter price");
        long price=sc.nextLong();
        Product product=new Product(name,price,quantity,DataBase.loggedInUserId);
        product.setProductId(++DataBase.productId);
        DataBase.products.put(DataBase.productId,product);
        System.out.println("product added successfully");
    }

    private static void loginUser() {
        System.out.println("enter your user id:");
        int id =sc.nextInt();
        if(DataBase.users.containsKey(id)){
            DataBase.loggedInUserId=id;
            System.out.println("logged in success full");
            notLoggedIn=false;
        }
        else{
            System.out.println("you have no account please register first");
        }
    }

    private static void registerUser() {
        System.out.println("enter user name");
        String name=sc.next();
        System.out.println("enter your role");
        String role=sc.next();
        User user=new User(name,role);
        user.setid(++DataBase.userId);
        DataBase.users.put(DataBase.userId,user);
//        System.out.println(DataBase.userId);
//        System.out.println(DataBase.users.get(DataBase.userId));
        System.out.println("registration success full");

    }
}
