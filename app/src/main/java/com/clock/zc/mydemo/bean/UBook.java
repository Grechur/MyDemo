package com.clock.zc.mydemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Zc on 2018/3/13.
 */

public class UBook implements Parcelable{
    public String name;
    public int id;

    public UBook(){

    }

    protected UBook(Parcel in) {
        name = in.readString();
        id = in.readInt();
    }

    public static final Creator<UBook> CREATOR = new Creator<UBook>() {
        @Override
        public UBook createFromParcel(Parcel in) {
            return new UBook(in);
        }

        @Override
        public UBook[] newArray(int size) {
            return new UBook[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
    }
    /**
     * 参数是一个Parcel,用它来存储与传输数据
     * @param dest
     */
    public void readFromParcel(Parcel dest) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        name = dest.readString();
        id = dest.readInt();
    }
    @Override
    public String toString() {
        return "UBook{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
