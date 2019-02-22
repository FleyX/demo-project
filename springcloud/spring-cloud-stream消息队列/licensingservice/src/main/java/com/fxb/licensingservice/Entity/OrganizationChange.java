package com.fxb.licensingservice.Entity;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/2/21 17:07
 */
public class OrganizationChange {
    /**
     * 动作:修改，删除等
     */
    private String action;


    /**
     * 组织id
     */
    private String orgId;

    /**
     * 关联id
     */
    private String id;

    public OrganizationChange(String action, String orgId, String id) {
        this.action = action;
        this.orgId = orgId;
        this.id = id;
    }

    public OrganizationChange(){}

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
