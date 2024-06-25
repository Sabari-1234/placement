package org.example.dataBase;

import org.example.cart.Cart;
import org.example.product.Product;
import org.example.user.User;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
    public  static HashMap<Integer, User>users=new HashMap<>();
    public static HashMap<Integer, Product>products=new HashMap<>();
//    public static ArrayList<Cart>cart=new ArrayList<>();
    public static HashMap<Integer,ArrayList<Cart>>cart=new HashMap<>();
    public static HashMap<Integer,ArrayList<Cart>>history=new HashMap<>();
    public static int userId=0;
    public static int loggedInUserId=0;
    public  static int productId=0;
}
