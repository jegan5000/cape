package com.ust.serviceprovider.util;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryUtil{
    @Value("${cloudinary.cloud-name}")
    private String cloudName;

    @Value("${cloudinary.api-key}")
    private String apiKey;

    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret));
    }
}
//
//import com.cloudinary.Cloudinary;
//import com.cloudinary.utils.ObjectUtils;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Map;
//
//@Component
//public class CloudinaryUtil {
//
//    private final Cloudinary cloudinary;
//
//    public CloudinaryUtil() {
//        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
//                "cloud_name", "your_cloud_name",
//                "api_key", "your_api_key",
//                "api_secret", "your_api_secret"
//        ));
//    }
//
//    public String uploadImage(byte[] image, String fileName) throws IOException {
//        Map uploadResult = cloudinary.uploader().upload(image, ObjectUtils.asMap("public_id", fileName));
//        return (String) uploadResult.get("url");
//    }
//}

