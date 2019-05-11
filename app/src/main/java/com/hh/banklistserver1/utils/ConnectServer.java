package com.hh.banklistserver1.utils;

import android.content.Context;

import org.json.JSONObject;

public class ConnectServer {

    private final static String BASE_URL = "http://delivery-dev-389146667.ap-northeast-2.elb.amazonaws.com";

    // 서버의 응답을 처리하는 역할을 담당하는 인터페이스
    public interface  JsonResponseHandler{

        void onResponse(JSONObject json);

    }


    // 필요한 서버 요청들을 하나한 메ㅗㅆ드로 만들기
    public static void getRequestInfoBank(Context context, /* 필요한파라미터용 변수들 */ final JsonResponseHandler handler){



    }


}
