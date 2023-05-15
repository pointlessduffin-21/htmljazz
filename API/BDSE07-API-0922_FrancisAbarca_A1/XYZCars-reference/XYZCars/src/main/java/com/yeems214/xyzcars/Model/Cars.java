package com.yeems214.xyzcars.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class Cars {
    private int id;
    private String carName;
    private String carMake;
    private String carModel;
    private String carYear;
    private double carPrice;
}
