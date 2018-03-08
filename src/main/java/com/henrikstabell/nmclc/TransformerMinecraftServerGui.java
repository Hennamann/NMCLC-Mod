package com.henrikstabell.nmclc;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

/**
 * Modifies {@link net.minecraft.server.gui.MinecraftServerGui} to lowercase commands that are uppercase.
 * Should not cause any issues with other mods, unless they modify the same method (Which is highly unlikely).
 * Created by Hennamann(Ole Henrik Stabell) on 07/03/2018.
 */
public class TransformerMinecraftServerGui implements IClassTransformer {

    public static final String TARGET_INNER_CLASS = "net.minecraft.server.gui.MinecraftServerGui$2";
    public static final String TARGET_METHOD = "actionPerformed";

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (transformedName.equals(TARGET_INNER_CLASS)) {
            ClassNode cnode = createClassNode(bytes);

            boolean obf = NMCLCCoreMod.obfuscatedEnvironment;

            for (MethodNode method : cnode.methods) {
                if (method.name.equalsIgnoreCase(TARGET_METHOD)) {
                    System.out.println("Patching method " + TARGET_METHOD + " in class " + TARGET_INNER_CLASS);

                    // Remove original code
                    method.instructions.clear();

                    // Insert new code
                    method.visitCode();
                    Label l0 = new Label();
                    method.visitLabel(l0);
                    method.visitLineNumber(42, l0);
                    method.visitVarInsn(Opcodes.ALOAD, 0);
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/server/gui/MinecraftServerGui$2", "val$jtextfield", "Ljavax/swing/JTextField;");
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "javax/swing/JTextField", "getText", "()Ljava/lang/String;", false);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "trim", "()Ljava/lang/String;", false);
                    method.visitVarInsn(Opcodes.ASTORE, 2);
                    Label l1 = new Label();
                    method.visitLabel(l1);
                    method.visitLineNumber(43, l1);
                    method.visitVarInsn(Opcodes.ALOAD, 0);
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/server/gui/MinecraftServerGui$2", "val$jtextfield", "Ljavax/swing/JTextField;");
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "javax/swing/JTextField", "getText", "()Ljava/lang/String;", false);
                    method.visitVarInsn(Opcodes.ASTORE, 3);
                    Label l2 = new Label();
                    method.visitLabel(l2);
                    method.visitLineNumber(44, l2);
                    method.visitVarInsn(Opcodes.ALOAD, 3);
                    method.visitMethodInsn(Opcodes.INVOKESTATIC, "org/apache/commons/lang3/StringUtils", "isAllUpperCase", "(Ljava/lang/CharSequence;)Z", false);
                    Label l3 = new Label();
                    method.visitJumpInsn(Opcodes.IFEQ, l3);
                    Label l4 = new Label();
                    method.visitLabel(l4);
                    method.visitLineNumber(45, l4);
                    method.visitVarInsn(Opcodes.ALOAD, 3);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "toLowerCase", "()Ljava/lang/String;", false);
                    method.visitVarInsn(Opcodes.ASTORE, 4);
                    Label l5 = new Label();
                    method.visitLabel(l5);
                    method.visitLineNumber(46, l5);
                    method.visitVarInsn(Opcodes.ALOAD, 4);
                    method.visitVarInsn(Opcodes.ASTORE, 2);
                    method.visitLabel(l3);
                    method.visitLineNumber(48, l3);
                    method.visitFrame(Opcodes.F_APPEND, 2, new Object[]{"java/lang/String", "java/lang/String"}, 0, null);
                    method.visitVarInsn(Opcodes.ALOAD, 2);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "isEmpty", "()Z", false);
                    Label l6 = new Label();
                    method.visitJumpInsn(Opcodes.IFNE, l6);
                    Label l7 = new Label();
                    method.visitLabel(l7);
                    method.visitLineNumber(49, l7);
                    method.visitVarInsn(Opcodes.ALOAD, 0);
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/server/gui/MinecraftServerGui$2", "this$0", "Lnet/minecraft/server/gui/MinecraftServerGui;");
                    method.visitMethodInsn(Opcodes.INVOKESTATIC, "net/minecraft/server/gui/MinecraftServerGui", "access$000", "(Lnet/minecraft/server/gui/MinecraftServerGui;)Lnet/minecraft/server/dedicated/DedicatedServer;", false);
                    method.visitVarInsn(Opcodes.ALOAD, 2);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "trim", "()Ljava/lang/String;", false);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/String", "toLowerCase", "()Ljava/lang/String;", false);
                    method.visitVarInsn(Opcodes.ALOAD, 0);
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/server/gui/MinecraftServerGui$2", "this$0", "Lnet/minecraft/server/gui/MinecraftServerGui;");
                    method.visitMethodInsn(Opcodes.INVOKESTATIC, "net/minecraft/server/gui/MinecraftServerGui", "access$000", "(Lnet/minecraft/server/gui/MinecraftServerGui;)Lnet/minecraft/server/dedicated/DedicatedServer;", false);
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "net/minecraft/server/dedicated/DedicatedServer", obf ? "func_71331_a" : "addPendingCommand", "(Ljava/lang/String;Lnet/minecraft/command/ICommandSender;)V", false);
                    method.visitLabel(l6);
                    method.visitLineNumber(51, l6);
                    method.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
                    method.visitVarInsn(Opcodes.ALOAD, 0);
                    method.visitFieldInsn(Opcodes.GETFIELD, "net/minecraft/server/gui/MinecraftServerGui$2", "val$jtextfield", "Ljavax/swing/JTextField;");
                    method.visitLdcInsn("");
                    method.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "javax/swing/JTextField", "setText", "(Ljava/lang/String;)V", false);
                    Label l8 = new Label();
                    method.visitLabel(l8);
                    method.visitLineNumber(52, l8);
                    method.visitInsn(Opcodes.RETURN);
                    Label l9 = new Label();
                    method.visitLabel(l9);
                    method.visitLocalVariable("lowerCapsMessage", "Ljava/lang/String;", null, l5, l3, 4);
                    method.visitLocalVariable("this$0", "Lnet/minecraft/server/gui/MinecraftServerGui$2;", null, l0, l5, 0);
                    method.visitLocalVariable("p_actionPerformed_1_$0", "Ljava/awt/event/ActionEvent;", null, l0, l9, 1);
                    method.visitLocalVariable("s$0", "Ljava/lang/String;", null, l1, l9, 2);
                    method.visitLocalVariable("msg", "Ljava/lang/String;", null, l2, l9, 3);
                    method.visitMaxs(3, 5);
                    method.visitEnd();

                    System.out.println("Finished patching method " + TARGET_METHOD + " in class " + TARGET_INNER_CLASS);
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