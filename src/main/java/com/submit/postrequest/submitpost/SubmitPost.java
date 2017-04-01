package com.submit.postrequest.submitpost;

import com.submit.postrequest.beans.ContactUs;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Seth on 3/31/2017.
 */
public class SubmitPost {

    private Logger logger = LoggerFactory.getLogger(SubmitPost.class);
    private InputStream inputStream;

    public void submitContactFormPost(ContactUs contactUs) {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/contact/contact.action");

        // Request parameters and other properties
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("contact.name", contactUs.getName()));
        params.add(new BasicNameValuePair("contact.email", contactUs.getEmail()));
        params.add(new BasicNameValuePair("contact.phoneNumber", contactUs.getPhoneNumber()));
        params.add(new BasicNameValuePair("contact.message", contactUs.getComment()));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            // Execute and get the response
            HttpResponse response = httpClient.execute(httpPost);
            logger.info("POST Parameters Submitted: \n" + contactUs.toString());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                inputStream = entity.getContent();
                logger.info("Response from server: \n" + inputStream);
            }
        } catch (IOException e) {
            logger.error("An exception has occured: \n" + e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                logger.error("Error closing the input stream: \n" + e);
            }
        }
    }
}
