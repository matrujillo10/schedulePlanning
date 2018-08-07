package model;

public class Schedule {
    public final static String TIME_INI = "time_ini";
    public final static String TIME_FIN = "time_fin";
    public final static String CLASSROOM = "classroom";
    public final static String L = "L";
    public final static String M = "M";
    public final static String I = "I";
    public final static String J = "J";
    public final static String V = "V";
    public final static String S = "S";
    public final static String D = "D";
    public final static String DATE_INI = "date_ini";
    public final static String DATE_FIN = "date_fin";

    private String timeIni;
    private String timeFin;
    private String classroom;
    private String l;
    private String m;
    private String i;
    private String j;
    private String v;
    private String s;
    private String d;
    private String dateIni;
    private String dateFin;

    public Schedule() {
    }

    public String getTimeIni() {
        return timeIni;
    }

    public void setTimeIni(String timeIni) {
        this.timeIni = timeIni;
    }

    public String getTimeFin() {
        return timeFin;
    }

    public void setTimeFin(String timeFin) {
        this.timeFin = timeFin;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getJ() {
        return j;
    }

    public void setJ(String j) {
        this.j = j;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getDateIni() {
        return dateIni;
    }

    public void setDateIni(String dateIni) {
        this.dateIni = dateIni;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
}
