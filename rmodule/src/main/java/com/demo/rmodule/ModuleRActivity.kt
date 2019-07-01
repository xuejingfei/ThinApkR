package com.demo.rmodule

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_module_a.*

class ModuleRActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_a)
        tv_test.text = getText(R.string.test_name)
    }

    companion object{
        @JvmStatic
        fun gotoActivity(context: Context) {
            val intent = Intent(context,ModuleRActivity::class.java)
            context.startActivity(intent)
        }
    }
}
