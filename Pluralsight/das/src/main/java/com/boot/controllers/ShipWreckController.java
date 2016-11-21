package com.boot.controllers;

import com.boot.model.Shipwreck;
import com.boot.reposetory.IShipWreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammad on 11/20/2016.
 */
@RestController
@RequestMapping("api/v1/")
public class ShipWreckController {
    @Autowired
    IShipWreckRepository repository;

    @GetMapping("shipwrecks")
    public List<Shipwreck> getShipwrecks() {
        return repository.findAll();
    }
    @PostMapping("shipwrecks")
    public Shipwreck createShipwreck(@RequestBody Shipwreck shipWreck) {
        return repository.saveAndFlush(shipWreck);
    }

    @GetMapping("shipwrecks/{shipwreckId}")
    public Shipwreck getShipWreck(@PathVariable Long shipwreckId) {
        return repository.findOne(shipwreckId);
    }
    @PutMapping("shipwrecks/{shipwreckId}")
    public Shipwreck updateShipWreck(@PathVariable Long shipwreckId, @RequestBody Shipwreck shipWreck) {
        Shipwreck newShip = repository.findOne(shipwreckId);
        BeanUtils.copyProperties(shipWreck, newShip);
        return repository.saveAndFlush(newShip);

    }
    @DeleteMapping("shipwrecks/{shipwreckId}")
    public void deleteShipWreck(@PathVariable Long shipwreckId) {
        Shipwreck newShip = repository.findOne(shipwreckId);
        repository.delete(shipwreckId);
    }


}
