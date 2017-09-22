/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.asmtojavassist;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Java asm 和 Javassist
 * ASM是一个java字节码操纵框架，它能被用来动态生成类或者增强既有类的功能。
 * ASM 可以直接产生二进制 class 文件，也可以在类被加载入 Java 虚拟机之前动态改变类行为。
 * Java class 被存储在严格格式定义的 .class文件里，这些类文件拥有足够的元数据来解析类中的所有元素：
 * 类名称、方法、属性以及 Java 字节码（指令）。ASM从类文件中读入信息后，能够改变类行为，分析类信息，
 * 甚至能够根据用户要求生成新类。
 * 
 * ASM框架中的核心类有以下几个：
 *　1. ClassReader:该类用来解析编译过的class字节码文件。
 *　2. ClassWriter:该类用来重新构建编译后的类，比如说修改类名、属性以及方法，甚至可以生成新的类的字节码文件。
 *　3. ClassAdapter:该类也实现了ClassVisitor接口，它将对它的方法调用委托给另一个ClassVisitor对象。
 * @author wxh
 * @version $Id: GeneratorClass.java, v 0.1 2017年9月8日 下午4:38:42 wxh Exp $
 */
public class GeneratorClass {

    /**
     * 通过asm生成类的字节码
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        // 生成一个类只需要ClassWriter组件即可 
        ClassWriter classWriter = new ClassWriter(0);
        // 通过visit方法确定类的头部信息
        classWriter.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT
                                        + Opcodes.ACC_INTERFACE,
            "com/wxh/asmtojavassist/HelloWorld", null, "java/lang/Object", null);

        MethodVisitor helloVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "sayHello",
            "()V;", null, null);
        helloVisitor.visitCode();
        helloVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out",
            "Ljava/io/PrintStream;");
        helloVisitor.visitLdcInsn("hello world!");
        helloVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println",
            "(Ljava/lang/String;)V");
        helloVisitor.visitInsn(Opcodes.RETURN);
        helloVisitor.visitMaxs(1, 1);
        helloVisitor.visitEnd();

        // 使classWriter类已经完成
        classWriter.visitEnd();

        // 转换成字节数组写入文件里
        byte[] code = classWriter.toByteArray();
        File file = new File(
            "D:\\github\\web\\WebRoot\\WEB-INF\\classes\\com\\wxh\\asmtojavassist\\HelloWorld.class");
        FileOutputStream output = new FileOutputStream(file);
        output.write(code);
        output.close();
    }
}
