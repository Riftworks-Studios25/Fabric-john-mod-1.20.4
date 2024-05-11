package net.flamevamp.testmod.entity.client;

import net.flamevamp.testmod.TestMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

import javax.swing.text.html.parser.Entity;

public class ModModelLayers {
    public static final EntityModelLayer NOSE =
            new EntityModelLayer(new Identifier(TestMod.MOD_ID, "nose"), "main");

    public static final EntityModelLayer JOHN =
            new EntityModelLayer(new Identifier(TestMod.MOD_ID, "john"), "main");
}
