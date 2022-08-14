package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        webview.webViewClient = object : WebViewClient() {
            // sobrepor o carregamento da url. Sem essa manipulação abaixo,
            // o apliativo abre o navegador do sistema
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                if (request?.url != null) {
                    view?.loadUrl((request?.url.toString()))
                }
                return true
            }
        }
        // habilta o javascript da webview
        webview.settings.javaScriptEnabled = true

        // definindo a url a ser carregada
        webview.loadUrl("https://www.fiap.com.br/")

    }
}