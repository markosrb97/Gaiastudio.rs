/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.gaiastudio.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;

/**
 *
 * @author filip
 */
public class CaptchaResponse {
    
    private boolean success;
    private String hostname;
    private String challenge_ts;
    
    public String getChallenge_ts(){
        return challenge_ts;
    }
    
    public void setChallenge_ts(String challenge_ts){
        this.challenge_ts = challenge_ts;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }


}
