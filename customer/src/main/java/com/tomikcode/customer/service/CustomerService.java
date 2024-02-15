package com.tomikcode.customer.service;

import com.tomikcode.amqp.RabbitMQMessageProducer;
import com.tomikcode.clients.fraud.FraudClient;
import com.tomikcode.clients.fraud.model.FraudCheckResponse;
import com.tomikcode.clients.notification.NotificationClient;
import com.tomikcode.clients.notification.model.NotificationRequest;
import com.tomikcode.customer.model.CustomerRegistrationRequest;
import com.tomikcode.customer.model.Customer;
import com.tomikcode.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
//    private final RestTemplate restTemplate;
        private final FraudClient fraudClient;
//        private final NotificationClient notificationClient; // we don't need it
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();
        //todo : check if email valid
        //todo : check if email not taken
        //todo : check if customer is fraud
        customerRepository.saveAndFlush(customer);
//        FraudCheckResponse response = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId()
//        );
        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());
        if(response.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }
        NotificationRequest notificationRequest = NotificationRequest.builder()
                .to_customer_id(customer.getId())
                .to_customer_email("example.email")
                .description("Dear user, we've saved your data to our system")
                .sender("mister Akzhol")
                .title("Successfully saved data")
                .build();
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing.key"

        );
    }
}
