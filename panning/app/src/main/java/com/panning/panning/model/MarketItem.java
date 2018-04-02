package com.panning.panning.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cloud on 2018/4/2.
 */

public class MarketItem implements Parcelable {

    public String lable;
    public int type;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.lable);
        dest.writeInt(this.type);
    }

    public MarketItem() {
    }

    protected MarketItem(Parcel in) {
        this.lable = in.readString();
        this.type = in.readInt();
    }

    public static final Parcelable.Creator<MarketItem> CREATOR = new Parcelable.Creator<MarketItem>() {
        @Override
        public MarketItem createFromParcel(Parcel source) {
            return new MarketItem(source);
        }

        @Override
        public MarketItem[] newArray(int size) {
            return new MarketItem[size];
        }
    };
}
