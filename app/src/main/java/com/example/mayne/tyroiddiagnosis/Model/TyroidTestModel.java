package com.example.mayne.tyroiddiagnosis.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mayne on 8.12.2018.
 */

public class TyroidTestModel implements Parcelable {

    private Double TST;
    private Double TSH;
    private Double T3;
    private Double MADTSH;
    private Double TSTT;

    public TyroidTestModel(Double TST, Double TSH, Double t3, Double MADTSH, Double TSTT) {
        this.TST = TST;
        this.TSH = TSH;
        this.T3 = t3;
        this.MADTSH = MADTSH;
        this.TSTT = TSTT;
    }

    public TyroidTestModel() {
    }

    protected TyroidTestModel(Parcel in) {
        if (in.readByte() == 0) {
            TST = null;
        } else {
            TST = in.readDouble();
        }
        if (in.readByte() == 0) {
            TSH = null;
        } else {
            TSH = in.readDouble();
        }
        if (in.readByte() == 0) {
            T3 = null;
        } else {
            T3 = in.readDouble();
        }
        if (in.readByte() == 0) {
            MADTSH = null;
        } else {
            MADTSH = in.readDouble();
        }
        if (in.readByte() == 0) {
            TSTT = null;
        } else {
            TSTT = in.readDouble();
        }
    }

    public static final Creator<TyroidTestModel> CREATOR = new Creator<TyroidTestModel>() {
        @Override
        public TyroidTestModel createFromParcel(Parcel in) {
            return new TyroidTestModel(in);
        }

        @Override
        public TyroidTestModel[] newArray(int size) {
            return new TyroidTestModel[size];
        }
    };

    public Double getTST() {
        return TST;
    }

    public void setTST(Double TST) {
        this.TST = TST;
    }

    public Double getTSH() {
        return TSH;
    }

    public void setTSH(Double TSH) {
        this.TSH = TSH;
    }

    public Double getT3() {
        return T3;
    }

    public void setT3(Double t3) {
        T3 = t3;
    }

    public Double getMADTSH() {
        return MADTSH;
    }

    public void setMADTSH(Double MADTSH) {
        this.MADTSH = MADTSH;
    }

    public Double getTSTT() {
        return TSTT;
    }

    public void setTSTT(Double TSTT) {
        this.TSTT = TSTT;
    }

    @Override
    public String toString() {
        return "TyroidTestModel{" +
                "TST=" + TST +
                ", TSH=" + TSH +
                ", T3=" + T3 +
                ", MADTSH=" + MADTSH +
                ", TSTT=" + TSTT +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (TST == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(TST);
        }
        if (TSH == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(TSH);
        }
        if (T3 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(T3);
        }
        if (MADTSH == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(MADTSH);
        }
        if (TSTT == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(TSTT);
        }
    }
}
