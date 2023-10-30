package com.example.socialmediaapp;

public class PostModel {
    int userImage,postImage;
    String postCaption,userName;

    public PostModel(int userImage, int postImage, String postCaption, String userName) {
        this.userImage = userImage;
        this.postImage = postImage;
        this.postCaption = postCaption;
        this.userName = userName;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public int getPostImage() {
        return postImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public String getPostCaption() {
        return postCaption;
    }

    public void setPostCaption(String postCaption) {
        this.postCaption = postCaption;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
