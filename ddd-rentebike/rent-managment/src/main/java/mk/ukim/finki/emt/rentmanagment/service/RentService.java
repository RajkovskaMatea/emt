package mk.ukim.finki.emt.rentmanagment.service;

import mk.ukim.finki.emt.rentmanagment.domain.exceptions.RentIdNotExistException;
import mk.ukim.finki.emt.rentmanagment.domain.exceptions.RentItemIdNotExistException;
import mk.ukim.finki.emt.rentmanagment.domain.model.Rent;
import mk.ukim.finki.emt.rentmanagment.domain.model.RentId;
import mk.ukim.finki.emt.rentmanagment.domain.model.RentItemId;
import mk.ukim.finki.emt.rentmanagment.service.forms.RentForm;
import mk.ukim.finki.emt.rentmanagment.service.forms.RentItemForm;

import java.util.List;
import java.util.Optional;

public interface RentService {
    RentId placeRent(RentForm rentForm);
    List<Rent> findAll();
    Optional<Rent> findById(RentId id);

    void addItem(RentId rentId, RentItemForm rentItemForm) throws RentIdNotExistException;
    void deleteItem(RentId rentId, RentItemId rentItemId) throws RentIdNotExistException, RentItemIdNotExistException;

}
