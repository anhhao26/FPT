/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author ntpho
 */


import dao.ProductDAO;
import entity.Product;
import java.util.List;

/**
 * Module 2: Implementation của Service
 *  Controller gọi vào đây -> Class này gọi DAO.
 */
public class ProductServiceImpl implements ProductService {

    // Khai báo DAO để Service sử dụng
    private ProductDAO productDAO;

    public ProductServiceImpl() {
        this.productDAO = new ProductDAO();
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public void createNewProduct(Product product) {
        // Có thể thêm logic kiểm tra dữ liệu ở đây trước khi gọi DAO
        // Ví dụ: if (product.getSellingPrice() < 0) throw Exception...
        productDAO.createNewProduct(product);
    }

    @Override
    public void updateProductInfo(Product product) {
        productDAO.updateProductInfo(product);
    }

    @Override
    public void importStock(int productId, int quantityToAdd, double newCostPrice) {
        productDAO.importStock(productId, quantityToAdd, newCostPrice);
    }

    @Override
    public void softDelete(int id) {
        productDAO.softDelete(id);
    }

    @Override
    public void hardDelete(int id) {
        productDAO.hardDelete(id); // Gọi hàm delete trong DAO
    }
}