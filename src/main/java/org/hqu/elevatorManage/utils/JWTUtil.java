package org.hqu.elevatorManage.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.hqu.elevatorManage.common.enums.JWTResultEnum;
import org.hqu.elevatorManage.common.exception.JWTException;
import org.hqu.elevatorManage.domain.entity.User;

import java.util.Calendar;
import java.util.Date;

@Slf4j
public class JWTUtil {

    private static final long EXPIRE_TIME = 60 * 60 * 24 * 30;

    private static final String SECRET = "SHIRO+JWT";


    /**
     * 生成JwtToken
     * @param username 用户名
     * @param secret 秘钥
     * @param amount 过期天数
     */

    /**
     * <p>生成JWTToken</p>
     * @date 2022/5/7 15:47 <br>
     * @author liulingyu <br>
     * @param user 用户实体，包含账号密码和单位id
     * @return java.lang.String token
     */
    public static String createToken(User user){
        // 过期时间
        Calendar ca = Calendar.getInstance();


        ca.add(Calendar.SECOND, (int) EXPIRE_TIME);


        Algorithm algorithm = Algorithm.HMAC256(SECRET);

        // 创建JwtToken对象
        String token="";
        token= JWT.create()
                // 用户名
                .withSubject(user.getUsername())
                // 发布时间
                .withIssuedAt(new Date())
                // 过期时间
                .withExpiresAt(ca.getTime())
                // 自定义随机Claim
                .withClaim("username",user.getUsername() )

                .sign(algorithm);

        return token;
    }

    /**
     * <p>
     *     在token中获取到username信息
     * </p>
     * @date 2022/5/7 15:49 <br>
     * @author liulingyu <br>
     * @param token JWTToken
     * @return java.lang.String 用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        }catch (NullPointerException e){
            throw new JWTException(JWTResultEnum.TOKEN_DECODE_FAILED, e.getMessage());
        }
        catch (JWTDecodeException e) {
            throw new JWTException(JWTResultEnum.TOKEN_DECODE_FAILED,e.getMessage());

        } catch (Exception e){
            log.error("",e);
            throw new JWTException(JWTResultEnum.TOKEN_DECODE_FAILED,e.getMessage());

        }
    }

    /**
     * <p>
     *     在token中获取到单位id
     * </p>
     * @date 2022/5/7 15:49 <br>
     * @author liulingyu <br>
     * @param token JWTToken
     * @return java.lang.String 单位id
     */
    public static Long getUnitId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("unitId").asLong();
        } catch (JWTDecodeException e) {
            throw new JWTException(JWTResultEnum.TOKEN_DECODE_FAILED,e.getMessage());

        }
    }

    
    /**
     * <p>
     *     判断是否过期
     * </p>
     * @date 2022/5/7 19:35 <br>
     * @author liulingyu <br>
     * @param token JWTToken
     * @return {@link boolean} 是否过期
     */
    public static boolean isExpire(String token){


        DecodedJWT jwt = null;
        try {
            jwt = JWT.decode(token);
        } catch (JWTDecodeException e) {
            throw new JWTException(JWTResultEnum.TOKEN_DECODE_FAILED,e.getMessage());
        }
        if (jwt.getExpiresAt().getTime() < System.currentTimeMillis()){
            throw new JWTException(JWTResultEnum.TOKEN_EXPIRED);

        }
        return true ;
    }


    /**
     * <p>
     *     校验 token 是否正确
     * </p>
     * @date 2022/5/7 15:51 <br>
     * @author liulingyu <br>
     * @param token 密钥
     * @param username 用户名
     * @return boolean 是否正确
     */
    public static boolean verify(String token, String username) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //在token中附带了username信息
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .withClaim("unitId",getUnitId(token))
                    .build();
            //验证 token
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }



}
