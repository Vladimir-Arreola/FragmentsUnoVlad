package com.vladimirarreola.fragmentsunovlad.fragmentos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import com.vladimirarreola.fragmentsunovlad.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val DEFAULT_URL = "urlPorDefault"

/**
 * A simple [Fragment] subclass.
 * Use the [NavegadorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NavegadorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var url: String? = null
    lateinit var wvNavegador:WebView
    lateinit var btnIr:Button
    lateinit var etUrl:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(DEFAULT_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("url", url!!)
        val vistaNavigator = inflater.inflate(R.layout.fragment_navegador, container, false)

        wvNavegador = vistaNavigator.findViewById(R.id.wvNavigator)
        btnIr = vistaNavigator.findViewById(R.id.btnIr)
        etUrl = vistaNavigator.findViewById(R.id.etUrl)

        val webSettings = wvNavegador.settings
        webSettings.javaScriptEnabled = true

        wvNavegador.webViewClient = object : WebViewClient(){}

        wvNavegador.webViewClient = object : WebViewClient(){

        }

        btnIr.setOnClickListener{
            url = etUrl.text.toString().trim()
            if(!url!!.isEmpty()){
                url = "https://" + url
                wvNavegador.loadUrl(url!!)
            }
        }

        return vistaNavigator
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param url por default.
         * @return A new instance of fragment NavegadorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(urlPorDefault: String) =
            NavegadorFragment().apply {
                arguments = Bundle().apply {
                    putString(DEFAULT_URL, urlPorDefault)
                }
            }
    }
}