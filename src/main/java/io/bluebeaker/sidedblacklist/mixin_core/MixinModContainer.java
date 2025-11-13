package io.bluebeaker.sidedblacklist.mixin_core;

import io.bluebeaker.sidedblacklist.ConfigManager;
import io.bluebeaker.sidedblacklist.SidedBlacklistMod;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLModContainer;
import net.minecraftforge.fml.relauncher.Side;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.logging.Level;

@Mixin(value = FMLModContainer.class,remap = false)
public abstract class MixinModContainer {
    @Shadow public abstract String getModId();

    @Inject(method = "shouldLoadInEnvironment",at = @At("HEAD"),cancellable = true)
    private void setDisabled(CallbackInfoReturnable<Boolean> cir){
        Side side = FMLCommonHandler.instance().getSide();
        String modId = getModId();

        if((side==Side.CLIENT && Arrays.asList(ConfigManager.config.blacklist_client).contains(modId))
        || (side==Side.SERVER && Arrays.asList(ConfigManager.config.blacklist_server).contains(modId))){
            SidedBlacklistMod.getLogger().log(Level.INFO,"Mod "+modId+" won't be loaded on "+side+" side because it's on the blacklist!");
            cir.setReturnValue(false);
        }
    }
}
