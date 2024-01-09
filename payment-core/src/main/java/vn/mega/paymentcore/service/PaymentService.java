package vn.mega.paymentcore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.mega.paymentcore.entities.Payment;
import vn.mega.paymentcore.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    public void createPayment() {
        // TODO implement here
    }

    public List<Payment> getPayments(String tenantId) {
        return paymentRepository.findByTenantId(tenantId);
    }


    public Page<Payment> getPayments(String tenantId, Pageable pageable) {
        return paymentRepository.findByTenantId(tenantId, pageable);
    }

}
