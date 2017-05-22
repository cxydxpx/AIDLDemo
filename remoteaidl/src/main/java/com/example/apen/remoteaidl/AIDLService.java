package com.example.apen.remoteaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者 Y_MS
 * Created by ${APEN} on 2017/5/22.
 * GitHub：https://github.com/cxydxpx
 */

public class AIDLService extends Service {


    private List<Book> mBooks = new ArrayList<>();

    private final BookManager.Stub stub = new BookManager.Stub() {

        @Override
        public List<Book> getBooks() throws RemoteException {
            if (mBooks != null) {
                return mBooks;
            }
            return new ArrayList<>();
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            if (mBooks == null) {
                mBooks = new ArrayList<>();
            }
            if (book == null) {
                Log.e(TAG, "Book is null in In");
                book = new Book();
            }
            //尝试修改book的参数，主要是为了观察其到客户端的反馈
            book.setPrice(2333);
            if (!mBooks.contains(book)) {
                mBooks.add(book);
            }
        }
    };
    public static final String TAG = "apen";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Book book = new Book();
        book.setName("Android开发艺术探索");
        book.setPrice(28);
        mBooks.add(book);
    }
}
