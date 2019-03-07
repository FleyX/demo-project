package com.infinova.sso.entity;

import java.util.Date;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/2/28 18:34
 */
public class User {
    private String recId;
    private String userType;
    private String loginId;
    private String password;
    private String question;
    private String answer;
    private Date passwordChangedDateTime;
    private Date lastModDateTime;

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getPasswordChangedDateTime() {
        return passwordChangedDateTime;
    }

    public void setPasswordChangedDateTime(Date passwordChangedDateTime) {
        this.passwordChangedDateTime = passwordChangedDateTime;
    }

    public Date getLastModDateTime() {
        return lastModDateTime;
    }

    public void setLastModDateTime(Date lastModDateTime) {
        this.lastModDateTime = lastModDateTime;
    }
}
