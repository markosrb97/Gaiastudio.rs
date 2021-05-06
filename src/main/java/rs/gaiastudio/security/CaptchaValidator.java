package rs.gaiastudio.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/*

    site key:
    6LcEwrYaAAAAALdyhafWqPFvmnV106JtFCqu_lpU

    secret key:
    6LcEwrYaAAAAAHYvkZIXAppys2y1sfd68UVyyWRP

 */
public class CaptchaValidator {
    
    private static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";
    private static final String recaptchaSecret = "?secret=6LcEwrYaAAAAAHYvkZIXAppys2y1sfd68UVyyWRP";
    CaptchaResponse response;
    
    public boolean validateCaptcha(String captchaResposne){
        RestTemplate restTemplate = new RestTemplate();
        String params = recaptchaSecret + "&response=" + captchaResposne;
        System.out.println(GOOGLE_RECAPTCHA_ENDPOINT+params);
        response = restTemplate.exchange(GOOGLE_RECAPTCHA_ENDPOINT+params, HttpMethod.POST, null, CaptchaResponse.class).getBody();
        if(response.isSuccess()){
            return true;
        }
        return false;
    }
    
}