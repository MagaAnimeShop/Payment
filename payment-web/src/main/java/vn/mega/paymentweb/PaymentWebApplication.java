package vn.mega.paymentweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"vn.mega"})
public class PaymentWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentWebApplication.class, args);
    }

}
