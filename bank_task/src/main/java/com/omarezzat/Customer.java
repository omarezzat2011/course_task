package com.omarezzat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@Data
@RequiredArgsConstructor
public class Customer {
    private final String firstName;
    private final String lastName;
    private final String phoneNumber;

}
