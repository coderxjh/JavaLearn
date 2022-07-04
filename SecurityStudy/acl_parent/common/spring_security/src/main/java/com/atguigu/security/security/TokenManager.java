package com.atguigu.security.security;

import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * token操作工具类
 * @author xjh
 * @create 2022-07-01 14:48
 */
@Component
public class TokenManager {

    //token有效时长
    private long tokenExpiration = 24 * 60 * 60 * 1000;

    //编码密钥
    private final String tokeSignKey = "123456";

    /**
     * 1.使用jwt根据用户名生成token
     */
    public String createToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(SignatureAlgorithm.HS256, tokeSignKey).compressWith(CompressionCodecs.GZIP).compact();
    }


    /**
     * 2.根据token字符串得到用户信息
     */
    public String getUserInfoFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(tokeSignKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * 删除token
     */
    public void removeToken(String token) {
    }
}
