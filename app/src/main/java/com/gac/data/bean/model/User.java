package com.gac.data.bean.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * User
 * Created by spencer on 10/17/16.
 */
public class User implements Serializable {

    @SerializedName("login")
    private String mLogin;
    @SerializedName("id")
    private int mId;
    @SerializedName("avatar_url")
    private String mAvatarUrl;
    @SerializedName("gravatar_id")
    private String mGravatarId;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("html_url")
    private String mHtmlUrl;
    @SerializedName("followers_url")
    private String mFollowersUrl;
    @SerializedName("following_url")
    private String mFollowingUrl;
    @SerializedName("gists_url")
    private String mGistsUrl;
    @SerializedName("starred_url")
    private String mStarredUrl;
    @SerializedName("subscriptions_url")
    private String mSubscriptionsUrl;
    @SerializedName("organizations_url")
    private String mOrganizationsUrl;
    @SerializedName("repos_url")
    private String mReposUrl;
    @SerializedName("events_url")
    private String mEventsUrl;
    @SerializedName("received_events_url")
    private String mReceivedEventsUrl;
    @SerializedName("type")
    private String mType;
    @SerializedName("site_admin")
    private boolean mSiteAdmin;
    @SerializedName("name")
    private String mName;
    @SerializedName("company")
    private String mCompany;
    @SerializedName("blog")
    private String mBlog;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("hireable")
    private String mHireable;
    @SerializedName("bio")
    private String mBio;
    @SerializedName("public_repos")
    private int mPublicRepos;
    @SerializedName("public_gists")
    private int mPublicGists;
    @SerializedName("followers")
    private int mFollowers;
    @SerializedName("following")
    private int mFollowing;
    @SerializedName("created_at")
    private String mCreatedAt;
    @SerializedName("updated_at")
    private String mUpdatedAt;
    @SerializedName("username")
    private String mUsername;
    @SerializedName("date")
    private String mDate;

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return mGravatarId;
    }

    public void setGravatarId(String gravatarId) {
        mGravatarId = gravatarId;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getHtmlUrl() {
        return mHtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        mHtmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return mFollowersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        mFollowersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return mFollowingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        mFollowingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return mGistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        mGistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return mStarredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        mStarredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return mSubscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        mSubscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return mOrganizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        mOrganizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return mReposUrl;
    }

    public void setReposUrl(String reposUrl) {
        mReposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return mEventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        mEventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return mReceivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        mReceivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public boolean isSiteAdmin() {
        return mSiteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        mSiteAdmin = siteAdmin;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCompany() {
        return mCompany;
    }

    public void setCompany(String company) {
        mCompany = company;
    }

    public String getBlog() {
        return mBlog;
    }

    public void setBlog(String blog) {
        mBlog = blog;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getHireable() {
        return mHireable;
    }

    public void setHireable(String hireable) {
        mHireable = hireable;
    }

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }

    public int getPublicRepos() {
        return mPublicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        mPublicRepos = publicRepos;
    }

    public int getPublicGists() {
        return mPublicGists;
    }

    public void setPublicGists(int publicGists) {
        mPublicGists = publicGists;
    }

    public int getFollowers() {
        return mFollowers;
    }

    public void setFollowers(int followers) {
        mFollowers = followers;
    }

    public int getFollowing() {
        return mFollowing;
    }

    public void setFollowing(int following) {
        mFollowing = following;
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

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    @Override
    public String toString() {
        return "User{"
                + "mLogin='" + mLogin
                + '\''
                + ", mId=" + mId
                + ", mAvatarUrl='" + mAvatarUrl
                + '\''
                + ", mGravatarId='" + mGravatarId
                + '\''
                + ", mUrl='" + mUrl
                + '\''
                + ", mHtmlUrl='" + mHtmlUrl
                + '\''
                + ", mFollowersUrl='" + mFollowersUrl
                + '\''
                + ", mFollowingUrl='" + mFollowingUrl
                + '\''
                + ", mGistsUrl='" + mGistsUrl
                + '\''
                + ", mStarredUrl='" + mStarredUrl
                + '\''
                + ", mSubscriptionsUrl='" + mSubscriptionsUrl
                + '\''
                + ", mOrganizationsUrl='" + mOrganizationsUrl
                + '\''
                + ", mReposUrl='" + mReposUrl
                + '\''
                + ", mEventsUrl='" + mEventsUrl
                + '\''
                + ", mReceivedEventsUrl='" + mReceivedEventsUrl
                + '\''
                + ", mType='" + mType
                + '\''
                + ", mSiteAdmin=" + mSiteAdmin
                + ", mName='" + mName
                + '\''
                + ", mCompany='" + mCompany
                + '\''
                + ", mBlog='" + mBlog
                + '\''
                + ", mLocation='" + mLocation
                + '\''
                + ", mEmail='" + mEmail
                + '\''
                + ", mHireable='" + mHireable
                + '\''
                + ", mBio='" + mBio
                + '\''
                + ", mPublicRepos=" + mPublicRepos
                + ", mPublicGists=" + mPublicGists
                + ", mFollowers=" + mFollowers
                + ", mFollowing=" + mFollowing
                + ", mCreatedAt='" + mCreatedAt
                + '\''
                + ", mUpdatedAt='" + mUpdatedAt
                + '\''
                + ", mUsername='" + mUsername
                + '\''
                + '}';
    }
}
