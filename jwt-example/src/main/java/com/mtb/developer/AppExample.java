package com.mtb.developer;

import com.sun.deploy.panel.IProperty;
import org.json.JSONArray;
import org.json.JSONObject;
import sun.misc.IOUtils;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author MithileshB
 * @created 20/01/2021 - 6:17 PM
 * @project jwt-example
 */
public class AppExample {

    public static void main(String[] args) throws Exception {
        String fileName="jaas.config";
        ClassLoader classLoader = AppExample.class.getClassLoader();

       // File file = new File(classLoader.getResource(fileName).getFile());

        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        Properties properties=new Properties();
        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
        }

Properties p1=new Properties();
        properties.forEach((key,value)->{
           value= value.toString().replace("\"","");
            System.out.println(value);
            p1.setProperty((String)key,(String)value);
        });

        Map<String,Object> map=new HashMap(properties);
        map.forEach((key,value)->{
          value=value.toString().replace("\"","");

        });
        System.out.println("map,,,,,,"+getAuthOpt("introspection-endpoint",p1));
        System.out.println("map,,,,,,"+getAuthOpt("introspection-endpoint",map));
        System.out.println("client_id,,,,,,"+getAuthOpt("introspection-endpoint",properties));
        //Read File Content

        String inputJson="{\n" +
            "  \"destination_addresses\": [\n" +
            "    \"Philadelphia, PA, USA\"\n" +
            "  ],\n" +
            "  \"origin_addresses\": [\n" +
            "    \"New York, NY, USA\"\n" +
            "  ],\n" +
            "  \"rows\": [{\n" +
            "    \"elements\": [{\n" +
            "      \"distance\": {\n" +
            "        \"text\": \"94.6 mi\",\n" +
            "        \"value\": 152193\n" +
            "      },\n" +
            "      \"duration\": {\n" +
            "        \"text\": \"1 hour 44 mins\",\n" +
            "        \"value\": 6227\n" +
            "      },\n" +
            "      \"status\": \"OK\"\n" +
            "    }]\n" +
            "  }],\n" +
            "  \"status\": \"OK\"\n" +
            "}";
        JSONObject inputJSONObject = new JSONObject(inputJson);
        getKey(inputJSONObject,"duration");


/*
        Instant now=Instant.now();
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("99XzaC8HcQD6VrLWXsSUpneQG1AALyXPqojG7IaWuv9k1bhBrkyHCpzzUdVjRA8i");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
         byte[] secret1= Base64.getDecoder().decode("99XzaC8HcQD6VrLWXsSUpneQG1AALyXPqojG7IaWuv9k1bhBrkyHCpzzUdVjRA8i");
        byte[] secret2= Base64.getDecoder().decode("S0dvDfikboGvjyRAPlCJRQbyAO7HK8bnMp7K5p3mhS19nkpnyR2Hvvd87ZXd5pdB");
        String jwt = Jwts.builder()
                .setSubject("Mithilesh")
                .setAudience("Coding")
                .claim("1d20", new Random().nextInt(20) + 1)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.MINUTES)))
                .signWith(Keys.hmacShaKeyFor(secret1))
                .compact();
        System.out.println(jwt);

     Date date=new Date(1611183970);

        System.out.println(date);

        Jws<Claims> result = Jwts.parser()
            //    .setSigningKey(Keys.hmacShaKeyFor(secret1))
                .setSigningKey(signingKey)

            //   .setSigningKey("99XzaC8HcQD6VrLWXsSUpneQG1AALyXPqojG7IaWuv9k1bhBrkyHCpzzUdVjRA8i")
                .parseClaimsJws("eyJhbGciOiJSUzI1NiIsImtpZCI6IlBGX0FUX0tFWUlEIiwieDV0IjoiLWNVT2VHcGxXN2xqSC02c0hITTlZS0FsWF9jIiwicGkuYXRtIjoiaDVndSJ9.eyJzY29wZSI6W10sImNsaWVudF9pZCI6IlNpZ21hT3JkZXJNYW5hZ2VyTkVUIiwiaXNzIjoiaHR0cHM6Ly9mZWR0ZXN0LnRkay5kayIsImF1ZCI6WyJvc3NfYm9zcyIsIm9zc19zb20iLCJvc3NfcmVzb3VyY2UiXSwic3ViIjoiU2lnbWFPcmRlck1hbmFnZXJORVQiLCJleHAiOjE2MTExNzY2NzV9.dajKwc1k2XwttqqlIOw3bZ5UpUvN9PcFQCf75LHcOmLAS7mOL3DqTC_27sMvmadOgURC0YW-hABRcbiGPaoOnojPnHdLQyLmJVlwvpBZ-UCeTfmGz3a3lflLuqhOBH-8Rqlr1ooNL-TW7sWiFHMU2O14U-99n856hKTIDlvWgCA6KE1nITlKygkwGKSYor2fP-njLrM5LBjAHtOsTmdD7EiJdwmHxWSeTY4EwwE2eo1SWDvj4zaDC4TWI9t5-iLS_aPUshPKHYG9RPmXdBadIzzQ-sU8Cdd62YQeaxWdqKHyqdzJAWdo3eSQK43WpRuvAQn6ffoPMq6ex05zLLdxVA");
        System.out.println(result);*/
    }
    public static String getAuthOpt(String name,Properties properties) throws Exception {
        String opt = (String) Objects.requireNonNull(properties, "Configuration not initialized").get(name);
        if (opt == null)
            throw new Exception("Required option " + name + " is not configured");
        return opt;
    }
    public static String getAuthOpt(String name,Map<String,Object> a) throws Exception {
        String opt = (String) Objects.requireNonNull(a, "Configuration not initialized").get(name);
        if (opt == null)
            throw new Exception("Required option " + name + " is not configured");
        return opt;
    }
    private static void getKey(JSONObject json, String key) {
        boolean exists = json.has(key);
        Iterator<?> keys;
        String nextKeys;

        if(!exists){
            keys=json.keys();
            while (keys.hasNext()){
                nextKeys=(String)keys.next();
                try{
                    if(json.get(nextKeys) instanceof JSONObject){
                        if(exists==false){
                            getKey(json.getJSONObject(nextKeys),key);
                        }
                    }else if(json.get(nextKeys) instanceof JSONArray){
                        JSONArray jsonArray = json.getJSONArray(nextKeys);
                        for(int i=0;i<jsonArray.length();i++){
                            String jsonArrayString = jsonArray.get(i).toString();
                            JSONObject innerJSONObject = new JSONObject(jsonArrayString);
                            if(exists==false){
                                getKey(innerJSONObject,key);
                            }
                        }
                    }
                }catch (Exception e){
                    System.out.println("Exception :{}"+e.getMessage());
                }
            }
        }else{
            parseObject(json,key);
        }
    }

    private static void parseObject(JSONObject json, String key) {
        System.out.println(json.get(key));
    }
}
