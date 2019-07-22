package br.com.livroandroid.autoponiateste.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import br.com.livroandroid.autoponiateste.R;

public class SiteAutoponia extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_autoponia);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://www.autoponia.com.br/");

    }
}
