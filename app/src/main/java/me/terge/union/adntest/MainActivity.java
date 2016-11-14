package me.terge.union.adntest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import me.terge.union.adntest.bridge.LogBridge;
import me.terge.union.adntest.bridge.LogView;
import me.terge.union.adntest.loader.AdLoader;
import me.terge.union.adntest.loader.AdLoaderCache;
import me.terge.union.adntest.bridge.BannerBridge;
import me.terge.union.adntest.bridge.InterstitialBridge;
import me.terge.union.adntest.bridge.NativeBridge;
import me.terge.union.adntest.loader.OnLoadClickListener;
import me.terge.union.adntest.consts.ADN;
import me.terge.union.adntest.consts.AdType;

/**
 * Created by terge on 16-10-27.
 */

public class MainActivity extends AppCompatActivity implements OnLoadClickListener{

    Spinner spAdn,spAdType;
    EditText etAppId,etPub;
    ADN currAdn = ADN.ADMOB;
    AdType currAdType = AdType.BANNER;
    private LogBridge mLog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,currAdn+" "+currAdType +" loadAd",Toast.LENGTH_SHORT).show();
                onLoadClick();
            }
        });


        etAppId = (EditText) findViewById(R.id.et_app_id);
        etPub = (EditText) findViewById(R.id.et_pub);

        //ADN
        spAdn = (Spinner) findViewById(R.id.sp_adn);
        ArrayAdapter<ADN> adnAdapter = new ArrayAdapter<ADN>(this,android.R.layout.simple_spinner_item, new ADN[]{ADN.ADMOB,ADN.FACEBOOK,ADN.UNION});
        adnAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAdn.setAdapter(adnAdapter);
        spAdn.setOnItemSelectedListener(adnSeletctedListener);

        //AdType
        spAdType = (Spinner) findViewById(R.id.sp_adtype);
        ArrayAdapter<AdType> adTypeAdapter = new ArrayAdapter<AdType>(this,android.R.layout.simple_spinner_item, new AdType[]{AdType.BANNER,AdType.INTERSTITIAL,AdType.NATIVE});
        adTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAdType.setAdapter(adTypeAdapter);
        spAdType.setOnItemSelectedListener(adTypeSeletctedListener);

        ViewGroup bannerContainer = (ViewGroup) findViewById(R.id.banner_content);
        BannerBridge.instance().setContainer(bannerContainer);
        InterstitialBridge.instance().setContext(this);
        ViewGroup nativeContainer = (ViewGroup) findViewById(R.id.native_content);
        NativeBridge.instance().setContainer(nativeContainer);


        LogView logview = (LogView) findViewById(R.id.nav_view);
        mLog = LogBridge.instance();
        mLog.setLogView(logview);
    }



    @Override
    public void onLoadClick() {
        LogBridge.instance().clear();
        mLog.d("terge","onLoadClick");
        AdLoader adLoader = AdLoaderCache.get(currAdn,currAdType);
        if(adLoader == null){
            Toast.makeText(this,"Not implement:"+currAdn+" "+currAdType,Toast.LENGTH_SHORT).show();
            return;
        }

        String appId = etAppId.getText() == null? "":etAppId.getText().toString();
        String pub = etPub.getText() == null?"":etPub.getText().toString();
        adLoader.loadAd(appId,pub);
        mLog.i("terge","loadAd "+currAdn+" "+currAdType);
    }

    private AdapterView.OnItemSelectedListener adnSeletctedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            currAdn = (ADN) spAdn.getAdapter().getItem(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };

    private AdapterView.OnItemSelectedListener adTypeSeletctedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            currAdType = (AdType) spAdType.getAdapter().getItem(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    };




}
