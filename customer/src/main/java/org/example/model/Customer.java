package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
}
