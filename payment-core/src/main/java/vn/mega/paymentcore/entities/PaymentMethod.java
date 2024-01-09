package vn.mega.paymentcore.entities;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import vn.mega.coreconfig.entities.BaseEntity;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payment-method")
public class PaymentMethod extends BaseEntity {

    private String tenantId;

    private String code;

    private String name;

    private String description;

    private String image;

}
