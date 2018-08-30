package textlink.song.com.textlink;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.text.AutoText;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {
    private String TAG = MainActivity.class.getSimpleName();
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.tv_content);
        title.setText(" 10086 中国移动的 这是百度的 https://www.baidu.com/");
        title.setAutoLinkMask(Linkify.PHONE_NUMBERS);
        title.setMovementMethod(new LinkMovementMethodEx(new LinkClickListener() {
            @Override
            public boolean onLinkClick(String mURL) {
                //在这里执行直接的处理逻辑并将返回值设置为true
                Log.i(TAG, "onLinkClick: " + mURL);

                return false;
            }
        }));
    }
}
