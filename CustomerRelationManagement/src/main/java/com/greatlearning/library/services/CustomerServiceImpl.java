package com.greatlearning.library.services;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.library.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService{

	
	private Session session;
	
	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		try {
			session = sessionFactory.getCurrentSession();
		}
		catch(HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}
	
	@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<Customer> books = session.createQuery("from customer").list();

		tx.commit();

		return books;
	}

	@Transactional
	public Customer findById(int theId) {
		Customer book = new Customer();

		
		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		book = session.get(Customer.class, theId);

		tx.commit();

		return book;
	}

	@Transactional
	public void save(Customer theCustomer) {
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theCustomer);

		tx.commit();
		
	}

	@Override
	public void deleteById(int theId) {

		Transaction tx = session.beginTransaction();

		// get transaction
		Customer book = session.get(Customer.class, theId);

		// delete record
		session.delete(book);

		tx.commit();

		
	}

	@Transactional
	public List<Customer> searchBy(String name, String email) {

		
		Transaction tx = session.beginTransaction();
		String query = "";
		if (name.length() != 0 && email.length() != 0)
			query = "from Book where name like '%" + name + "%' or author like '%" + email + "%'";
		else if (name.length() != 0)
			query = "from Book where name like '%" + name + "%'";
		else if (email.length() != 0)
			query = "from Book where author like '%" + email + "%'";
		else
			System.out.println("Cannot search without input data");

		List<Customer> book = session.createQuery(query).list();

		tx.commit();

		return book;
	}

}
