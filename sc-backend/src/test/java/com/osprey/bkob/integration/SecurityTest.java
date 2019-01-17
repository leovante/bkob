package com.osprey.bkob.integration;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetupTest;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.osprey.bkob.service.MailService;
import lombok.extern.java.Log;
import org.apache.commons.mail.util.MimeMessageParser;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.net.URI;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Log
@EnableWebSecurity
@ActiveProfiles("test")
public class SecurityTest {

    public static GreenMail greenMail = new GreenMail(ServerSetupTest.SMTP);
    @Autowired
    MailService mailService;
    @Autowired
    TestRestTemplate testRestTemplate;

    @BeforeClass
    public static void setup() {
        greenMail.setUser("my.gmail@local", "password");
        greenMail.start();
    }

    @AfterClass
    public static void cleanUp() {
        greenMail.stop();
    }

    @Test
    public void registrationTest() throws Exception {

        //registration
        final String signupRequest = "{\n" +
                "\"email\":\"some@local\",\n" +
                "\"password\":\"123\",\n" +
                "\"username\":\"some-name\",\n" +
                "\"year\":1990,\n" +
                "\"country\":\"sm\",\n" +
                "\"languages\":[\"ru\",\"en\",\"de\"],\n" +
                "\"day\":1,\n" +
                "\"month\":1\n" +
                "}";

        RequestEntity<String> requestEntity = RequestEntity.post(URI.create("/public/signup"))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
                .body(signupRequest);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(requestEntity, String.class);
        log.info("Response: " + responseEntity);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

        MimeMessage[] messages = greenMail.getReceivedMessages();
        assertThat(greenMail.getReceivedMessages().length, is(1));

        MimeMessageParser parser = new MimeMessageParser(messages[0]);
        parser.parse();

        Pattern pattern = Pattern.compile("activate\\/(.+)$");
        Matcher matcher = pattern.matcher(parser.getPlainContent());
        assertThat(matcher.find(), is(true));
        UUID activationCode = UUID.fromString(matcher.group(1));
        log.info("Activation code: " + activationCode);

        //activation
        String activationUrl = "/public/activate/" + activationCode;
        responseEntity = testRestTemplate.postForEntity(URI.create(activationUrl), null, String.class);
        log.info("Response: " + responseEntity);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

        //login
        String loginForm = "email=some@local&password=123&rememberMe=true";
        requestEntity = RequestEntity.post(URI.create("/public/login"))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .body(loginForm);
        responseEntity = testRestTemplate.exchange(requestEntity, String.class);
        log.info("Response: " + responseEntity);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

        String token = JsonPath.read(responseEntity.getBody(), "$.access_token");
        assertThat(token, not(isEmptyOrNullString()));
        String token_type = JsonPath.read(responseEntity.getBody(), "$.token_type");
        assertThat(token_type, is("bearer"));

        //getting current user
        RequestEntity<Void> currentUserEntity = RequestEntity.get(URI.create("/public/currentUser"))
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
        responseEntity = testRestTemplate.exchange(currentUserEntity, String.class);
        log.info("Response: " + responseEntity);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

        DocumentContext documentContext = JsonPath.parse(responseEntity.getBody());
        String email = documentContext.read("$.email");
        assertThat(email, is("some@local"));
        String password = documentContext.read("$.password");
        assertThat(password, isEmptyOrNullString());
        String state = documentContext.read("$.state");
        assertThat(state, is("ACTIVE"));
    }

    @TestConfiguration
    public static class Configuration {

        @Bean
        @Primary
        public JavaMailSender getJavaMailSender() {

            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("localhost");
            mailSender.setPort(greenMail.getSmtp().getPort());

            mailSender.setUsername("my.gmail@local");
            mailSender.setPassword("password");

            Properties props = mailSender.getJavaMailProperties();

            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "ture");
            props.put("mail.debug", "true");

            return mailSender;
        }
    }
}
