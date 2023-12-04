package com.itheima;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "itheima")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600*1000))
                .compact();
        System.out.println(jwt);
    }

}
