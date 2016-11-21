package com.boot.controller;

import com.boot.controllers.ShipWreckController;
import com.boot.model.Shipwreck;
import com.boot.reposetory.IShipWreckRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Created by mohammad on 11/20/2016.
 */
public class ShipWreckControllerTests {
    @InjectMocks
    private ShipWreckController shipWreckController;

    @Mock
    private IShipWreckRepository shipWreckRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetShipwrecks() {
        List<Shipwreck> list = getShipwercks();
        when(shipWreckRepository.findAll()).thenReturn(list);

        List<Shipwreck> list1 = shipWreckController.getShipwrecks();
        Assert.assertEquals(list.size(), list1.size());
    }

    private List<Shipwreck> getShipwercks() {
        List<Shipwreck> list = new ArrayList<Shipwreck>();
        for(int i=1; i<5;i++) {
            Shipwreck s = new Shipwreck();
            s.setId(i);
            s.setName("name" + i);
            list.add(s);
        }
        return list;
    }
}
