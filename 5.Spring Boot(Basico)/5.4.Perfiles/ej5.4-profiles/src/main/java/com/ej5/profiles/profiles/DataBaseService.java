package com.ej5.profiles.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DataBaseService {

    @Value("${environment}")
    String environment;

    @Value("${bd.url}")
    String bdURL;

    public void printDataBase() {
        System.out.println(environment);
        System.out.println(bdURL);
    }
}
