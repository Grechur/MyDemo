package com.clock.zc.mydemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Zc on 2018/3/13.
 */

public class User implements Parcelable {
    public int userId;
    public String userName;
    public boolean isMale;

    public UBook uBook;
    public User(){

    }
    protected User(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readByte() != 0;
        uBook = in.readParcelable(Thread.currentThread().getContextClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(userName);
        dest.writeByte((byte) (isMale ? 1 : 0));
        dest.writeParcelable(uBook,0);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", isMale=" + isMale +
                ", uBook=" + uBook +
                '}';
    }
}
