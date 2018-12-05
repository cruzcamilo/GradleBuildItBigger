package com.udacity.gradle.builditbigger;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.databinding.FragmentMainBinding;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }
    private static final String TAG = MainActivityFragment.class.getName();

    private InterstitialAd mInterstitialAd;
    private FragmentMainBinding mFragmentMainBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mFragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container,
                false);
        View root = mFragmentMainBinding.getRoot();

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("E04EC52520C747F61516FD226CC32D0F")
                .build();
        mFragmentMainBinding.adView.loadAd(adRequest);

        MobileAds.initialize(getContext(),
                "ca-app-pub-3940256099942544~3347511713");

        requestNewInterstitial();

        mFragmentMainBinding.getJokeBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(mInterstitialAd.isLoaded()){
                  mInterstitialAd.show();
              } else {
                  Log.d(TAG, getString(R.string.interstitial_not_loaded));
              }
          }
      });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                ((MainActivity)getActivity()).tellJoke();
                requestNewInterstitial();
            }
        });

        return root;
    }

    // Taken from https://stackoverflow.com/questions/38374496/
    private void requestNewInterstitial() {
        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }
}