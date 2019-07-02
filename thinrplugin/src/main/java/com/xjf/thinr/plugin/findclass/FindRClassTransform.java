package com.xjf.thinr.plugin.findclass;

import com.quinn.hunter.transform.HunterTransform;
import org.gradle.api.Project;

/**
 * description: 编译中寻找所有module中R.class文件，
 *
 * @author xuejingfei
 * create at 19-7-2
 */
public class FindRClassTransform extends HunterTransform {

    public FindRClassTransform(Project project) {
        super(project);
        this.bytecodeWeaver = new FindClassWeaver();
    }
}
