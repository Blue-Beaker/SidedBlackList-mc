package io.bluebeaker.sidedblacklist;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import zone.rong.mixinbooter.ILateMixinLoader;

public class SidedBlacklistMixins implements ILateMixinLoader {

    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.sidedblacklist.json");
    }
}
