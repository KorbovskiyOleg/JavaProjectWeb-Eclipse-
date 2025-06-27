package com.olegkorbovskij.cardatabase.service;


import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

    static final long EXPIRATIONTIME=8640000;// 1 день в мс
    static final String PREFIX="Bearer"; // схема
    static final Key key= Keys.secretKeyFor(SignatureAlgorithm.HS256);//Сгенерируйте секретный ключ. Только для демонстрации
                                                                        // Вы должны прочитать его из конфигурации приложения.

    //Сгенерировать подписанный JWT токен
    public String getToken(String username){
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() +EXPIRATIONTIME))
                .signWith(key)
                .compact();

        return token;
    }

    //Получите токен из заголовка авторизации запроса,
    // проверьте токен и получите имя пользователя
    String getAuthUser(HttpServletRequest request){
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(token !=null){
            String user = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();
                    if(user !=null) return user;


        }
        return null;
    }
}
