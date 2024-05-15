package net.flamevamp.johnmod.entity.client;

import net.flamevamp.johnmod.JohnMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import javax.swing.text.html.parser.Entity;

public class ModModelLayers {
    public static final EntityModelLayer NOSE =
            new EntityModelLayer(new Identifier(JohnMod.MOD_ID, "nose"), "main");

    public static final EntityModelLayer WITCH_NOSE =
            new EntityModelLayer(new Identifier(JohnMod.MOD_ID, "witch_nose"), "main");

    public static final EntityModelLayer JOHN =
            new EntityModelLayer(new Identifier(JohnMod.MOD_ID, "john"), "main");
}
