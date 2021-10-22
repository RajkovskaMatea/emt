package mk.ukim.finki.emt.rentmanagment.service.implementation;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.rentmanagment.domain.exceptions.RentIdNotExistException;
import mk.ukim.finki.emt.rentmanagment.domain.exceptions.RentItemIdNotExistException;
import mk.ukim.finki.emt.rentmanagment.domain.model.Rent;
import mk.ukim.finki.emt.rentmanagment.domain.model.RentId;
import mk.ukim.finki.emt.rentmanagment.domain.model.RentItemId;
import mk.ukim.finki.emt.rentmanagment.domain.repository.RentRepository;
import mk.ukim.finki.emt.rentmanagment.service.RentService;
import mk.ukim.finki.emt.rentmanagment.service.forms.RentForm;
import mk.ukim.finki.emt.rentmanagment.service.forms.RentItemForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RentServiceImpl implements RentService {
    private final RentRepository rentRepository;
    private final Validator validator;
    @Override
    public RentId placeRent(RentForm rentForm){
        Objects.requireNonNull(rentForm,"rent must be different from null.");
        var constraintViolations=validator.validate(rentForm);
        if (constraintViolations.size()>0){
            throw new ConstraintViolationException("The rent form is not valid.", constraintViolations);
        }
        var newRent=rentRepository.saveAndFlush(toDomainObject(rentForm));
        return newRent.getId();
    }
    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public Optional<Rent> findById(RentId id) {
        return rentRepository.findById(id);
    }

    @Override
    public void addItem(RentId rentId, RentItemForm rentItemForm) throws RentIdNotExistException {
        Rent rent = rentRepository.findById(rentId).orElseThrow(RentIdNotExistException::new);
        rent.addItem(rentItemForm.getBike(),rentItemForm.getQuantity());
        rentRepository.saveAndFlush(rent);

    }

    @Override
    public void deleteItem(RentId rentId, RentItemId rentItemId) throws RentIdNotExistException, RentItemIdNotExistException {
        Rent rent = rentRepository.findById(rentId).orElseThrow(RentIdNotExistException::new);
        rent.removeItem(rentItemId);
        rentRepository.saveAndFlush(rent);

    }
    //with creating private method I am converting rentForm into domain entity which in this case is Rent
    private Rent toDomainObject(RentForm rentForm){
        var rent=new Rent(Instant.now(),rentForm.getCurrency());
        rentForm.getItems().forEach(item->rent.addItem(item.getBike(),item.getQuantity()));
        return rent;
    }

}
