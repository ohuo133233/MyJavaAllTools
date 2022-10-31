package com.wang.permission;

public interface IPermissionCallBack {

    void success();

    void fail();

    void noMoreReminders();

    void alreadyObtainedPermission();
}
