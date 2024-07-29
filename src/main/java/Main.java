import com.grievancemanagement.util.Mailer;

import jakarta.mail.MessagingException;

public class Main {

	public static void main(String[] args) throws MessagingException {
		Mailer mailer = new Mailer();
		mailer.sendEmail("swevara@gmail.com", "Hi", "Hello");
	}
	
}
