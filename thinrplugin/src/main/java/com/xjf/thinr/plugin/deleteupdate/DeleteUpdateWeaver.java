package com.xjf.thinr.plugin.deleteupdate;

import com.quinn.hunter.transform.asm.BaseWeaver;
import com.xjf.thinr.plugin.ScanSetting;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * description: 专家个人信息界面
 *
 * @author xuejingfei
 * create at 19-7-2
 */
public class DeleteUpdateWeaver extends BaseWeaver {

    @Override
    protected ClassVisitor wrapClassWriter(ClassWriter classWriter) {
        return new DeleteUpdateAdapter(Opcodes.ASM5,classWriter);
    }

    @Override
    public boolean isWeavableClass(String fullQualifiedClassName) {
        return fullQualifiedClassName.endsWith(".class") && !fullQualifiedClassName.contains("BuildConfig.class");
    }
}
