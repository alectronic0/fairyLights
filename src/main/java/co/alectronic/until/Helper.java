package co.alectronic.until;

public class Helper {
    public static final String SEQ = "sequence";
    public static final String COL = "colour";
    public static final String ALT = "alternate";

    public static final int NO_LIGHTS = 20;
    public static final String[] COL_LIST = new String[]{"Green", "White"};

    public static final int SEQ_MILLI_TIME = 500;
    public static final int COL_MILLI_TIME = 1000;
    public static final int ALT_MILLI_TIME = 30000;


    public static int parseArg(String val, int defaultVal){
        try{
            return Integer.valueOf(val);
        }catch (Exception e){
            System.out.println("Error with light number setting to default: " + defaultVal);
            return defaultVal;
        }
    }

    public static String parseArg(String val, String defaultVal){
        return (val != null)? val : defaultVal;
    }

}
