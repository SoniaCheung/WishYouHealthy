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
                //by An Luong, chat with Doctor
                return new ChatWithDoctor();
            case 4:
                //by An Luong, chat with Doctor
                return new Setting();
        }
        return null;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 5; //No of Tabs
    }
}