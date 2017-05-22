package com.example.apen.remoteaidl;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/5/22.
 * GitHub：https://github.com/cxydxpx
 */

public class MessagerService extends Service {

    static final int MSG_SAY_HELLO = 1;

    private Handler serviceHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_SAY_HELLO:
//                   当服务端接受到客户端的消息时
                    Toast.makeText(MessagerService.this, "hello world", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    final Messenger messenger = new Messenger(serviceHandler);
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Toast.makeText(this, "onBind", Toast.LENGTH_SHORT).show();

        return messenger.getBinder();
    }
}
