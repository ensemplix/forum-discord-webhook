package ru.ensemplix.discord.forum.post;

public class PostAuthor {

    private final String name;
    private final String avatarUrl;

    public PostAuthor(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

}
