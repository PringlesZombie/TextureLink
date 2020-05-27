package fr.pringleszombie.texturelink;

public class TextureConfig {

    private final String prefix;
    private final String link;
    private final String suffix;

    public TextureConfig(String prefix, String link, String suffix) {
        this.prefix = prefix;
        this.link = link;
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getLink() {
        return link;
    }
}
