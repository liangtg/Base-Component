package com.github.liangtg.app.session;

import com.github.liangtg.app.data.ClientUser;
import com.github.liangtg.app.data.LoginResponse;
import com.github.liangtg.base.data.DataRequest;
import com.github.liangtg.base.data.RetrofitCallback;
import com.squareup.otto.Bus;

import retrofit2.Call;

/**
 * Created by liangtg on 17-7-4.
 */

public class LoginSession {
    private Bus bus;
    private String account;
    private String pwd;

    public LoginSession(Bus bus, String account, String pwd) {
        this.bus = bus;
        this.account = account;
        this.pwd = pwd;
    }

    public void login() {
        login(bus, account, pwd);
    }

    private DataRequest<LoginResponse> login(Bus bus, String account, String pwd) {
        Call<LoginResponse> call = AppSession.current().dataService().login(account, pwd);
        RetrofitCallback<LoginResponse> request = new RetrofitCallback<>(bus, LoginResponse.class);
        call.enqueue(request);
        return request;
    }

    public void loginComplete(LoginResponse response) {
        ClientUser.setCurUser(response);
        AppSession.current().clearCache();
        //TODO login complete
    }

}
