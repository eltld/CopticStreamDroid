package custom;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mina on 2/28/2015.
 */
public class DrawerItem {
    @SerializedName("title")
    public String title;
    @SerializedName("icon")
    public int icon;

    public DrawerItem(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }
}
