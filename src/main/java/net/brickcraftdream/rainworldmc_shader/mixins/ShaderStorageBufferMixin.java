package net.brickcraftdream.rainworldmc_shader.mixins;

import net.irisshaders.iris.gl.buffer.BuiltShaderStorageInfo;
import net.irisshaders.iris.gl.buffer.ShaderStorageBuffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ShaderStorageBuffer.class, remap = false)
public class ShaderStorageBufferMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInit(int index, BuiltShaderStorageInfo info, CallbackInfo ci) {
        ShaderStorageBuffer self = (ShaderStorageBuffer) (Object) this;

        int bufferId = self.getId();

        System.out.println("[Mixin] Created ShaderStorageBuffer with ID = " + bufferId + " at index " + index);
    }
}
