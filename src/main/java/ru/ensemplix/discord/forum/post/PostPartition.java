package ru.ensemplix.discord.forum.post;

public class PostPartition {

    private final String name;
    private final String url;
    private final String avatarUrl;

    public PostPartition(String name, String url, String avatarUrl) {
        this.name = name;
        this.url = url;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

}
