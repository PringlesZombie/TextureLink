# TextureLink
It's a simple plugin Minecraft to provide pack ressource links to players.

# Commands

#### /texture
* __permission__: default
* Provide the different links for the texture.

--------------------

#### /texturelink reload
* __permission__: op
* Reload the config file.

# Configuration

```

# Default Message
message: "&eVoici les liens des packs de ressources :&f"


# Here, you can add link. To achieve this, you can follow the syntax:
# <name of section>: (Whatever)
#   prefix:  (before the link)
#   link:    (the link)
#   suffix:  (after the link)
links:
  default:
    prefix: "- "
    link: "&chttp://www.google.fr"
    suffix: " &f(Face Truc)"
  anotherlink:
    prefix: "- "
    link: "&chttp://www.google.com"
    suffix: " &f(Face Truc)"


```
