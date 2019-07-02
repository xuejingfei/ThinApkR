package com.xjf.thinr.plugin;

import com.android.build.gradle.AppExtension;
import com.xjf.thinr.plugin.findclass.FindRClassTransform;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * description: ThinApkRPlugin插件
 *
 * @author xuejingfei
 * create at 19-7-2
 */
public class ThinApkRPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        System.out.println("---this is ThinApkRPlugin----");
        AppExtension extension =  (AppExtension) project.getProperties().get("android");
        extension.registerTransform(new FindRClassTransform(project));
    }
}
