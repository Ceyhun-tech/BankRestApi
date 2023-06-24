package com.example.myspringdata.service;

import com.example.myspringdata.entity.Logging;
import com.example.myspringdata.repository.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    @Autowired
    LogRepo logRepo;

    public void yadda(Logging logging) {
        logRepo.save(logging);
    }



}
