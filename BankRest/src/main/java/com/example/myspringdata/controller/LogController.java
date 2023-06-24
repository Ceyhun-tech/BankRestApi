package com.example.myspringdata.controller;

import com.example.myspringdata.entity.Logging;
import com.example.myspringdata.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LogController {
    @Autowired
    private LogService logService;
    public void yadda(Logging logging) {
        logService.yadda(logging);
    }

}
