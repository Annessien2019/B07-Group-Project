package com.example.smartair.presenter;

import java.util.HashMap;

public interface CallbackInvOps {

    public void onFetchSuccess(HashMap<String, Object> inventory, String type);
    public void onLogFail(String s);
    public void loadData(String type);



}
