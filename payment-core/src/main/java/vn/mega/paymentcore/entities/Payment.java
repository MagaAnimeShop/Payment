package vn.mega.paymentcore.entities;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.mega.coreconfig.entities.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payment")
public class Payment extends BaseEntity {

    private String tenantId;

    private Date paymentDate;

    private String paymentType;

    private String paymentMethod;

    private String status;

    private BigDecimal appliedAmount;


}
