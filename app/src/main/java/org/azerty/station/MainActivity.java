package org.azerty.station;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //선언부
    WebView webview = (WebView) findViewById(R.id.webview);
    Button button = (Button) findViewById(R.id.button2);
    EditText edittext = (EditText) findViewById(R.id.editText);

    String coach;
    private String[] items = {"Google", "Yahoo", "Bing", "DuckDuckGo", "Wikipedia", "Naver"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 웹뷰 속성
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        webview.setWebViewClient(new MyWebViewClient());

        // 일반적인 클릭 시에는 검색 엔진 설정 후 검색
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("검색 엔진 선택");
                builder.setItems(items, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // 검색 엔진 선택
                        coach = items[i].toString();
                        edittext.setText(coach);
                        Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                // 검색 실행
                if (coach == "Google") {
                    webview.loadUrl("https://www.google.com/search?site=&source=hp&ei=SqfOVpH4GKKxmAW3sYGYCQ&q=" + edittext.getText());
                }
                else if (coach == "Yahoo") {
                    webview.loadUrl("https://search.yahoo.com/mobile/s?p=" + edittext.getText());
                }
                else if (coach == "Bing") {
                    webview.loadUrl("http://www.bing.com/search?q=" + edittext.getText());
                }
                else if (coach == "DuckDuckGo") {
                    webview.loadUrl("https://duckduckgo.com/?q=" + edittext.getText());
                }
                else if (coach == "Wikipedia") {
                    webview.loadUrl("https://ko.m.wikipedia.org/wiki/" + edittext.getText());
                }
                else if (coach == "Naver") {
                    webview.loadUrl("https://m.search.naver.com/search.naver?sm=top_hty&where=m&ie=utf8&query=" + edittext.getText());
                }
            }
        });

        // 롱클릭 시에는 바로 검색
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (coach == "Google") {
                    webview.loadUrl("https://www.google.com/search?site=&source=hp&ei=SqfOVpH4GKKxmAW3sYGYCQ&q=" + edittext.getText());
                }
                else if (coach == "Yahoo") {
                    webview.loadUrl("https://search.yahoo.com/mobile/s?p=" + edittext.getText());
                }
                else if (coach == "Bing") {
                    webview.loadUrl("http://www.bing.com/search?q=" + edittext.getText());
                }
                else if (coach == "DuckDuckGo") {
                    webview.loadUrl("https://duckduckgo.com/?q=" + edittext.getText());
                }
                else if (coach == "Wikipedia") {
                    webview.loadUrl("https://ko.m.wikipedia.org/wiki/" + edittext.getText());
                }
                else if (coach == "Naver") {
                    webview.loadUrl("https://m.search.naver.com/search.naver?sm=top_hty&where=m&ie=utf8&query=" + edittext.getText());
                }

                return true;
            }
        });

    }

    // 웹뷰 클라이언트 지정
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }
    }
}