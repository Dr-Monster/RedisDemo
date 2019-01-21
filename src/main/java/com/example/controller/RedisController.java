package com.example.controller;

import com.example.dto.ResponseDto;
import com.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
@RequestMapping(value = "/redisQuery")
public class RedisController {

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/addUsers")
    public ResponseDto addUsers(){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(null);
        redisService.addUsers();
        responseDto.setCode(10000);
        return responseDto;
    }

    @RequestMapping(value = "/queryUsers")
    public ResponseDto queryUsers(){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(redisService.getUsers());
        responseDto.setCode(10000);
        return responseDto;
    }
}
