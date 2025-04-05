package com.yeems214.restAPIdemo.Service;

import com.yeems214.restAPIdemo.Entity.RestApiRepository;
import com.yeems214.restAPIdemo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("restApiService")
public class RestApiServiceImpl implements RestApiService {
    @Autowired
    RestApiRepository userRepo;
    @Override
    public void addData(User u) {
        // TODO Auto-generated method stub
        userRepo.save(u);
        System.out.println("addData");
    }
}