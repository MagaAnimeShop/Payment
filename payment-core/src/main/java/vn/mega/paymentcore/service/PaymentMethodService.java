package vn.mega.paymentcore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.mega.paymentcore.repository.PaymentMethodRepository;
import vn.mega.paymentcore.repository.PaymentRepository;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;


}
