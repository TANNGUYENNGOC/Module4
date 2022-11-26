package com.codegym.repository;

import com.codegym.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository{

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM  Product ").getResultList();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void saveProduct(Product product) {
        Session session=null;
        Transaction transaction=null;
        try{
            session=ConnectionUtil.sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.save(product);
            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("FROM Product where id = :idx").setParameter("idx",id).getSingleResult();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            // dòng 68 có thể thay thế merge bằng persist
            session.merge(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void removeProduct(int id) {
        Session session=null;
        Transaction transaction=null;
        Product product=null;
        try{
            session=ConnectionUtil.sessionFactory.openSession();
            transaction=session.beginTransaction();
            product= (Product) session.createQuery("from Product p where id =:idx").setParameter("idx",id).getSingleResult();
            session.remove(product);
            // thực hiện xong 1 tiến trình phải comit lại để lưu sự thay đổi với table trong DB
            transaction.commit();
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> searchName(String nameProduct) {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM  Product WHERE name like :nameProduct").setParameter("nameProduct","%"+nameProduct+"%").getResultList();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return productList;
    }
}
