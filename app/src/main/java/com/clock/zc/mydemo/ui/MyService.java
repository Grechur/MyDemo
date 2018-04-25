package com.clock.zc.mydemo.ui;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.clock.zc.mydemo.Book;
import com.clock.zc.mydemo.BookManager;
import com.clock.zc.mydemo.bean.User;

import java.util.ArrayList;
import java.util.List;

public class MyService extends Service {
    public static final String TAG = "MyService";
//    private final Messenger messenger = new Messenger(new MessagerHandler());
    //包含Book对象的list
    private List<Book> mBooks = new ArrayList<>();
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate");
        Book book = new Book();
        book.setName("Android开发艺术探索");
        book.setPrice(28);
        mBooks.add(book);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand");
//        User user = intent.getParcelableExtra("user");
//        Log.e(TAG,user.toString());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG,"onBind");
//        return messenger.getBinder();
        return mBookManager;
    }

//    private static class MessagerHandler extends Handler{
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 0:
//                    Log.e(TAG,"从客户端传来的"+msg.getData().getString("msg"));
//                    Messenger messenger = msg.replyTo;
//                    Message replymessage = Message.obtain(null,1);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("reply","niyehao");
//                    replymessage.setData(bundle);
//                    Log.e(TAG,replymessage.getData().getString("reply")+(messenger!=null));
//                    try {
//                        messenger.send(replymessage);
//                    } catch (RemoteException e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                default:
//                super.handleMessage(msg);
//            }
//        }
//    }

    private final BookManager.Stub mBookManager = new BookManager.Stub() {
    @Override
    public List<Book> getBooks() throws RemoteException {
        synchronized (this) {
            Log.e(TAG, "invoking getBooks() method , now the list is : " + mBooks.toString());
            if (mBooks != null) {
                return mBooks;
            }
            return new ArrayList<>();
        }
    }

    @Override
    public Book getBook() throws RemoteException {
        return null;
    }

    @Override
    public int getBookCount() throws RemoteException {
        return 0;
    }

    @Override
    public void setBookPrice(Book book, int price) throws RemoteException {

    }

    @Override
    public void setBookName(Book book, String name) throws RemoteException {

    }

    @Override
    public void addBookIn(Book book) throws RemoteException {
        synchronized (this) {
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
            //打印mBooks列表，观察客户端传过来的值
            Log.e(TAG, "invoking addBooks() method , now the list is : " + mBooks.toString());
        }
    }

    @Override
    public void addBookOut(Book book) throws RemoteException {

    }

    @Override
    public void addBookInout(Book book) throws RemoteException {

    }
};
}
