package com.wang.permission;

public interface IPermissionCallBack {

    default void success(){}

    default void fail(){}

    default void noMoreReminders(){}

    default void alreadyObtainedPermission(){}
}
