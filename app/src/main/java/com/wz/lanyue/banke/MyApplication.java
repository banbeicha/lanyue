package com.wz.lanyue.banke;
import android.app.Application;
import android.content.Context;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.openapi.models.User;
import com.wz.lanyue.banke.model.AccessTokenKeeper;

import org.xutils.x;

/**
 * Created by BANBEICHA on 2016/3/25.
 */
public class MyApplication extends Application {
public static final String socialurl="http://apis.baidu.com/txapi/social/social";//社会
    public static final String apikey="635e32fdaefe493627adf89b70dbd0af";
    public static final String appKey="2500759857";
    public static final String kejiurl="http://apis.baidu.com/txapi/keji/keji";
    public static final String yuleurl="http://apis.baidu.com/txapi/huabian/newtop";
    public static final String tiyuurl="http://apis.baidu.com/txapi/tiyu/tiyu";
    public static final String appleurl="http://apis.baidu.com/txapi/apple/apple";//苹果
    public static final String worldurl="http://apis.baidu.com/txapi/world/world";//国际
    public static final String healthurl="http://apis.baidu.com/txapi/health/health";//健康
    public static final String qiwenurl="http://apis.baidu.com/txapi/qiwen/qiwen";
    public static final String weixinurl="http://v.juhe.cn/weixin/query";
   public static User user;
    public  static final String meiwenurl="http://www.umeitime.com/articleList";//美文列表
    public  static final String meiwentypeurl="http://www.umeitime.com/getCatalog";//美文类型
    public  static final String meiwencontenturl="http://www.umeitime.com/getArticleContent";//美文内容
    public static final String huabangtypeturl="http://mapi.yinyuetai.com/video/get_mv_areas.json?D-A=0&type=fs";
    private static final String huabangurl="http://mapi.yinyuetai.com/video/list.json?D-A=0&";
    private static  final String huangbangdeviceinfo="%7B%22aid%22%3A%2210201034%22%2C%22os%22%3A%22Android%22%2C%22ov%22%3A%225.1%22%2C%22rn%22%3A%22480*800%22%2C%22dn%22%3A%22PRO%205%22%2C%22cr%22%3A%2246001%22%2C%22as%22%3A%22WIFI%22%2C%22uid%22%3A%2239ab47db579b75d4e69db2b52288fef6%22%2C%22clid%22%3A110011000%7D";
    private static final String huabangHeadpicurl="http://mapi.yinyuetai.com/video/show.json?D-A=0&";
private static final String huabangSearchurl="http://mapi.yinyuetai.com/search/video.json?D-A=0&offset=0&size=20&keyword=";
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

    }
    public static Oauth2AccessToken getToken(Context context){
        return AccessTokenKeeper.readAccessToken(context);
    }
    public static String getHuaBangtUrl(String type,int minsize,int maxsize){
        return huabangurl+"area="+type+"&supportBanner=true&offset="+minsize+"&size="+maxsize+"&promoTitle=true&deviceinfo="+huangbangdeviceinfo;
    }
    public static String getHuaBanghendpicUrl(int id){
        return huabangHeadpicurl+"id="+id+"&relatedVideos=true&deviceinfo="+huangbangdeviceinfo;
    }
    public static String getHuabangSearchurl(String KeyWord){

        return huabangSearchurl+KeyWord+"&deviceinfo="+huangbangdeviceinfo;
    }
}
