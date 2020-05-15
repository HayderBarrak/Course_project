package com.futurex.course.CourseApp.Security;

public class JwtProperties {
    public static final String SECRET = "SomeSecretForJWTGeneration";
    public static final int EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "bearer ";
    public static final String HEADER_STRING = "Authorization";
}
