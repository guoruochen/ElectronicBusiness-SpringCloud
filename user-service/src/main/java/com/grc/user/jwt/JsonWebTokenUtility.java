package com.grc.user.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

/**
 * @author 郭若辰
 * @create 2017-04-25 15:19
 * 生成和校验token的工具类
 */
public class JsonWebTokenUtility {

    /*
    JWT是使用Base64进行编码的，其包括三个部分：header + payload + signature
    其中header规定了signature的加密算法和token类型（按RFC 7519实现的token机制不只JWT一种）
    payload存放token中携带的数据声明（Claim），这里可以存放任意数据
    verify signature则是JWT的安全保障，它采用header中声明的算法
    ，接受三个参数：base64编码的header、base64编码的payload和密钥（secret）进行运算，密钥是Server端自己维护的！！
     */

    //signature加密算法
    private SignatureAlgorithm signatureAlgorithm;
    //密钥
    private Key secretKey;
    //日志
    Logger log = LoggerFactory.getLogger(JsonWebTokenUtility.class);

    public JsonWebTokenUtility() {
        //初始化signature加密算法
        signatureAlgorithm = SignatureAlgorithm.HS256;
        //初始化密钥（为了方便这里维护一个静态密钥即可）
        String encodeKey = "L7A/6zARSkK1j7Vd5SDD9pSSqZlqF7mAhiOgRbgv9Smce6tf4cJnvKOjtKPxNNnWQj+2lQEScm3XIUjhW+YVZg==";
        secretKey = deserializeKey(encodeKey);
    }

    //使用Base64解码密钥
    private Key deserializeKey(String encodedKey) {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        Key key =
                new SecretKeySpec(decodedKey, getSignatureAlgorithm().getJcaName());
        return key;
    }

    //使用Base64编码密钥
    private String serializeKey(Key key) {
        String encodedKey =
                Base64.getEncoder().encodeToString(key.getEncoded());
        return encodedKey;
    }

    //两个getter
    private Key getSecretKey() {
        return secretKey;
    }

    public SignatureAlgorithm getSignatureAlgorithm() {
        return signatureAlgorithm;
    }

    //生成token
    public String createJsonWebToken(AuthTokenDetails authTokenDetails) {
        String token =
                Jwts.builder().setSubject(authTokenDetails.getId().toString())
                        .claim("username", authTokenDetails.getUsername())
                        .setExpiration(authTokenDetails.getExpirationDate())
                        .signWith(getSignatureAlgorithm(),
                                getSecretKey()).compact();
        return token;
    }

    //使用token进行权限认证，并将token中的数据拿出来
    public AuthTokenDetails parseAndValidate(String token) {
        AuthTokenDetails authTokenDetails = null;
        try {
            //将payload中的claim（数据声明）拿出来放到pojo中
            Claims claims =
                    Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();
            String userId = claims.getSubject();
            String username = (String) claims.get("username");
            Date expirationDate = claims.getExpiration();

            authTokenDetails = new AuthTokenDetails();
            authTokenDetails.setId(Long.parseLong(userId));
            authTokenDetails.setUsername(username);
            authTokenDetails.setExpirationDate(expirationDate);
        } catch (JwtException ex) {
            //如果认证失败，将原因写在日志里面
            log.error(ex.getMessage(), ex);
        }
        return authTokenDetails;
    }
}
