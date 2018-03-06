package com.henrikstabell.nmclc;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

/**
 * Modifies {@link net.minecraft.client.gui.GuiScreen} to lowercase messages starting with a "/".
 * Should not cause any issues with other mods, unless they modify the same method.
 * Created by Hennamann(Ole Henrik Stabell) on 06/03/2018.
 */
public class TransformerGuiScreen implements IClassTransformer {

    public static final String TARGET_CLASS = "net.minecraft.client.gui.GuiScreen";
    public static final String TARGET_METHOD = "sendChatMessage";
    public static final String TARGET_METHOD_2 = "func_175275_f";
    public static final String TARGET_DESCRIPTOR = "(Ljava/lang/String;Z)V";

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (transformedName.equals(TARGET_CLASS)) {
            ClassNode cnode = createClassNode(bytes);

            for (MethodNode method : cnode.methods) {
                if (method.name.equalsIgnoreCase(TARGET_METHOD) && method.desc.equalsIgnoreCase(TARGET_DESCRIPTOR) || method.name.equalsIgnoreCase(TARGET_METHOD_2) && method.desc.equalsIgnoreCase(TARGET_DESCRIPTOR)) {
                    System.out.println("Patching method " + TARGET_METHOD + " in class " + TARGET_CLASS);

                    // Remove original code
                    method.instructions.clear();

                    // Insert new code
                    method.visitCode();
                    Label l0 = new Label();
                    method.visitLabel(l0);
                    method.visitLineNumber(22, l0);
                    method.visitVarInsn(Opcodes.ALOAD, 1);
                    method.visitVarInsn(Opcodes.ASTORE, 3);
                    Label l1 = new Label();
                    method.visitLabel(l1);
                    method.visitLineNumber(24, l1);
                    method.visitVarInsn(Opcodes.ALOAD, 3);
                    method.visitLdcInsn("/");
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "startsWith", "(Ljava/lang/String;)Z", false);
                    Label l2 = new Label();
                    method.visitJumpInsn(Opcodes.IFEQ, l2);
                    Label l3 = new Label();
                    method.visitLabel(l3);
                    method.visitLineNumber(25, l3);
                    method.visitVarInsn(Opcodes.ALOAD, 3);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "toLowerCase", "()Ljava/lang/String;", false);
                    method.visitVarInsn(Opcodes.ASTORE, 4);
                    Label l4 = new Label();
                    method.visitLabel(l4);
                    method.visitLineNumber(26, l4);
                    method.visitVarInsn(Opcodes.ALOAD, 4);
                    method.visitVarInsn(Opcodes.ASTORE, 3);
                    method.visitLabel(l2);
                    method.visitLineNumber(28, l2);
                    method.visitFrame(Opcodes.F_APPEND, 1, new Object[]{"java/lang/String"}, 0, null);
                    method.visitVarInsn(Opcodes.ILOAD, 2);
                    Label l5 = new Label();
                    method.visitJumpInsn(Opcodes.IFEQ, l5);
                    Label l6 = new Label();
                    method.visitLabel(l6);
                    method.visitLineNumber(29, l6);
                    method.visitVarInsn(Opcodes.ALOAD, 0);
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/gui/GuiScreen", "mc", "Lnet/minecraft/client/Minecraft;");
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/Minecraft", "ingameGUI", "Lnet/minecraft/client/gui/GuiIngame;");
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraft/client/gui/GuiIngame", "getChatGUI", "()Lnet/minecraft/client/gui/GuiNewChat;", false);
                    method.visitVarInsn(Opcodes.ALOAD, 3);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraft/client/gui/GuiNewChat", "addToSentMessages", "(Ljava/lang/String;)V", false);
                    method.visitLabel(l5);
                    method.visitLineNumber(31, l5);
                    method.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
                    method.visitFieldInsn(Opcodes.GETSTATIC, "net/minecraftforge/client/ClientCommandHandler", "instance", "Lnet/minecraftforge/client/ClientCommandHandler;");
                    method.visitVarInsn(Opcodes.ALOAD, 0);
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/gui/GuiScreen", "mc", "Lnet/minecraft/client/Minecraft;");
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/Minecraft", "thePlayer", "Lnet/minecraft/client/entity/EntityPlayerSP;");
                    method.visitVarInsn(Opcodes.ALOAD, 3);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraftforge/client/ClientCommandHandler", "executeCommand", "(Lnet/minecraft/command/ICommandSender;Ljava/lang/String;)I", false);
                    Label l7 = new Label();
                    method.visitJumpInsn(Opcodes.IFEQ, l7);
                    method.visitInsn(Opcodes.RETURN);
                    method.visitLabel(l7);
                    method.visitLineNumber(33, l7);
                    method.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
                    method.visitVarInsn(Opcodes.ALOAD, 0);
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/gui/GuiScreen", "mc", "Lnet/minecraft/client/Minecraft;");
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/client/Minecraft", "thePlayer", "Lnet/minecraft/client/entity/EntityPlayerSP;");
                    method.visitVarInsn(Opcodes.ALOAD, 3);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraft/client/entity/EntityPlayerSP", "sendChatMessage", "(Ljava/lang/String;)V", false);
                    Label l8 = new Label();
                    method.visitLabel(l8);
                    method.visitLineNumber(34, l8);
                    method.visitInsn(Opcodes.RETURN);
                    Label l9 = new Label();
                    method.visitLabel(l9);
                    method.visitLocalVariable("lowerCapsMessage", "Ljava/lang/String;", null, l4, l2, 4);
                    method.visitLocalVariable("this", "Lnet/minecraft/client/gui/GuiScreen;", null, l0, l9, 0);
                    method.visitLocalVariable("msg", "Ljava/lang/String;", null, l0, l9, 1);
                    method.visitLocalVariable("addToChat", "Z", null, l0, l9, 2);
                    method.visitLocalVariable("message", "Ljava/lang/String;", null, l1, l9, 3);
                    method.visitMaxs(3, 5);
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