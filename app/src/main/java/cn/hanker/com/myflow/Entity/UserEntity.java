package cn.hanker.com.myflow.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/3/17.
 */

public class UserEntity extends  BaseEntity implements Parcelable {

    private UserEntityData data;

    public UserEntityData getData() {
        return data;
    }

    public static class UserEntityData implements Serializable {
        private static final long serialVersionUID = 1L;
        // private String bindPhone;
        private String isBindPhone;
        private String name;
        private String token;
        private String lastLoginTime;// 最后一次登录
        private int balance;// 流量币余额
        private String userid;
        private String nickname;
        private String userlogo;
        private String operators;

        private int pushState;
        private int isSetPayPass;
        private int isSetQuickPass;
        private int isSetCircle;
        private int isWoPai60;
        private String attribution;//山东 当前用户归属的省份，移动电信可以得到也返回，不能得到返回“未知”
        private int issuportfc;//是否支持转入转出 1：是 0:否
        private int issuportfp;//是否支持红包转出 1：支持0： 否



        public int getIssuportfp() {
            return issuportfp;
        }

        public void setIssuportfp(int issuportfp) {
            this.issuportfp = issuportfp;
        }

        public String getAttribution() {
            return attribution;
        }

        public void setAttribution(String attribution) {
            this.attribution = attribution;
        }

        public int getIssuportfc() {
            return issuportfc;
        }

        public void setIssuportfc(int issuportfc) {
            this.issuportfc = issuportfc;
        }

        public int getIsSetPayPass() {
            return isSetPayPass;
        }

        public void setIsSetPayPass(int isSetPayPass) {
            this.isSetPayPass = isSetPayPass;
        }


        public int getIsSetQuickPass() {
            return isSetQuickPass;
        }

        public void setIsSetQuickPass(int isSetQuickPass) {
            this.isSetQuickPass = isSetQuickPass;
        }

        public int getIsSetCircle() {
            return isSetCircle;
        }

        public void setIsSetCircle(int isSetCircle) {
            this.isSetCircle = isSetCircle;
        }

        public boolean isSetQuickPass() {
            if (isSetQuickPass == 0) {
                return false;
            } else if (isSetQuickPass == 1) {
                return true;
            }
            return false;
        }

        public boolean isSetCircle() {
            if (isSetCircle == 0) {
                return false;
            } else if (isSetCircle == 1) {
                return true;
            }
            return false;
        }

        public boolean isSetPayPass() {
            if (isSetPayPass == 0) {
                return false;
            } else if (isSetPayPass == 1) {
                return true;
            }
            return false;
        }
        // public void setBindPhone(String bindPhone) {
        // this.bindPhone = bindPhone;
        // }

        public void setIsBindPhone(String isBindPhone) {
            this.isBindPhone = isBindPhone;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public void setLastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getUserid() {
            return userid;
        }

        // public String getBindPhone() {
        // return bindPhone;
        // }

        public String getIsBindPhone() {
            return isBindPhone;
        }

        public String getName() {
            return name;
        }

        public String getToken() {
            return token;
        }

        public String getLastLoginTime() {
            return lastLoginTime;
        }

        public int getBalance() {
            return balance;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUserlogo() {
            return userlogo;
        }

        public void setUserlogo(String userlogo) {
            this.userlogo = userlogo;
        }

        public String getOperators() {
            return operators;
        }

        public void setOperators(String operators) {
            this.operators = operators;
        }

        public int getPushState() {
            return pushState;
        }

        public void setPushState(int pushState) {
            this.pushState = pushState;
        }

        public int getIsWoPai60() {
            return isWoPai60;
        }

        public void setIsWoPai60(int isWoPai60) {
            this.isWoPai60 = isWoPai60;
        }

        public boolean isWoPai60() {
            if (isWoPai60 == 0) {
                return false;
            } else if (isWoPai60 == 1) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "UserEntityData{" +
                    "isBindPhone='" + isBindPhone + '\'' +
                    ", name='" + name + '\'' +
                    ", token='" + token + '\'' +
                    ", lastLoginTime='" + lastLoginTime + '\'' +
                    ", balance=" + balance +
                    ", userid='" + userid + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", userlogo='" + userlogo + '\'' +
                    ", operators='" + operators + '\'' +
                    ", pushState=" + pushState +
                    ", isSetPayPass=" + isSetPayPass +
                    ", isSetQuickPass=" + isSetQuickPass +
                    ", isSetCircle=" + isSetCircle +
                    ", isWoPai60=" + isWoPai60 +
                    ", attribution='" + attribution + '\'' +
                    ", issuportfc=" + issuportfc +
                    ", issuportfp=" + issuportfp +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "data=" + data +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.data);
    }

    public UserEntity() {
    }

    protected UserEntity(Parcel in) {
        this.data = (UserEntityData) in.readSerializable();
    }

    public static final Parcelable.Creator<UserEntity> CREATOR = new Parcelable.Creator<UserEntity>() {
        @Override
        public UserEntity createFromParcel(Parcel source) {
            return new UserEntity(source);
        }

        @Override
        public UserEntity[] newArray(int size) {
            return new UserEntity[size];
        }
    };
}
