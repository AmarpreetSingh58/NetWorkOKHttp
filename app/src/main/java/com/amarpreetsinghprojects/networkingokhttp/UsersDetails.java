package com.amarpreetsinghprojects.networkingokhttp;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by kulvi on 07/04/17.
 */

public class UsersDetails implements Serializable {
    
    String  username,
            id,
            profilelink,
            followers_url,
            following_url,
            gists_url,
            starred_url,
            subscriptions_url,
            organizations_url,
            repos_url,
            events_url,
            received_events_url,
            usertype,
            site_admin,
            score;
    Bitmap avatar;

    public UsersDetails(String username,
                        String id,
                        Bitmap avatar,
                        String profilelink,
                        String followers_url,
                        String following_url,
                        String gists_url,
                        String starred_url,
                        String subscriptions_url,
                        String organizations_url,
                        String repos_url,
                        String events_url,
                        String received_events_url,
                        String usertype,
                        String site_admin,
                        String score) {
        this.username = username;
        this.id = id;
        this.avatar = avatar;
        this.profilelink = profilelink;
        this.followers_url = followers_url;
        this.following_url = following_url;
        this.gists_url = gists_url;
        this.starred_url = starred_url;
        this.subscriptions_url = subscriptions_url;
        this.organizations_url = organizations_url;
        this.repos_url = repos_url;
        this.events_url = events_url;
        this.received_events_url = received_events_url;
        this.usertype = usertype;
        this.site_admin = site_admin;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Bitmap getAvatar(){
        return avatar;
    }

    public void setAvatar(Bitmap avatar){
        this.avatar = avatar;
    }

    public String getProfilelink() {
        return profilelink;
    }

    public void setProfilelink(String profilelink) {
        this.profilelink = profilelink;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getSite_admin() {
        return site_admin;
    }

    public void setSite_admin(String site_admin) {
        this.site_admin = site_admin;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
