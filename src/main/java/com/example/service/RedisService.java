package com.example.service;

import com.example.dto.TUser;
import com.example.mapper.TUserMapper;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author Administrator
 */
@Service
public class RedisService {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    TUserMapper tUserMapper;
    @Autowired
    RedisUtil redisUtil;

    public void addUsers(){
        List<TUser> tUserList = new ArrayList<>();
        for (int i = 0 ; i < 100 ; i++){
            /**
             * 这里在做批量插入时,对象每次插入都要重新创建一次,如果使用一个对象的话,在自生成主键时会报错
             */
            TUser tUser = new TUser();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            tUser.setName(uuid);
            int random1 = new Random().nextInt(2);
            if(random1 % 2 == 0){
                tUser.setGender("male");
            }else{
                tUser.setGender("female");
            }
            int random2 = new Random().nextInt(30);
            tUser.setAge(i + random1*random2 + 20);
            tUserList.add(tUser);
            tUserMapper.insertSelective(tUser);
        }
        redisUtil.set("UserList1" , tUserList);
    }

    public List<TUser> getUsers(){
        List<TUser> tUserList = new ArrayList<>();
        if(redisUtil.get("UserList1") != null){
            tUserList = (List<TUser>) redisUtil.get("UserList1");
        }else{
            tUserList = tUserMapper.selectAll();
        }
        return tUserList;
    }
}
