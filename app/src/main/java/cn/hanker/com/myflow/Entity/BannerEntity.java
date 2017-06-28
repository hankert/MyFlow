package cn.hanker.com.myflow.Entity;

import java.util.ArrayList;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/3/20.
 */

public class BannerEntity extends BaseEntity {
    private BannerData data;

    public BannerData getData() {
        return data;
    }

    public void setData(BannerData data) {
        this.data = data;
    }

    public class BannerData {
        private String updatetime;
        private ArrayList<BannerItem> items;

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public ArrayList<BannerItem> getItems() {
            return items;
        }

        public void setItems(ArrayList<BannerItem> items) {
            this.items = items;
        }
    }

    public class BannerItem {
        private String imageurl;
        private String linkurl;

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }

    }


}
