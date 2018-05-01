package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		//get the current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query sorted by lastName Big later!
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return the results
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/update the customer
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//get the curr hib session
		Session session = sessionFactory.getCurrentSession();
		
		// now retrieve from db using PK
		Customer customer = session.get(Customer.class, theId);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//get the current hib session
		Session session = sessionFactory.getCurrentSession();
		
		//delete the object with PK
		Query query = 
				session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", theId);
		
		query.executeUpdate();
	}

}
