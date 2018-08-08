package com.scheduleplanning.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SchedulePlanningService {
    @FormUrlEncoded
    @POST("/login")
    Call<Response> login(@Field("username") String username, @Field("password") String password);

    @GET("/user/{id}")
    Call<Response> getUser(@Path("id") String _id);

    @GET("/user/{id}/course/{nrc}")
    Call<Response> deleteCourse(@Path("id") String _id, @Path("nrc") String nrc);
}
