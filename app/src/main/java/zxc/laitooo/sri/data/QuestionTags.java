package zxc.laitooo.sri.data;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Laitooo San on 08/06/2019.
 */

public class QuestionTags {

    public static String ENGINEERING = "a";
    public static String MEDICINE = "b";
    public static String LANGUAGES = "c";
    public static String COMPUTER_SCIENCE = "d";
    public static String INFORMATION_TECHNOLOGY = "e";
    public static String PROGRAMMING = "f";
    public static String CHEMISTRY = "g";
    public static String PHYSICS = "h";
    public static String MATHS = "i";
    public static String PSYCHOLOGY = "j";
    public static String BIOLOGY = "k";
    public static String ENGLISH = "l";
    public static String OTHERS = "m";

    public ArrayList<String> TAGS_NAMES;
    public ArrayList<String> TAGS_KEYS;


    public int MAXIMUM_TAGS_SIZE = 13;

    private String TagsShorted;
    private ArrayList<String> tags;
    Context c;

    public QuestionTags(Context context) {
        tags = new ArrayList<>();
        TagsShorted = "";
        c = context;

        TAGS_NAMES = new ArrayList<>();
        TAGS_KEYS = new ArrayList<>();
        TAGS_KEYS.add(ENGINEERING);
        TAGS_KEYS.add(MEDICINE);
        TAGS_KEYS.add(LANGUAGES);
        TAGS_KEYS.add(COMPUTER_SCIENCE);
        TAGS_KEYS.add(INFORMATION_TECHNOLOGY);
        TAGS_KEYS.add(PROGRAMMING);
        TAGS_KEYS.add(CHEMISTRY);
        TAGS_KEYS.add(PHYSICS);
        TAGS_KEYS.add(MATHS);
        TAGS_KEYS.add(PSYCHOLOGY);
        TAGS_KEYS.add(BIOLOGY);
        TAGS_KEYS.add(ENGLISH);
        TAGS_KEYS.add(OTHERS);
        TAGS_NAMES.add("Engineering");
        TAGS_NAMES.add("Medicine");
        TAGS_NAMES.add("Languages");
        TAGS_NAMES.add("Computer Science");
        TAGS_NAMES.add("Information Technology");
        TAGS_NAMES.add("Programming");
        TAGS_NAMES.add("Chemistry");
        TAGS_NAMES.add("Physics");
        TAGS_NAMES.add("Maths");
        TAGS_NAMES.add("Psychology");
        TAGS_NAMES.add("Biology");
        TAGS_NAMES.add("English");
        TAGS_NAMES.add("Others");
    }

    public void addTag(String tag){
        if (TagsShorted.length() != MAXIMUM_TAGS_SIZE) {
            tags.add(tag);
            TagsShorted += tag;
        }else {
            Toast.makeText(c,"Maximum tags count",Toast.LENGTH_LONG).show();
        }
    }

    public void addTag(int tag){
        if (TagsShorted.length() != MAXIMUM_TAGS_SIZE) {
            tags.add(TAGS_KEYS.get(tag));
            TagsShorted += TAGS_KEYS.get(tag);
        }else {
            Toast.makeText(c,"Maximum tags count",Toast.LENGTH_LONG).show();
        }
    }

    public String getTagsShorted(){
        return TagsShorted;
    }

    public void clearTags(){
        tags.clear();
        TagsShorted = "";
    }

    public String getTagName(String a){
        try {
            return TAGS_NAMES.get(TAGS_KEYS.indexOf(a));
        }catch (Exception b){
            return "error : " + b.getMessage();
        }
    }

    public String getTagKey(String a){
        try {
            return TAGS_KEYS.get(TAGS_NAMES.indexOf(a));
        }catch (Exception b){
            return "error : " + b.getMessage();
        }
    }


}
