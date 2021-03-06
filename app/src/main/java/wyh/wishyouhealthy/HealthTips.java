package wyh.wishyouhealthy;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/*import static wyh.wishyouhealthy.R.id.Btn_Logout;
import static wyh.wishyouhealthy.R.id.Btn_mk;
import static wyh.wishyouhealthy.R.id.Btn_ch;
import static wyh.wishyouhealthy.R.id.Btn_can;*/

import android.os.Bundle;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class HealthTips extends FragmentActivity {
    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    HealthTipsTabPagerAdapter mDemoCollectionPagerAdapter1;
    ViewPager mViewPager1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.healthtips_main);

        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        mDemoCollectionPagerAdapter1 =
                new HealthTipsTabPagerAdapter(
                        getSupportFragmentManager());
        mViewPager1 = (ViewPager) findViewById(R.id.pager1);
        mViewPager1.setAdapter(mDemoCollectionPagerAdapter1);
    }


}