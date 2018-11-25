package com.fxb.licensingservice.Entity;

import java.io.Serializable;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2018/11/22 19:52
 */
public class Licensing implements Serializable {
    private Organization organization;
    private boolean isValid;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
