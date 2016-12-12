package ru.itis.inform.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.itis.inform.dao.interfaces.CustomerDao;
import ru.itis.inform.models.Customer;

import static org.junit.Assert.*;
import static ru.itis.inform.dao.data.CustomerTestData.getCustomer1;

/**
 * Created by Kamil Karimov on 12.12.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfig.class)
public class CustomerDaoImplTest {

    @Autowired
    CustomerDao customerDao;

    private Customer customer1;

    @Before
    public void setUp() throws Exception {
        customer1 = getCustomer1();
    }

    @Test
    public void getCustomerByPhone() throws Exception {

    }

    @Test
    public void getCustomerById() throws Exception {
        assertEquals(customer1, customerDao.getCustomerById(1));
    }

    @Test
    public void getAllCustomers() throws Exception {

    }

    @Test
    public void getCustomerByToken() throws Exception {

    }

}