package fr.dicks.mobile.forumjv.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class APIClient {

    private final OkHttpClient client = new OkHttpClient();
    private final String serverUrl = "http://192.168.10.48:3000/";

    private static APIClient sInstance;

    private static final String KEY_SERVER_USER_ID = "id";
    private static final String KEY_SERVER_USER_NICKNAME = "nickname";
    private static final String KEY_SERVER_USER_MAIL = "mail";
    private static final String KEY_SERVER_USER_PASSWORD = "password";
    private static final String KEY_SERVER_USER_IMG_URL = "imageUrl";

    private static final String KEY_SERVER_GAME_ID = "id";
    private static final String KEY_SERVER_GAME_TITLE = "title";
    private static final String KEY_SERVER_GAME_DESCRIPTION = "description";
    private static final String KEY_SERVER_GAME_RATING = "rating";
    private static final String KEY_SERVER_GAME_CREATORS = "creators";
    private static final String KEY_SERVER_GAME_PLATFORMS = "platforms";
    private static final String KEY_SERVER_GAME_IMG_URL = "imageUrl";

    private static final String KEY_SERVER_TOPIC_ID = "id";
    private static final String KEY_SERVER_TOPIC_GAMEID = "gameId";
    private static final String KEY_SERVER_TOPIC_SUBJECT = "subject";
    private static final String KEY_SERVER_TOPIC_USERID = "userId";
    private static final String KEY_SERVER_TOPIC_DATE = "date";
    private static final String KEY_SERVER_TOPIC_LAST_UPDATE = "lastUpdate";

    private static final String KEY_SERVER_COMMENT_ID = "id";
    private static final String KEY_SERVER_COMMENT_TOPICID = "topicId";
    private static final String KEY_SERVER_COMMENT_MESSAGE = "message";
    private static final String KEY_SERVER_COMMENT_USERID = "userId";
    private static final String KEY_SERVER_COMMENT_DATE = "date";

    private static final String KEY_SERVER_REVIEW_ID = "id";
    private static final String KEY_SERVER_REVIEW_GAMEID = "gameId";
    private static final String KEY_SERVER_REVIEW_COMMENT = "comment";
    private static final String KEY_SERVER_REVIEW_RATING = "rating";
    private static final String KEY_SERVER_REVIEW_USERID = "userId";
    private static final String KEY_SERVER_REVIEW_DATE = "date";

    public static APIClient getInstance(){
        if (sInstance == null) {
            sInstance = new APIClient();
        }
        return sInstance;
    }

}
