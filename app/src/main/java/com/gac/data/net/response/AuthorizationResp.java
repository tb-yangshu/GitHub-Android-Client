package com.gac.data.net.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;

/**
 * authorization resp
 * Created by spencer on 10/17/16.
 */
public class AuthorizationResp implements Serializable {

    @SerializedName("id")
    private int mId;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("app")
    private App mApp;
    @SerializedName("token")
    private String mToken;
    @SerializedName("hashed_token")
    private String mHashedToken;
    @SerializedName("token_last_eight")
    private String mTokenLastEight;
    @SerializedName("note")
    private String mNote;
    @SerializedName("note_url")
    private String mNoteUrl;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("fingerprint")
    private String mFingerprint;
    @SerializedName("scopes")
    private String[] mScopes;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public App getApp() {
        return mApp;
    }

    public void setApp(App app) {
        mApp = app;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

    public String getHashedToken() {
        return mHashedToken;
    }

    public void setHashedToken(String hashedToken) {
        mHashedToken = hashedToken;
    }

    public String getTokenLastEight() {
        return mTokenLastEight;
    }

    public void setTokenLastEight(String tokenLastEight) {
        mTokenLastEight = tokenLastEight;
    }

    public String getNote() {
        return mNote;
    }

    public void setNote(String note) {
        mNote = note;
    }

    public String getNoteUrl() {
        return mNoteUrl;
    }

    public void setNoteUrl(String noteUrl) {
        mNoteUrl = noteUrl;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String getFingerprint() {
        return mFingerprint;
    }

    public void setFingerprint(String fingerprint) {
        mFingerprint = fingerprint;
    }

    public String[] getScopes() {
        return mScopes;
    }

    public void setScopes(String[] scopes) {
        mScopes = scopes;
    }

    @Override
    public String toString() {
        return "AuthorizationResp{"
                + "mId=" + mId
                + ", mUrl='" + mUrl
                + '\''
                + ", mApp=" + mApp
                + ", mToken='" + mToken
                + '\''
                + ", mHashedToken='" + mHashedToken
                + '\''
                + ", mTokenLastEight='" + mTokenLastEight
                + '\''
                + ", mNote='" + mNote
                + '\''
                + ", mNoteUrl='" + mNoteUrl
                + '\''
                + ", mCreatedAt='" + mCreatedAt
                + '\''
                + ", mUpdatedAt='" + mUpdatedAt
                + '\''
                + ", mFingerprint='" + mFingerprint
                + '\''
                + ", mScopes=" + Arrays.toString(mScopes)
                + '}';
    }

    public static class App implements Serializable {

        @SerializedName("name")
        private String mName;
        @SerializedName("url")
        private String mUrl;
        @SerializedName("client_id")
        private String mClientId;

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        @Override
        public String toString() {
            return "App{"
                    + "mName='" + mName
                    + '\''
                    + ", mUrl='" + mUrl
                    + '\''
                    + ", mClientId='" + mClientId
                    + '\''
                    + '}';
        }
    }
}
