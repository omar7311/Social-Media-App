package com.example.socialmediaapp;

public class ChatModel {
    int userImageChat;
    String userNameChat;




    public ChatModel(int userImageChat, String userNameChat) {
        this.userImageChat = userImageChat;
        this.userNameChat = userNameChat;
    }


    public int getUserImageChat() {
        return userImageChat;
    }

    public String getUserNameChat() {
        return userNameChat;
    }
}
