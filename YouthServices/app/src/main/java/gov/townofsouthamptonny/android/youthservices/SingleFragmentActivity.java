package gov.townofsouthamptonny.android.youthservices;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.esri.android.runtime.ArcGISRuntime;

import java.io.Console;


/**
 * Created by JDaly on 2/2/2016.
 */
public abstract class  SingleFragmentActivity extends AppCompatActivity {

    private static final String TAG = SingleFragmentActivity.class.getCanonicalName();
    @LayoutRes
    protected int getLayoutResId()  {
        return R.layout.activity_fragment;
    }

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {
            ArcGISRuntime.setClientId("hOGiF4ClbCUbiQcJ");
        }
        catch (Exception ex)
        {
            //Log.v(TAG, "client id not set");

        }

        setContentView(getLayoutResId());
        //setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null)  {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
