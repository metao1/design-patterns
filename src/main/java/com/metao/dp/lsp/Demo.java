package com.metao.dp.lsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Demo {

    public static void main(String[] args) throws ParseException {
        String name = "Mehrdad";
        String cardNum = "1234-1234-1234-1234-1234";
        String code = "123";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Date expiryDate = formatter.parse("2022.10.01");

        PaymentGatewayHandler gatewayHandler =
                new PaymentGatewayService(name, cardNum, code, expiryDate);

        PaymentInstrumentValidator validator =
                new BankCardBasicValidator(name, cardNum, code, expiryDate);

        FraudChecker fraudChecker =
                new ThirdPartyFraudChecker(name, cardNum, code, expiryDate);

        CreditCard card =
                new CreditCard(
                        name,
                        cardNum,
                        code,
                        expiryDate,
                        validator,
                        fraudChecker,
                        gatewayHandler);

        PaymentProcessor paymentProcessor = new PaymentProcessor();

        OrderDetails order = new OrderDetails();
        order.setOrderNumber("orderNum-12345");
        System.out.println("Starting payment processing for customer " + name + " with creadit card number " + cardNum);
        paymentProcessor.process(order, card);
        System.out.println("Credit card payment successful!");

        RewardsCard rewa = new RewardsCard(name, cardNum);
        System.out.println("Starting payment processing for customer " + name + " with rewards card number " + cardNum);
        paymentProcessor.process(order, rewa);
        System.out.println("Rewards card payment successful!");

    }
}
