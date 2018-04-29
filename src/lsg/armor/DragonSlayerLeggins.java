package lsg.armor;

import lsg.bags.Collectible.Collectible;

public class DragonSlayerLeggins extends ArmorItem implements Collectible{
    public DragonSlayerLeggins() {
        super("Dragon Slayer Leggins", (float)10.2);
    }

    public int getWeight() {
        return 3;
    }
}
