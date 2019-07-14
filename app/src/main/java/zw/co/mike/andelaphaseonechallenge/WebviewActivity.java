package zw.co.mike.andelaphaseonechallenge;

import android.net.http.SslError;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebviewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ActionBar appBar=  getSupportActionBar();
        if(appBar!=null){
            appBar.setDisplayHomeAsUpEnabled(true);
            appBar.setTitle("About ALC");
        }

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(
                new SSLTolerentWebViewClient()
        );
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://andela.com/alc/");

    }

    private class SSLTolerentWebViewClient extends WebViewClient {

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
