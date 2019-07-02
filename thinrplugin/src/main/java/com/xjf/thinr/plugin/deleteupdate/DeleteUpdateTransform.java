package com.xjf.thinr.plugin.deleteupdate;

import com.quinn.hunter.transform.HunterTransform;
import org.gradle.api.Project;

/**
 * description: 删除R.class中文件和替换class文件R.id字段
 *
 * @author xuejingfei
 * create at 19-7-2
 */
public class DeleteUpdateTransform extends HunterTransform {
    public DeleteUpdateTransform(Project project) {
        super(project);
        this.bytecodeWeaver = new DeleteUpdateWeaver();
    }
}
