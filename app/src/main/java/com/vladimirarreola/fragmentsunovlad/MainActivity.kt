package com.vladimirarreola.fragmentsunovlad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.vladimirarreola.fragmentsunovlad.fragmentos.FragmentSegundo
import com.vladimirarreola.fragmentsunovlad.fragmentos.PrimerFragment
import com.vladimirarreola.fragmentsunovlad.fragmentos.TercerFragment

class MainActivity : AppCompatActivity() {
    lateinit var btnFragmento1:Button
    lateinit var btnFragmento2:Button
    lateinit var btnFragmento3:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFragmento1 = findViewById(R.id.btnf1)
        btnFragmento2 = findViewById(R.id.btnf2)
        btnFragmento3 = findViewById(R.id.btnf3)

        btnFragmento1.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, PrimerFragment.newInstance("first", "dsf"))
                .commitNow()
        }

        btnFragmento2.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, FragmentSegundo.newInstance("second", "dsf"))
                .commitNow()
        }

        btnFragmento3.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameContainer, TercerFragment.newInstance("third", "dsf"))
                .commitNow()
        }

    }
}