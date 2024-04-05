package com.cs489.contacts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contact {
    private String firstName;
    private String lastName;
    private String company;
    private String jobTitle;

    List<PhoneNumber> phoneNumbers;
    List<EmailAddress> emailAddresses;
}
