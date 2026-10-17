
package com.nitish.inventory_management_system;

import com.mysql.cj.jdbc.exceptions.NotUpdatable;

import java.sql.*;

public class ProductDAO {

    public void addProduct(Product product) {

        String sql = "INSERT INTO products (product_name, quantity, product_price) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setInt(2, product.getQuantity());
            ps.setDouble(3, product.getPrice());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product added successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void displayAllProducts(){
        String query="SELECT * FROM products";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement pstm=con.prepareStatement(query);
            ResultSet result= pstm.executeQuery()){

           while(result.next()){
               System.out.println("Product_id: "+result.getInt("product_id"));
               System.out.println("Product_Name: "+result.getString("product_name"));
               System.out.println("Quantity: "+result.getInt("quantity"));
               System.out.println("Price: "+result.getDouble("product_price"));
               System.out.println("--------------------------------------");
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
  public void searchProductById(int product_id){
        String query="SELECT * FROM products WHERE product_id= ?";// for returve the from our database

      try{
          Connection con=DBConnection.getConnection();
          PreparedStatement pstm=con.prepareStatement(query);
          pstm.setInt(1,product_id);
          ResultSet result=pstm.executeQuery();
          try{
              if(result.next()){
                  System.out.println("product Id: "+result.getInt("product_id"));
                  System.out.println("product Name: "+result.getString("product_name"));
                  System.out.println("product Price: "+result.getDouble("product_price"));
                  System.out.println("product Quantity: "+result.getInt("quantity"));
              }else{
                  System.out.println("product not founds!");
              }
          }catch (NotUpdatable e){
              e.printStackTrace();
          }
      }catch (SQLException e){
          e.printStackTrace();
      }

  }
  public void updateProduct(int productId,String product_name,double product_price,int quantity){
        String query="UPDATE products SET product_name= ?,product_price= ?, quantity= ? WHERE product_id= ?";

        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,product_name);
            pstm.setDouble(2,product_price);
            pstm.setInt(3,quantity);
            pstm.setInt(4,productId);
           int result= pstm.executeUpdate();

               if(result !=0 ){
                   System.out.println("product updated successfully!!");
               }else{
                   System.out.println("product not found!!");
               }

        }catch (SQLException e){
            e.printStackTrace();
        }
  }
  public void deleteProduct(int product_id){
        String query="DELETE FROM products WHERE product_id= ?";
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,product_id);
           int result= pstm.executeUpdate();
           if(result != 0){
               System.out.println("product deleted successfully from your database");
           }else{
               System.out.println("product not found!!");
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
  }
}
