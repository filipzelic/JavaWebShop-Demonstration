/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author filipzelic
 */
public class Repository {
    // init database constants
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:33060/java-web-shop";
    private static final String USERNAME = "homestead";
    private static final String PASSWORD = "secret";
    private static final String MAX_POOL = "250";

    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<Product> getProductsByCategory(String category) {
        if(category == null)
            category = "all";
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = this.connect().prepareStatement("SELECT * FROM `products` where category = ?");
            statement.setString(1, category);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setImageUrl("http://localhost:8080/FilipZelic-WebShop/images/" + rs.getString("imageName"));
                product.setShortDescription(rs.getString("shortDescription"));
                product.setLongDescription(rs.getString("longDescription"));
                product.setQuantity(rs.getInt("amount"));
                product.setPrice(rs.getFloat("price"));
                
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.disconnect();
        }
        
        return products;
    }
    
    public Product getProduct(int id) {
        Product product = new Product();
        
        try {
            PreparedStatement statement = this.connect().prepareStatement("SELECT * FROM products where id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();

            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setImageUrl("http://localhost:8080/FilipZelic-WebShop/images/" + rs.getString("imageName"));
            product.setShortDescription(rs.getString("shortDescription"));
            product.setLongDescription(rs.getString("longDescription"));
            product.setQuantity(rs.getInt("amount"));
            product.setPrice(rs.getFloat("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.disconnect();
        }
        
        return product;
    }
    
    public boolean isEmailAlreadyRegistered(String email) {
        try {
            PreparedStatement statement = this.connect().prepareStatement("SELECT count(*) FROM users where email = ?");
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            rs.next();
            int rowCount = rs.getInt(1);
            if (rowCount > 0) 
                return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.disconnect();
        }
        
        return false;
    }
    
    public void registerUser(User user) {
        try {
            PreparedStatement statement = this.connect().prepareStatement("INSERT INTO users (email, password, activated, first_name,"
                + "                                                     last_name, phone, address, city, postalCode, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setInt(3, 1);
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getAddress());
            statement.setString(8, user.getCity());
            statement.setInt(9, user.getPostalCode());
            statement.setString(10, user.getCountry());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.disconnect();
        }
    }
    
    public boolean attemptLogin(User user) {
        try {
            PreparedStatement statement = this.connect().prepareStatement("SELECT * FROM users where email = ?");
            statement.setString(1, user.getEmail());
            ResultSet rs = statement.executeQuery();
            rs.next();
            int rowCount = rs.getInt(1);
            if (rowCount > 0) {
                if (rs.getString("password").equals(user.getPassword()))
                    return true;
            }            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.disconnect();
        }
        
        return false;
    }
}