package com.greatlearning.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.greatlearning.customer.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService{
	
	
	private SessionFactory sessionFactory;
	private Session session;
	
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession(); 
		}catch(HibernateException exception) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<Customer> getCustomerList() {
		Transaction tx = session.beginTransaction();
		List<Customer> customer = session.createQuery("from Customer").list();
		tx.commit();
		return customer;
	}

	@Transactional
	public void createUpdateCustomer(Customer customer) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(customer);
		tx.commit();
	}

	@Transactional
	public Customer getCustomerById(int id) {
		Customer customer = new Customer();
		Transaction tx = session.beginTransaction();
		customer = session.get(Customer.class, id);
		tx.commit();
		return customer;
	}

	@Transactional
	public void deleteCustomer(int id) {
		Customer customer = new Customer();
		Transaction tx = session.beginTransaction();
		customer = session.get(Customer.class,id);
		session.delete(customer);
		tx.commit();
	}

}
