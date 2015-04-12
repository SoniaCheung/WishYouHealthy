package wyh.wishyouhealthy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class HealthTipsTabPagerAdapter extends FragmentStatePagerAdapter {
    public HealthTipsTabPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                //Fragement for calander & lotout tab
                return new HealthTips1();
            case 1:
                //Fragment for making appointment tab
                return new HealthTips2();
            case 2:
        //        //Fragment for changing appointment tab
                return new HealthTips3();
        }
        return null;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3; //No of Tabs
    }
}