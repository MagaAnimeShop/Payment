//package vn.mega.paymentweb.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import vn.mega.coreconfig.utils.UserUtils;
//import vn.mega.paymentcore.entities.Payment;
//import vn.mega.paymentcore.service.PaymentService;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//
//@Controller
//public class PaymentBean {
//
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @RequestMapping(value = {"/payment"}, method = RequestMethod.GET)
//    public String getPayment(Model model, @RequestParam("page") Optional<Integer> page,
//                             @RequestParam("size") Optional<Integer> size) {
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(5);
//
//        Page<Payment> payments = paymentService.getPayments(UserUtils.getSelectedTenant(), PageRequest.of(currentPage - 1, pageSize));
//
//        model.addAttribute("payments", payments);
//
//        int totalPages = payments.getTotalPages();
//        if (totalPages > 0) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("pageNumbers", pageNumbers);
//        }
//
//        return "payment";
//    }
//
//
//    @GetMapping("/addPayment")
//    public String showPaymentForm(Model model) {
//        model.addAttribute("payment", new Payment());
//        return "payment-method-detail"; // this corresponds to your Thymeleaf template name
//    }
//
//
////    @PostMapping("/savePayment")
////    public String savePayment(@ModelAttribute Payment payment) {
////        paymentService.createPayment(payment);
////        return "redirect:/addPayment"; // redirect to the form page after saving
////    }
//
//}
