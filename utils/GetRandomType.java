package utils;

import java.security.SecureRandom;

// with help from https://stackoverflow.com/a/14257525

// Method returns random Enum
public class GetRandomType {
    private static final SecureRandom random = new SecureRandom();
    public static <T extends Enum<?>> T randomEnum(Class<T> classType){
        int x = random.nextInt(classType.getEnumConstants().length);
        return classType.getEnumConstants()[x];
    }
}
