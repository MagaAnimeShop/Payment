package vn.mega.paymentcore.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum PaymentType {

    PAID("Thanh toán đủ"),
    PARTIAL("Thanh toán một phần"),
    REFUND("Hoàn tiền"),
    PENDING("Chờ thanh toán"),
    CANCEL("Hủy thanh toán");

    @Getter
    @Setter
    private String description;

}
