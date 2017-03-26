package com.shalabi.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.shalabi.model.Shipwreck;
import com.shalabi.repository.ShipwreckRepository;

@Repository
public class ShipwreckRepositoryImp implements ShipwreckRepository {
	Long id = 0L;
	List<Shipwreck> shipwrecks = new ArrayList<>();
	public List<Shipwreck> getShipwrecks() {
		return shipwrecks;
	}

	public void setShipwrecks(List<Shipwreck> shipwrecks) {
		this.shipwrecks = shipwrecks;
	}
	
	
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<Shipwreck> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Shipwreck> findAll() {
		return shipwrecks;
	}

	

	@Override
	public List<Shipwreck> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shipwreck> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Shipwreck> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Shipwreck> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shipwreck getOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Shipwreck> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Shipwreck> S saveAndFlush(S shipwreck) {
		id++;
		shipwreck.setId(id);
		shipwrecks.add(shipwreck);
		return shipwreck;
	}

	@Override
	public Page<Shipwreck> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Shipwreck arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends Shipwreck> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Shipwreck findOne(Long id) {
		Optional<Shipwreck> shipwerck = this.shipwrecks.stream().filter(a -> a.getId() == id).findFirst();
		return shipwerck.get(); //
	}

	@Override
	public <S extends Shipwreck> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Shipwreck> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Shipwreck> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Shipwreck> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Shipwreck> S findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
