package com.example.merchantplatform.merchantplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// import com.twilio.Twilio;
// import com.twilio.rest.api.v2010.account.Message;
// import com.twilio.type.PhoneNumber;

import org.modelmapper.ModelMapper;


@SpringBootApplication
public class MerchantplatformApplication {

	// public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    // public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");


	public static void main(String[] args) {
		// sendMsg();
		SpringApplication.run(MerchantplatformApplication.class, args);
	}


    // public static void sendMsg() {
    //     Twilio.init("AC7b9dfa5fb8161813dd7b2ed7cb034ea7" 
    //             ,"da7ea3dd198e45994f9316d14dcd13bd");
	// 	  // Send the OTP via SMS
    //     Message message = Message.creator(
    //                         new PhoneNumber("+917017991887"),
    //                         new PhoneNumber("+14302337017"),
    //             "Your OTP is: " + 1234)
    //             .create();

    //     // Print the message SID for reference
    //     System.out.println("OTP sent successfully! Message SID: " + message.getSid());
       
	// }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
