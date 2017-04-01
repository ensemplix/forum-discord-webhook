package ru.ensemplix.discord.forum.post;

public class PostMessage {

    private final String title;
    private final String text;
    private final String postUrl;

    public PostMessage(String title, String text, String postUrl) {
        this.title = title;
        this.text = text;
        this.postUrl = postUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getPostUrl() {
        return postUrl;
    }

}
