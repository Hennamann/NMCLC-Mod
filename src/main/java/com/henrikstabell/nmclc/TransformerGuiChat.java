package com.henrikstabell.nmclc;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

/**
 * Modifies {@link net.minecraft.client.gui.GuiChat} to lowercase messages starting with a "/".
 * Should not cause any issues with other mods, unless they modify the same method.
 * Created by Hennamann(Ole Henrik Stabell) on 06/03/2018.
 */
public class TransformerGuiChat implements IClassTransformer {

    public static final String TARGET_CLASS = "net.minecraft.client.gui.GuiChat";
    public static final String TARGET_METHOD = "submitChatMessage";
    public static final String TARGET_METHOD_2 = "func_146403_a";
    public static final String TARGET_DESCRIPTOR = "(Ljava/lang/String;)V";

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (transformedName.equals(TARGET_CLASS)) {
            ClassNode cnode = createClassNode(bytes);

            boolean obf = NMCLCCoreMod.obfuscatedEnvironment;

            for (MethodNode method : cnode.methods) {
                if (method.name.equalsIgnoreCase(TARGET_METHOD) && method.desc.equalsIgnoreCase(TARGET_DESCRIPTOR) || method.name.equalsIgnoreCase(TARGET_METHOD_2) && method.desc.equalsIgnoreCase(TARGET_DESCRIPTOR)) {
                    System.out.println("Patching method " + TARGET_METHOD + " in class " + TARGET_CLASS);

                    // Remove original code
                    method.instructions.clear();

                    // Insert new code
                    method.visitCode();
                    Label l0 = new Label();
                    method.visitLabel(l0);
                    method.visitLineNumber(23, l0);
                    method.visitVarInsn(Opcodes.ALOAD, 1);
                    method.visitVarInsn(Opcodes.ASTORE, 2);
                    Label l1 = new Label();
                    method.visitLabel(l1);
                    method.visitLineNumber(24, l1);
                    method.visitVarInsn(Opcodes.ALOAD, 2);
                    method.visitLdcInsn("/");
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "startsWith", "(Ljava/lang/String;)Z", false);
                    Label l2 = new Label();
                    method.visitJumpInsn(Opcodes.IFEQ, l2);
                    Label l3 = new Label();
                    method.visitLabel(l3);
                    method.visitLineNumber(25, l3);
                    method.visitVarInsn(Opcodes.ALOAD, 2);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "toLowerCase", "()Ljava/lang/String;", false);
                    method.visitVarInsn(Opcodes.ASTORE, 3);
                    Label l4 = new Label();
                    method.visitLabel(l4);
                    method.visitLineNumber(26, l4);
                    method.visitVarInsn(Opcodes.ALOAD, 3);
                    method.visitVarInsn(Opcodes.ASTORE, 2);
                    method.visitLabel(l2);
                    method.visitLineNumber(28, l2);
                    method.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"java/lang/String"}, 0, null);
                    method.visitVarInsn(Opcodes.ALOAD, 0);
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/gui/GuiChat", obf ? "field_146297_k" : "mc", "Lnet/minecraft/client/Minecraft;");
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/Minecraft", obf ? "field_71456_v" : "ingameGUI", "Lnet/minecraft/client/gui/GuiIngame;");
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraft/client/gui/GuiIngame", obf ? "func_146158_b" : "getChatGUI", "()Lnet/minecraft/client/gui/GuiNewChat;", false);
                    method.visitVarInsn(Opcodes.ALOAD, 2);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraft/client/gui/GuiNewChat", obf ? "func_146239_a" : "addToSentMessages", "(Ljava/lang/String;)V", false);
                    Label l5 = new Label();
                    method.visitLabel(l5);
                    method.visitLineNumber(29, l5);
                    method.visitFieldInsn(Opcodes.GETSTATIC, "net/minecraftforge/client/ClientCommandHandler", "instance", "Lnet/minecraftforge/client/ClientCommandHandler;");
                    method.visitVarInsn(Opcodes.ALOAD, 0);
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/gui/GuiChat", obf ? "field_146297_k" : "mc", "Lnet/minecraft/client/Minecraft;");
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/Minecraft", obf ? "field_71439_g" : "thePlayer", "Lnet/minecraft/client/entity/EntityClientPlayerMP;");
                    method.visitVarInsn(Opcodes.ALOAD, 2);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraftforge/client/ClientCommandHandler", obf ? "func_71556_a" : "executeCommand", "(Lnet/minecraft/command/ICommandSender;Ljava/lang/String;)I", false);
                    Label l6 = new Label();
                    method.visitJumpInsn(Opcodes.IFEQ, l6);
                    method.visitInsn(Opcodes.RETURN);
                    method.visitLabel(l6);
                    method.visitLineNumber(30, l6);
                    method.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
                    method.visitVarInsn(Opcodes.ALOAD, 0);
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/gui/GuiChat", obf ? "field_146297_k" : "mc", "Lnet/minecraft/client/Minecraft;");
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/Minecraft", obf ? "field_71439_g" : "thePlayer", "Lnet/minecraft/client/entity/EntityClientPlayerMP;");
                    method.visitVarInsn(Opcodes.ALOAD, 2);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraft/client/entity/EntityClientPlayerMP", obf ? "func_71165_d" : "sendChatMessage", "(Ljava/lang/String;)V", false);
                    Label l7 = new Label();
                    method.visitLabel(l7);
                    method.visitLineNumber(31, l7);
                    method.visitInsn(Opcodes.RETURN);
                    Label l8 = new Label();
                    method.visitLabel(l8);
                    method.visitLocalVariable("lowerCapsMessage", "Ljava/lang/String;", null, l4, l2, 3);
                    method.visitLocalVariable("this", "Lnet/minecraft/client/gui/GuiChat;", null, l0, l4, 0);
                    method.visitLocalVariable("p_146403_1_", "Ljava/lang/String;", null, l0, l8, 1);
                    method.visitLocalVariable("message", "Ljava/lang/String;", null, l1, l8, 2);
                    method.visitMaxs(3, 4);
                    method.visitEnd();

                    System.out.println("Finished patching method " + TARGET_METHOD + " in class " + TARGET_CLASS);
                }
            }
            return createBytes(cnode);
        }
        return bytes;
    }

    public static ClassNode createClassNode(byte[] bytes) {
        ClassNode cnode = new ClassNode();
        ClassReader reader = new ClassReader(bytes);
        reader.accept(cnode, 0);
        return cnode;
    }

    public static byte[] createBytes(ClassNode cnode) {
        ClassWriter cw = new ClassWriter(0);
        cnode.accept(cw);
        return cw.toByteArray();
    }
}