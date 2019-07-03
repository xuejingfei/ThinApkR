package com.xjf.thinr.plugin.deleteupdate;

import com.xjf.thinr.plugin.ScanSetting;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * description:
 * ClassVisitor : 主要负责拜访类的成员信息：包括标记类上的注解，类的构造方法，类的字段，类的方法和静态代码块
 * @author xuejingfei
 * create at 19-7-2
 */
public class DeleteUpdateAdapter extends ClassVisitor {
    private boolean isRClass = false;

    public DeleteUpdateAdapter(int api, ClassVisitor cv) {
        super(api, cv);
    }


    /**
     * 扫描类的一个拜访方法
     * @param version jdk 版本
     * @param access 类的修饰符
     * @param name 类的名称，字节码中以路径的形式表示，如a/b/c/MyClass
     * @param signature  泛型信息
     * @param superName 所继承的父类
     * @param interfaces 表示类的接口，是一个数组
     */
    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        isRClass = ScanSetting.isRClass(name+".class");
        if(isRClass){
            System.out.println("寻找的R.class的文件"+name);
        }
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if (isRClass && value instanceof Integer) {
            return null;
        }
        return super.visitField(access, name, desc, signature, value);
    }


    /**
     * 当扫描器扫描到类的方法时调用，
     * @param access 类的修饰符
     * @param name 方法名
     * @param desc 方法签名  格式为："（参数列表）返回值类型" （）
     * @param signature
     * @param exceptions
     * @return
     */
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = super.visitMethod(access, name, desc, signature, exceptions);
        if(!isRClass) {
            return new UpdateClassAdapter(name,access,desc,methodVisitor);
        }
        return methodVisitor;
    }


}
