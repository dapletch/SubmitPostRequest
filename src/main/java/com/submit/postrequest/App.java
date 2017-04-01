package com.submit.postrequest;

import com.submit.postrequest.beans.ContactUs;
import com.submit.postrequest.submitpost.SubmitPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static SubmitPost submitPost = new SubmitPost();
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ContactUs contactUs = new ContactUs("Seth Pletcher"
                , "your_email@gmail.com"
                , "888-888-8888"
                , "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
                "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt " +
                "in culpa qui officia deserunt mollit anim id est laborum.");
        logger.info("Contact Information: " + contactUs.toString());
        submitPost.submitContactFormPost(contactUs);
    }
}