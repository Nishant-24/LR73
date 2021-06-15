package com.argus.oth.email;

import com.argus.oth.email.configuration.EmailConfiguration;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

@Component(
	configurationPid = "com.argus.oth.email.configuration.EmailConfiguration", immediate = true,
	service = EmailService.class
)
public class EmailService {

	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {
		_emailConfiguration = ConfigurableUtil.createConfigurable(EmailConfiguration.class, properties);
	}

	public void sendEmail(String subjectMessage, String body) throws Exception {
		MailMessage mailMessage = _createMailMessage(subjectMessage, body);

		_mailService.sendEmail(mailMessage);
	}

	private MailMessage _createMailMessage(String subjectMessage, String body) throws Exception {
		String environment = PropsUtil.get(_ENVIRONMENT_NAME_PROPERTY_NAME);

		String subject = String.format(_SUBJECT_STRING_FORMAT, environment, subjectMessage);

		InternetAddress fromInternetAddress = new InternetAddress(
			_emailConfiguration.emailAlertFromAddress(), _emailConfiguration.emailAlertFromName());

		MailMessage mailMessage = new MailMessage(fromInternetAddress, subject, body, true);

		InternetAddress[] toAddresses = InternetAddress.parse(_emailConfiguration.emailAlertToAddress());

		mailMessage.setTo(toAddresses);

		return mailMessage;
	}

	private static final String _ENVIRONMENT_NAME_PROPERTY_NAME = "environment.name";

	private static final String _SUBJECT_STRING_FORMAT = "Liferay: %s - %s";

	private EmailConfiguration _emailConfiguration;

	@Reference
	private MailService _mailService;

}