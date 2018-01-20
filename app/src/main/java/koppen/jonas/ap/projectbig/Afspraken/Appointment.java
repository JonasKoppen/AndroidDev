package koppen.jonas.ap.projectbig.Afspraken;

import java.util.Calendar;
import koppen.jonas.ap.projectbig.R;

public class Appointment {

    /* Id */
    private int id;

    /* Time slot */
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;

    /* Contact */
    private String contactName;
    private String location;
    private String reason;

    // picture
    private int picture;

    //location
    private String geoLocation;

    public Appointment(int id, int day, int month, int year, int hour, int minute, String contactName, String location, String reason) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.contactName = contactName;
        this.location = location;
        this.reason = reason;
        this.picture = R.drawable.default_symbol;
        this.geoLocation = "geo:0,0?q="+location;
    }

    public Appointment(int id, int day, int month, int year, int hour, int minute, String contactName, String location, String reason, int picture, double locBreedte , double locLengte) {
        this.id = id;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.contactName = contactName;
        this.location = location;
        this.reason = reason;
        if(picture != 0){
            this.picture = picture;
        }
        else {
            this.picture = R.drawable.default_symbol;
        }
        if(!(locBreedte == 0 && locLengte == 0)){
            this.geoLocation = "geo:0,0?q="+locBreedte+","+locLengte+"("+contactName+")";
        }
        else {
            this.geoLocation = "geo:0,0?q="+location;
        }

    }

    public long getTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.year, this.month, this.day, this.hour, this.minute);
        return calendar.getTimeInMillis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Calendar getDate(){
        Calendar date = Calendar.getInstance();
        date.set(year,month-1,day,hour,minute);
        return date;
    }

    @Override
    public String toString() {
        return "" + getContactName() + " at " + getDay() + "/" + getMonth() +" " + getHour() + ":" + getMinute();
    }
}
