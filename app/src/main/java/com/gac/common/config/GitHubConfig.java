package com.gac.common.config;


import com.gac.BuildConfig;

/**
 * GitHub config
 * Created by spencer on 10/17/16.
 */
public interface GitHubConfig {

    String CLIENT_ID = BuildConfig.GITHUB_CLIENT_ID;
    String CLIENT_SECRET = BuildConfig.GITHUB_SECRET;
    String[] SCOPES = {"user", "repo", "notifications", "gist", "admin:org"};
    String NOTE = "GitHub-Android-Client";

}
