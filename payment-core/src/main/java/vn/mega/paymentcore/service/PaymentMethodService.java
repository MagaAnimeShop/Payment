package vn.mega.paymentcore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.mega.paymentcore.entities.PaymentMethod;
import vn.mega.paymentcore.repository.PaymentMethodRepository;
import vn.mega.paymentcore.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;


    public List<PaymentMethod> getAllPaymentMethod() {
        return paymentMethodRepository.findAll();
    }


    public Page<PaymentMethod> getPaymentMethods(String tenantId, Pageable pageable) {
        return paymentMethodRepository.findByTenantId(tenantId, pageable);
    }


    public PaymentMethod getPaymentMethodById(String id) {
        return paymentMethodRepository.findById(id).orElse(null);
    }


    public PaymentMethod getPaymentMethodByName(String name) {
        return paymentMethodRepository.findByName(name);
    }


    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }


    public PaymentMethod updatePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    public void deletePaymentMethod(String id) {
        paymentMethodRepository.deleteById(id);
    }


}
