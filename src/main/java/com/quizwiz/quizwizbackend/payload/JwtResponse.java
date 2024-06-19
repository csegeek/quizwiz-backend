package com.quizwiz.quizwizbackend.payload;

public class JwtResponse {
    private String userName;
    private String token;

    public JwtResponse() {
    }

    public JwtResponse(String userName,String token) {
        this.userName=userName;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

}
