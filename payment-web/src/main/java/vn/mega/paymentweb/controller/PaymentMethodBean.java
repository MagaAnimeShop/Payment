package vn.mega.paymentweb.controller;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.mega.coreconfig.utils.UserUtils;
import vn.mega.paymentcore.entities.Payment;
import vn.mega.paymentcore.entities.PaymentMethod;
import vn.mega.paymentcore.service.PaymentMethodService;
import vn.mega.paymentcore.service.PaymentService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class PaymentMethodBean {

    @Autowired
    private PaymentMethodService paymentMethodService;


    @RequestMapping(value = {"/payment-method"}, method = RequestMethod.GET)
    public String getPaymentMethod(Model model, @RequestParam("page") Optional<Integer> page,
                                   @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<PaymentMethod> paymentMethods = paymentMethodService.getPaymentMethods(UserUtils.getSelectedTenant(), PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("methods", paymentMethods);

        model.addAttribute("method", new PaymentMethod());

        int totalPages = paymentMethods.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "payment-method";
    }


    @GetMapping("/payment-method-detail/{id}")
    public String getPaymentMethodDetail(Model model, @PathVariable("id") String id, @Nullable @RequestParam("update") Boolean update) {
        model.addAttribute("methods", paymentMethodService.getPaymentMethodById(id));
        model.addAttribute("update", "true");
        return "payment-method-detail";
    }

    @GetMapping("/add-method")
    public String showProductForm(Model model) {
        model.addAttribute("methods", new PaymentMethod());
        model.addAttribute("update", "false");
        return "payment-method-detail"; // this corresponds to your Thymeleaf template name
    }

    @PostMapping("/save-method")
    public String saveProduct(@ModelAttribute PaymentMethod paymentMethod) {

        paymentMethod.setTenantId(UserUtils.getSelectedTenant());
        PaymentMethod method = paymentMethodService.createPaymentMethod(paymentMethod);
        return "redirect:/payment-method-detail/" + method.getId(); // redirect to the form page after saving
    }


    @PostMapping("/update-method/{id}")
    public String updatePaymentMethod(@ModelAttribute PaymentMethod method, @PathVariable("id") String id) {
        PaymentMethod paymentMethod = paymentMethodService.getPaymentMethodById(id);
        if (Objects.isNull(paymentMethod)) {
            // message
            return "redirect:/payment-method-detail/" + id; // redirect to the form page after saving
        }
        paymentMethod.setCode(method.getCode());
        paymentMethod.setName(method.getName());
        paymentMethod.setDescription(method.getDescription());
        paymentMethodService.updatePaymentMethod(paymentMethod);
        return "redirect:/payment-method-detail/" + id + "?update=true"; // redirect to the form page after saving
    }


    @GetMapping("/delete-method/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        paymentMethodService.deletePaymentMethod(id);
        return "redirect:/payment-method";
    }

}
