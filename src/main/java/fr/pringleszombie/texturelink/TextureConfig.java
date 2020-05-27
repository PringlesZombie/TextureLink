package fr.pringleszombie.texturelink;

public class TextureConfig {

    private String prefix;
    private String link;
    private String suffix;

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
