package vn.mega.paymentcore.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.mega.paymentcore.entities.Payment;
import vn.mega.paymentcore.entities.PaymentMethod;

import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

    List<Payment> findByTenantId(String tenantId);

    Page<Payment> findByTenantId(String tenantId, Pageable pageable);
}
