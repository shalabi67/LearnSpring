package com.learn.repository;

import com.learn.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by mshalabi on 04.08.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GetAddressTests {
    @Autowired
    AddressRepository addressRepository;
    @Test
    public void getAddressTests() {
        Address adress = addressRepository.findOne(1L);

    }
}
