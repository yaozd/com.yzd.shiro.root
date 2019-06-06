package com.yzd.shiro.web.api.utils.jwtExt;

import lombok.extern.slf4j.Slf4j;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class JwtUtilTest {

    @Rule
    public ContiPerfRule i = new ContiPerfRule();
    @Test
    @PerfTest(threads = 100,duration=10000)
    public void createToken() {
      String token=JwtUtil.createToken("1");
      //log.info(token);
    }

    @Test
    public void verifyToken() {
        String token=JwtUtil.verifyToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ5emQiLCJleHAiOjE1NTk4MDM5OTIsImlhdCI6MTU1OTgwMzY5MiwiVVNFUl9KU09OIjoiXCIxXCIifQ.HNJsnG87suXbqbHZJ4ZBxh0G2UAJiFLjedRIr9uPXFQ",String.class);
        log.info(token);
    }

    @Test
    public void refreshToken() {
        String token=JwtUtil.refreshToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9..HNJsnG87suXbqbHZJ4ZBxh0G2UAJiFLjedRIr9uPXFQ",String.class);
        log.info(token);
    }
}