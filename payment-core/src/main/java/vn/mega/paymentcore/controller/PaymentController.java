package vn.mega.paymentcore.controller;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.mega.coreconfig.utils.Const;
import vn.mega.paymentcore.entities.Payment;
import vn.mega.paymentcore.service.PaymentService;

@RestController
@RequestMapping(Const.API_VERSION + "/payments")
public class PaymentController {


    @Autowired
    private PaymentService paymentService;


    @GetMapping("/{tenantId}")
    public ResponseEntity<?> getPayments(@PathVariable @NotEmpty String tenantId, Pageable pageable) {
        // Set default pagination values if not provided
        if (pageable == null) {
            pageable = PageRequest.of(0, 10); // Page 1 with 10 records by default
        }

        Page<Payment> payments = paymentService.getPayments(tenantId, pageable);

        // Check if payments exist for the given tenantId
        if (payments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(payments);
    }
}
