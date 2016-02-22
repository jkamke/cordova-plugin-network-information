package org.apache.cordova.networkinformation;

import org.apache.cordova.CordovaInterface;

import com.amchealth.ppp.PppDialerService;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityProxy {
  private ConnectivityManager m;
  public static  String CONNECTIVITY_ACTION = "org.apache.cordova.CordovaInterface.CONNECTIVITY_ACTION";
  public ConnectivityProxy(CordovaInterface cordova) {
    m = (ConnectivityManager) cordova.getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
  }

  public NetworkInfo getActiveNetworkInfo() {
    NetworkInfo activeNetworkInfo = m.getActiveNetworkInfo();
    if(activeNetworkInfo==null){
      activeNetworkInfo = PppDialerService.getActiveNetworkInfo();
    }
    return activeNetworkInfo;
  }


}
