package net.fabricmc.example.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class ExampleMixin {

    @Inject(method = "shouldRender(D)Z", at = @At("HEAD"), cancellable = true)
    private void disableLagEntities(double distance, CallbackInfoReturnable<Boolean> cir) {
        Entity entity = (Entity) (Object) this;
        if (entity instanceof ItemEntity || entity instanceof ArmorStandEntity) {
            cir.setReturnValue(false);
        }
    }
}
