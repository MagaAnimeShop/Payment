package vn.mega.paymentweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.mega.paymentcore.entities.Payment;
import vn.mega.paymentcore.service.PaymentService;

@Controller
public class PaymentBean {


    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = {"/payment"}, method = RequestMethod.GET)
    public String getPayment(Model model) {
        return "payment.html";
    }

}
