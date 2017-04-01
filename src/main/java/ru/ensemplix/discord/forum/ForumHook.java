package ru.ensemplix.discord.forum;

import ru.ensemplix.discord.DiscordEmbed;
import ru.ensemplix.discord.DiscordEmbedBuilder;
import ru.ensemplix.discord.DiscordHook;
import ru.ensemplix.discord.DiscordMessageBuilder;
import ru.ensemplix.discord.forum.post.PostAuthor;
import ru.ensemplix.discord.forum.post.PostMessage;
import ru.ensemplix.discord.forum.post.PostPartition;

import java.awt.*;

public class ForumHook {

    private static final Color THREAD_COLOR = new Color(77, 231 ,46);
    private static final Color POST_COLOR = new Color(248, 163, 43);

    private final DiscordHook discordHook;

    public ForumHook(String url) {
        this.discordHook = new DiscordHook(url);
    }

    public void newThread(PostPartition partition, PostAuthor author, PostMessage message) {
        send("Новая тема", THREAD_COLOR, partition, author, message);
    }

    public void newPost(PostPartition partition, PostAuthor author, PostMessage message) {
        send("Ответ", POST_COLOR, partition, author, message);
    }

    private void send(String action, Color color, PostPartition partition, PostAuthor author, PostMessage message) {
        String text = message.getText();

        if(text.length() > 500) {
            text = text.substring(0, 500) + "...";
        }

        DiscordEmbed embed = DiscordEmbedBuilder.newBuilder()
                .setColor(color)
                .setUrl(message.getPostUrl())
                .setTitle(action + ": " + message.getTitle())
                .setDescription(text)
                .setAuthor(partition.getName(), partition.getUrl(), partition.getAvatarUrl())
                .setFooter(author.getName(), author.getAvatarUrl())
                .build();

        discordHook.sendMessage(DiscordMessageBuilder.newBuilder()
                .embed(embed)
                .build());
    }

}
