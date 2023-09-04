package com.app.yoursingleradio.database.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class AdsPref {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public AdsPref(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("ads_setting", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveAds(String ad_status, String ad_type, String admob_publisher_id, String admob_banner_unit_id, String admob_interstitial_unit_id, String admob_native_unit_id, String admob_app_open_unit_id, String startapp_app_id, String unity_game_id, String unity_banner_placement_id, String unity_interstitial_placement_id, String applovin_banner_unit_id, String applovin_interstitial_unit_id, int interstitial_ad_interval) {
        editor.putString("ad_status", ad_status);
        editor.putString("ad_type", ad_type);
        editor.putString("admob_publisher_id", admob_publisher_id);
        editor.putString("admob_banner_unit_id", admob_banner_unit_id);
        editor.putString("admob_interstitial_unit_id", admob_interstitial_unit_id);
        editor.putString("admob_native_unit_id", admob_native_unit_id);
        editor.putString("admob_app_open_unit_id", admob_app_open_unit_id);
        editor.putString("startapp_app_id", startapp_app_id);
        editor.putString("unity_game_id", unity_game_id);
        editor.putString("unity_banner_placement_id", unity_banner_placement_id);
        editor.putString("unity_interstitial_placement_id", unity_interstitial_placement_id);
        editor.putString("applovin_banner_unit_id", applovin_banner_unit_id);
        editor.putString("applovin_interstitial_unit_id", applovin_interstitial_unit_id);
        editor.putInt("interstitial_ad_interval", interstitial_ad_interval);
        editor.apply();
    }

    public String getAdStatus() {
        return sharedPreferences.getString("ad_status", "0");
    }

    public String getAdType() {
        return sharedPreferences.getString("ad_type", "0");
    }

    public String getAdMobPublisherId() {
        return sharedPreferences.getString("admob_publisher_id", "0");
    }

    public String getAdMobAppId() {
        return sharedPreferences.getString("admob_app_id", "0");
    }

    public String getAdMobBannerId() {
        return sharedPreferences.getString("admob_banner_unit_id", "0");
    }

    public String getAdMobInterstitialId() {
        return sharedPreferences.getString("admob_interstitial_unit_id", "0");
    }

    public String getAdMobNativeId() {
        return sharedPreferences.getString("admob_native_unit_id", "0");
    }

    public String getAdMobAppOpenId() {
        return sharedPreferences.getString("admob_app_open_unit_id", "0");
    }

    public String getFanNativeUnitId() {
        return sharedPreferences.getString("fan_native_unit_id", "0");
    }

    public String getStartappAppID() {
        return sharedPreferences.getString("startapp_app_id", "0");
    }

    public String getUnityGameId() {
        return sharedPreferences.getString("unity_game_id", "0");
    }

    public String getUnityBannerPlacementId() {
        return sharedPreferences.getString("unity_banner_placement_id", "banner");
    }

    public String getUnityInterstitialPlacementId() {
        return sharedPreferences.getString("unity_interstitial_placement_id", "video");
    }

    public String getAppLovinBannerId() {
        return sharedPreferences.getString("applovin_banner_unit_id", "0");
    }

    public String getAppLovinInterstitialId() {
        return sharedPreferences.getString("applovin_interstitial_unit_id", "0");
    }

    public int getInterstitialAdInterval() {
        return sharedPreferences.getInt("interstitial_ad_interval", 0);
    }

    public String getDateTime() {
        return sharedPreferences.getString("date_time", "0");
    }

    public String getPackageName() {
        return sharedPreferences.getString("package_name", "");
    }

    public String getPrivacyPolicy() {
        return sharedPreferences.getString("privacy_policy", "");
    }

}
