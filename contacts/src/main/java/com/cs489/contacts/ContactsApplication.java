package com.cs489.contacts;

import com.cs489.contacts.model.Contact;
import com.cs489.contacts.model.EmailAddress;
import com.cs489.contacts.model.PhoneNumber;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class ContactsApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(ContactsApplication.class, args);
        List<Contact> contactList = new ArrayList<>();
        List<PhoneNumber> davidPhones = List.of(
                PhoneNumber.builder()
                .phone("240-133-0011")
                .label("Home")
                .build(),
                PhoneNumber.builder()
                        .phone("240-112-0123")
                        .label("Mobile")
                        .build()
        );
        List<EmailAddress> davidEmails = List.of(
                EmailAddress.builder()
                        .email("dave.sang@gmail.com")
                        .label("Home")
                        .build(),
                EmailAddress.builder()
                        .email("dsanger@argos.com")
                        .label("Work")
                        .build()
        );

        contactList.add(
                Contact.builder()
                        .firstName("David")
                        .lastName("Sanger")
                        .company("Argos LLC")
                        .jobTitle("Sales Manager")
                        .phoneNumbers(davidPhones)
                        .emailAddresses(davidEmails)
                .build());
        // Carlos
        List<PhoneNumber> carlosPhones = List.of(
                PhoneNumber.builder()
                        .phone("412-116-9988")
                        .label("Mobile")
                        .build()
        );

        contactList.add(
                Contact.builder()
                    .firstName("Carlos")
                    .lastName("Jimenez")
                    .phoneNumbers(carlosPhones)
                .build());

        // Ali
        List<EmailAddress> aliEmails = List.of(
                EmailAddress.builder()
                        .email("ali@bmi.com")
                        .label("Work")
                        .build()
        );

        contactList.add(
                Contact.builder()
                    .firstName("Ali")
                    .lastName("Gafar")
                    .company("BMI Services")
                    .jobTitle("HR Manager")
                    .emailAddresses(aliEmails)
                .build());

        List<Contact> contacts = contactList.stream()
                .sorted(Comparator.comparing(Contact::getLastName))
                .toList();
        printJson(contacts);
    }

    private static void printJson(List<Contact> contacts) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(contacts));
    }

}
