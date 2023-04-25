package com.cwc.fake.shop.entities.users;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Address {

    private Geolocation geolocation;
    
    private String city;
   
    private String street;
    
    private String number;
    
    private String zipcode;
}
