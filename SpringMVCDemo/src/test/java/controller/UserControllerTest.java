package controller;

import com.thoughtworks.xstream.io.xml.StaxDriver;
import model.User;
import org.springframework.http.*;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;

import java.util.Collections;
import java.util.concurrent.Callable;

/**
 * Created by Charley on 2017/6/15.
 */
public class UserControllerTest {
    @org.testng.annotations.Test
    public void testHandler51() throws Exception {

        RestTemplate restTemplate = buildRestTemplate();

        User user = new User();
        user.setUserId(1234);
        user.setUserName("Charie");

        HttpHeaders entityHeaders = new HttpHeaders();
        entityHeaders.setContentType(MediaType.valueOf("application/xml;UTF-8"));
        entityHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

        HttpEntity<User> requestEntity = new HttpEntity<User>(user, entityHeaders);

        ResponseEntity<User> responseEntity = restTemplate.exchange("http://localhost:8080/user/handler51", HttpMethod.POST, requestEntity, User.class);

        User responseUser = responseEntity.getBody();
        Assert.assertEquals(1000, responseUser.getUserId());
        Assert.assertEquals("Charie", responseUser.getUserName());
    }

    private RestTemplate buildRestTemplate() {

        RestTemplate restTemplate = new RestTemplate();

        XStreamMarshaller xmlMarshaller = new XStreamMarshaller();
        xmlMarshaller.setStreamDriver(new StaxDriver());
        xmlMarshaller.setAnnotatedClasses(new Class[]{User.class});

        MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
        xmlConverter.setMarshaller(xmlMarshaller);
        xmlConverter.setUnmarshaller(xmlMarshaller);
        restTemplate.getMessageConverters().add(xmlConverter);

//        MappingJackson2XmlHttpMessageConverter jsonConverter = new MappingJackson2XmlHttpMessageConverter();
//        restTemplate.getMessageConverters().add(jsonConverter);
        return restTemplate;
    }

}