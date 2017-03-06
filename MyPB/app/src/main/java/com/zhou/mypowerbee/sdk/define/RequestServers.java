package com.zhou.mypowerbee.sdk.define;

import com.zhou.mypowerbee.model.entity.DeviceInfoDTO;
import com.zhou.mypowerbee.model.entity.GroupInfoDTO;
import com.zhou.mypowerbee.model.entity.NodeInfoDTO;
import com.zhou.mypowerbee.model.entity.TerminalInfoDTO;
import com.zhou.mypowerbee.model.entity.UserInfoDTO;
import com.zhou.mypowerbee.model.entity.VidInfoDTO;
import com.zhou.mypowerbee.sdk.dto.UserDTO;
import com.zhou.mypowerbee.sdk.netlog.NetConfigFile;

import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.adapter.rxjava.Result;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by powerbee-z on 16-10-11.
 */
public interface RequestServers {
    //    String Base_URL = "http://120.25.224.31:8090/CardSocial/";
    public final String URL_SERVICE = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/";
    public final String URL_SERVICE_UPDATE = "http://" + NetConfigFile.SERVER_HTTP_IP_UPDATE + ":" + NetConfigFile.SERVER_HTTP_PORT_UPDATE + "/";

    @GET("user/login/{userid}/{password}")
    Observable<Result<UserInfoDTO>> userLogin(
            @Path("userid") String userid,
            @Path("password") String password);

    @GET("user/check/{account}")
    Observable<VidInfoDTO> getVid(@Path("account") String account);

    @GET("user/verifycode/{vid}")
    Observable<ResponseBody> getverficationCode(@Path("vid") String vid);

    @Headers({
            "Content-Type: application/json"
    })
    @POST("user")
    Observable<UserInfoDTO> register(@Body UserInfoDTO.UserDTO userDTO,
                                     @Header("vid") String vid,
                                     @Header("code") String code);

    @GET("terminal")
    Observable<TerminalInfoDTO> getTerminal(
    );

    @GET("device/group")
    Observable<GroupInfoDTO> getGroup(
    );

    @GET("node")
    Observable<NodeInfoDTO> getNodes();

    //获取所有设备
    @GET("device")
    Observable<DeviceInfoDTO> getAllDevices();

    //获取控制设备
    @GET("device/0")
    Observable<DeviceInfoDTO> getControlDevices();

    //获取传感器
    @GET("device/1")

    @FormUrlEncoded
    @POST("card/getPublicCard")
    Call<ResponseBody> getPublicCard(
            @Query("phone") String phone,
            @Field("keyDesc") String keyDesc,
            @Query("pageIndex") int pageIndex,
            @Query("pageSize") int pageSize);

    //验证手机号码是否注册了账号
    @POST("sns/weixin")
    Call<ResponseBody> getNoPhone(@Query("phone") String phone);


}
