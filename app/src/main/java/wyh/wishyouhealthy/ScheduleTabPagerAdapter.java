package wyh.wishyouhealthy;

/**
 * Created by ccpizzadaisuki on 2015/4/5.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ScheduleTabPagerAdapter extends FragmentStatePagerAdapter {
    public ScheduleTabPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                //Fragement for calander & lotout tab
                return new CalendarLogout();
            case 1:
                //Fragment for making appointment tab
                return new AppointmentMake();
            case 2:
                //Fragment for changing appointment tab
                return new AppointmentChange();
            case 3:
                //Fragement for cancelling appointment tab
                return new AppointmentCancel();
        }
        return null;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 4; //No of Tabs
    }
}