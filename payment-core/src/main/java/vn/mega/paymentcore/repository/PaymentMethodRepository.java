package vn.mega.paymentcore.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.mega.paymentcore.entities.Payment;
import vn.mega.paymentcore.entities.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends MongoRepository<PaymentMethod, String> {


}
