package com.hh.banklistserver1.utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ConnectServer {

    private final static String BASE_URL = "http://delivery-dev-389146667.ap-northeast-2.elb.amazonaws.com";

    // 서버의 응답을 처리하는 역할을 담당하는 인터페이스
    public interface  JsonResponseHandler{

        void onResponse(JSONObject json);

    }


    // 필요한 서버 요청들을 하나한 메ㅗㅆ드로 만들기
    public static void getRequestInfoBank(Context context, /* 필요한파라미터용 변수들 */ final JsonResponseHandler handler){

        // 서버 - 클라이언트 (앱)

        OkHttpClient client = new OkHttpClient();

        //URL 설정 => 목적지 설정
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/info/bank").newBuilder();

        String requestURL = urlBuilder.build().toString();

        //완성된 url로 접근하는 request를 생성.
        Request request = new Request.Builder().url(requestURL).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String responseContent = response.body().string();

                Log.d("서버 응답 내용", responseContent);

            }
        });



    }


}
