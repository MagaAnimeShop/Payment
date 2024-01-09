package vn.mega.paymentcore.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDTO {

    private String id;

    private String tenantId;

    private Date paymentDate;

    private String paymentType;

    private String paymentMethod;

    private String status;

    private BigDecimal appliedAmount;

}
