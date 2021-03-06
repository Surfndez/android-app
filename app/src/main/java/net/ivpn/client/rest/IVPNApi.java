package net.ivpn.client.rest;

import net.ivpn.client.rest.data.LoginRequestBody;
import net.ivpn.client.rest.data.LoginResponse;
import net.ivpn.client.rest.data.ServersListResponse;
import net.ivpn.client.rest.data.privateemails.GenerateEmailRequestBody;
import net.ivpn.client.rest.data.privateemails.GenerateEmailResponse;
import net.ivpn.client.rest.data.privateemails.PrivateEmailsListRequestBody;
import net.ivpn.client.rest.data.privateemails.PrivateEmailsListResponse;
import net.ivpn.client.rest.data.privateemails.RemovePrivateEmailRequestBody;
import net.ivpn.client.rest.data.privateemails.RemovePrivateEmailResponse;
import net.ivpn.client.rest.data.privateemails.UpdatePrivateEmailRequestBody;
import net.ivpn.client.rest.data.privateemails.UpdatePrivateEmailResponse;
import net.ivpn.client.rest.data.proofs.LocationResponse;
import net.ivpn.client.rest.data.session.DeleteSessionRequestBody;
import net.ivpn.client.rest.data.session.DeleteSessionResponse;
import net.ivpn.client.rest.data.session.SessionNewRequestBody;
import net.ivpn.client.rest.data.session.SessionNewResponse;
import net.ivpn.client.rest.data.session.SessionStatusRequestBody;
import net.ivpn.client.rest.data.session.SessionStatusResponse;
import net.ivpn.client.rest.data.subscription.SubscriptionRequestBody;
import net.ivpn.client.rest.data.subscription.SubscriptionResponse;
import net.ivpn.client.rest.data.subscription.ValidateAccountRequestBody;
import net.ivpn.client.rest.data.subscription.ValidateAccountResponse;
import net.ivpn.client.rest.data.wireguard.AddWireGuardPublicKeyRequestBody;
import net.ivpn.client.rest.data.wireguard.AddWireGuardPublicKeyResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IVPNApi {

    @GET("v4/servers.json")
    Call<ServersListResponse> getServers();

    @POST("v2/authenticate")
    Call<LoginResponse> login(@Body LoginRequestBody body);

    @GET("v4/geo-lookup")
    Call<LocationResponse> getLocation();
    
    @POST("v4/session/new")
    Call<SessionNewResponse> newSession(@Body SessionNewRequestBody body);

    @POST("v4/session/status")
    Call<SessionStatusResponse> sessionStatus(@Body SessionStatusRequestBody body);

    @POST("v4/session/delete")
    Call<DeleteSessionResponse> deleteSession(@Body DeleteSessionRequestBody body);

    @POST("v4/session/wg/set")
    Call<AddWireGuardPublicKeyResponse> setWireGuardPublicKey(@Body AddWireGuardPublicKeyRequestBody body);

    @POST("v4/session/pe/list")
    Call<PrivateEmailsListResponse> getPrivateEmails(@Body PrivateEmailsListRequestBody body);

    @POST("v4/session/pe/generate")
    Call<GenerateEmailResponse> generatePrivateEmail(@Body GenerateEmailRequestBody body);

    @POST("v4/session/pe/delete")
    Call<RemovePrivateEmailResponse> removePrivateEmail(@Body RemovePrivateEmailRequestBody body);

    @POST("v4/session/pe/update")
    Call<UpdatePrivateEmailResponse> updatePrivateEmail(@Body UpdatePrivateEmailRequestBody body);

    @POST("/subscriptions/android")
    Call<SubscriptionResponse> processPurchase(@Body SubscriptionRequestBody body);

    @POST("/subscriptions/validate")
    Call<ValidateAccountResponse> validateAccount(@Body ValidateAccountRequestBody body);

}