package com.clock.zc.mydemo.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.clock.zc.mydemo.Book;
import com.clock.zc.mydemo.BookManager;
import com.clock.zc.mydemo.R;
import com.clock.zc.mydemo.base.BaseActivity;
import com.clock.zc.mydemo.bean.UBook;
import com.clock.zc.mydemo.bean.User;
import com.clock.zc.mydemo.ui.fragement.BannerFragment;
import com.clock.zc.mydemo.ui.fragement.FirstFragment;
import com.clock.zc.mydemo.ui.fragement.TableFragment;
import com.clock.zc.mydemo.view.QQNaviView;
import com.clock.zc.mydemo.view.TransitionHelper;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;
import com.qihoo360.replugin.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hugo.weaving.DebugLog;

import static com.clock.zc.mydemo.R.id.fragment_container;


public class MainActivity extends BaseActivity {
    private static final String TAG ="MainActivity" ;

    @BindView(R.id.qq_view_bubble)
    QQNaviView qq_view_bubble;
    @BindView(R.id.qq_view_person)
    QQNaviView qq_view_person;
    @BindView(R.id.qq_view_star)
    QQNaviView qq_view_star;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;
    @BindView(R.id.nav_view)
    NavigationView nav_view;
    @BindView(R.id.tool_bar)
    Toolbar tool_bar;
    @BindView(R.id.title)
    TextView title;

    View headerLayout;
    private BannerFragment f1;
    private FirstFragment f2;
    private TableFragment f3;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer_layout, tool_bar, 0, 0);
        drawerToggle.syncState();
        drawer_layout.addDrawerListener(drawerToggle);

        qq_view_bubble.setText("33");
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        qq_view_bubble.setBigIcon(R.mipmap.bubble_big);
        qq_view_bubble.setSmallIcon(R.mipmap.bubble_small);
        if(f1==null){
            f1 = new BannerFragment();
            transaction.add(fragment_container,f1);
        }else{
            transaction.show(f1);
        }
        transaction.commit();
        headerLayout = nav_view.inflateHeaderView(R.layout.nav_header_main);
        headerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(context, UserCenterActivity.class);
                Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(MainActivity.this, false,
                        new Pair<>(headerLayout, "share_layout"));
                ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, pairs);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    startActivity(i, transitionActivityOptions.toBundle());
                }else{
                    startActivity(i);
                }
            }
        });
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,ProxyActivity.class));
//                UBook book = new UBook();
//                book.name = "nihao";
//                book.id = 2;
//                User user = new User();
//                user.userName = "nigulasi";
//                user.isMale = true;
//                user.userId = 2;
//                user.uBook = book;
////                Bundle bundle = new Bundle();
////                bundle.putParcelable("user",user);
//                Log.e(TAG,user.toString());
//                Intent intent = new Intent(MainActivity.this,MyService.class);
//                intent.putExtra("user",user);
//                startService(intent);

//                CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
//                    @Override
//                    public void onTick(long millisUntilFinished) {
//                        title.setText(millisUntilFinished/1000+"");
//                    }
//
//                    @Override
//                    public void onFinish() {
//                        Intent intent = new Intent(MainActivity.this,MyService.class);
//                        bindService(intent,connection,BIND_AUTO_CREATE);
//                    }
//                }.start();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,IntentServiceActivity.class);
                startActivity(intent);
                //如果与服务端的连接处于未连接状态，则尝试连接
//                if (!mBound) {
//                    attemptToBindService();
//                    Toast.makeText(MainActivity.this, "当前与服务端处于未连接状态，正在尝试重连，请稍后再试", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (mBookManager == null) return;
//
//                Book book = new Book();
//                book.setName("APP研发录In");
//                book.setPrice(30);
//                try {
//                    mBookManager.addBookIn(book);
//                    Log.e(getLocalClassName(), book.toString());
//                } catch (RemoteException e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(MainActivity.this, TargetActivity.class);
//                startActivity(intent);

            }
        });
    }

    private void attemptToBindService() {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        bindService(intent,connection,BIND_AUTO_CREATE);
    }

    //    private Messenger messenger;
    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
//            messenger = new Messenger(service);
//            Message message = Message.obtain(null,0);
//            Bundle bundle = new Bundle();
//            bundle.putString("msg","nihao,fuwuqi");
//            message.setData(bundle);
//            message.replyTo = smessenger;
//            try {
//                messenger.send(message);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
            mBookManager = BookManager.Stub.asInterface(service);
            mBound = true;

            if (mBookManager != null) {
                try {
                    mBooks = mBookManager.getBooks();
                    Log.e(getLocalClassName(), mBooks.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };

    @OnClick({R.id.qq_view_bubble,R.id.qq_view_person,R.id.qq_view_star})
    void click(View view){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideAllFragment(transaction);
        resetIcon();
        switch (view.getId()){
            case R.id.qq_view_bubble:
                qq_view_bubble.setBigIcon(R.mipmap.bubble_big);
                qq_view_bubble.setSmallIcon(R.mipmap.bubble_small);

                if(f1==null){
                    f1 = new BannerFragment();
                    transaction.add(fragment_container,f1);
                }else{
                    transaction.show(f1);
                }
                break;
            case R.id.qq_view_person:
                qq_view_person.setBigIcon(R.mipmap.person_big);
                qq_view_person.setSmallIcon(R.mipmap.person_small);
                if(f2==null){
                    f2 = new FirstFragment("第二个Fragment");
                    transaction.add(fragment_container,f2);
                }else{
                    transaction.show(f2);
                }
                break;
            case R.id.qq_view_star:
                qq_view_star.setBigIcon(R.mipmap.star_big);
                qq_view_star.setSmallIcon(R.mipmap.star_small);
                if(f3==null){
                    f3 = new TableFragment();
                    transaction.add(fragment_container,f3);
                }else{
                    transaction.show(f3);
                }
                break;

                default:
                    break;
        }
        transaction.commit();
    }
//    private  Messenger smessenger = new Messenger(new MessagerHandler());
//    private static class MessagerHandler extends Handler {
//        @Override
//        public void handleMessage(Message msg) {
//            switch (msg.what) {
//                case 1:
//                    Log.e(TAG,"从服务端传来的"+msg.getData().getString("reply"));
//
//                    break;
//                default:
//                    super.handleMessage(msg);
//            }
//        }
//    }

    @OnClick(R.id.title)
    void down(View v){
        Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG).show();
        String demo3Apk = "clock.apk";
        String demo3apkPath = Environment.getExternalStorageDirectory() + File.separator + demo3Apk;
        File pluginFile = new File(demo3apkPath);
        if(pluginFile.exists()){
            String pluginFilePath = getFilesDir().getAbsolutePath() + File.separator + demo3Apk;
            File newpluginFile = new File(pluginFilePath);
            if(newpluginFile.exists()){
                FileUtils.deleteQuietly(newpluginFile);
            }
            // 开始复制
            copyFileToAppFiles(pluginFile, demo3Apk);
            PluginInfo info = null;
            if (newpluginFile.exists()) {
                info = RePlugin.install(pluginFilePath);
            }

            if (info != null) {
                RePlugin.startActivity(MainActivity.this, RePlugin.createIntent(info.getName(), "com.clock.zc.punchtheclock.ui.MainActivity"));
            } else {
                Toast.makeText(MainActivity.this, "install external plugin failed", Toast.LENGTH_SHORT).show();
            }
        }else{
            toast("插件没下载成功");
        }

    }
    /**
     * 复制某文件内容
     *  @param  fileName 的Apk源文件路径
     *  @param  newFileName 复制到/data/data/package_name/files/目录下文件名
     */
    private void copyFileToAppFiles(File fileName, String newFileName) {
        InputStream is = null;
        FileOutputStream fos = null;
        int buffsize = 1024;

        try {
            is = new FileInputStream(fileName);
            fos = this.openFileOutput(newFileName, Context.MODE_PRIVATE);
            int byteCount = 0;
            byte[] buffer = new byte[buffsize];
            while((byteCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, byteCount);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void resetIcon() {
        qq_view_bubble.setBigIcon(R.mipmap.pre_bubble_big);
        qq_view_bubble.setSmallIcon(R.mipmap.pre_bubble_small);

        qq_view_person.setBigIcon(R.mipmap.pre_person_big);
        qq_view_person.setSmallIcon(R.mipmap.pre_person_small);

        qq_view_star.setBigIcon(R.mipmap.pre_star_big);
        qq_view_star.setSmallIcon(R.mipmap.pre_star_small);
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction){
        if(f1!=null){
            transaction.hide(f1);
        }
        if(f2!=null){
            transaction.hide(f2);
        }
        if(f3!=null){
            transaction.hide(f3);
        }

    }

    @Override
    protected void onDestroy() {

        if (mBound) {
            unbindService(connection);
            mBound = false;
        }

        super.onDestroy();
    }

    //由AIDL文件生成的Java类
    private BookManager mBookManager = null;
    //标志当前与服务端连接状况的布尔值，false为未连接，true为连接中
    private boolean mBound = false;
    //包含Book对象的list
    private List<Book> mBooks;
}
