package wyh.wishyouhealthy;

/**
 * Created by ccpizzadaisuki on 2015/4/9.
 * Applied and modified Bill Osuch's code on
 * http://geekswithblogs.net/bosuch/archive/2011/01/31/android---create-a-custom-multi-line-listview-bound-to-an.aspx
 */
public class AppointmentDisplay {
    private String nameDoctor = "";
    private String timestamp = "";

    public void setNameDoctor(String name) {
        this.nameDoctor = name;
    }
    public void setTimestamp(String time) {
        this.timestamp = time;
    }
    // the setter.

    public String getNameDoctor() {
        return nameDoctor;
    }
    public String getTimestamp() {
        return timestamp;
    }
    // the getter.


}