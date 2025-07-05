package com.yxb.teaching_assessment.common.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yxb.teaching_assessment.biz.entity.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(String.valueOf(user.getUserid())).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

}
