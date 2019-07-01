package com.demo.thinr

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.demo.rmodule.ModuleRActivity
import kotlinx.android.synthetic.main.activity_test_r.*

/**
 * Author：xuejingfei
 *
 * Description：
 *
 * Date：2019-06-30 22:45
 */
@Suppress("JAVA_CLASS_ON_COMPANION")
class TestRActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_r)
        tv_r.text = getString(R.string.test_r)
        tv_r.setOnClickListener{(
                ModuleRActivity.gotoActivity(this)
                )}
        }



    companion object{
        @JvmStatic
         fun gotoActivity(context: Context) {
             val intent = Intent(context,TestRActivity::class.java)
             context.startActivity(intent)
         }
    }

}