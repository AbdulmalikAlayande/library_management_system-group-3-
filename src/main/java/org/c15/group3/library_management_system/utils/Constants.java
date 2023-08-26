package org.c15.group3.library_management_system.utils;

public class Constants {
    public static final String ACTIVATION_MAIL_PATH = "classpath:/templates/account_activation_mail_template.html";
    public static final String PAYMENT_SUCCESS_MAIL_PATH = "classpath:/templates/payment_success_template.html";
    public static final String CONSTRAINT_VIOLATION_TEMPLATE_MESSAGE = "Invalid Domain:: valid domain includes %s";
    public static final String SENDER_FULL_NAME = "Alayande Abdulmalik";
    public static final String SENDER_EMAIL = "alaabdulmalik03@gmail.com";
    public static final String API_KEY = "api-key";
    public static final String BREVO_SEND_EMAIL_API_URL = "https://api.brevo.com/v3/smtp/email";
    public static final String MESSAGE_SUCCESSFULLY_SENT = "Message Sent Successfully";
    public static final String MESSAGE_FAILED_TO_SEND = "Message Could Not Be Sent";
    public static final String MESSAGE_SUBJECT = "Support At Library Management System";
    public static final String TEMPLATE_LOAD_FAILED = "Error loading template content Template failed to load:: ";
}
