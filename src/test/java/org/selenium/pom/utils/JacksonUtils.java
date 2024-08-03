package org.selenium.pom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.selenium.pom.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class JacksonUtils {
//   This method is only used to get data in billing address
//    public static BillingAddress deserializeJson(InputStream is, BillingAddress billingAddress) throws IOException {
//        ObjectMapper objectMapper= new ObjectMapper();
//        return objectMapper.readValue(is,billingAddress.getClass());
//    }

    //if we want to make it generic so we can use it anywhere we apply generics (<T>)
    public static <T> T deserializeJson(String fileName, Class<T> T) throws IOException {
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper= new ObjectMapper();
        return objectMapper.readValue(is , T);
    }
}
