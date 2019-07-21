package zxc.laitooo.sri.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Laitooo San on 06/06/2019.
 */

public class UserData {

    String NAME = "sri_data";
    SharedPreferences preferences;
    Context c;

    public UserData(Context c) {
        this.c = c;
        preferences = c.getSharedPreferences(NAME,Context.MODE_PRIVATE);
    }

    public void userLogin(String email,String username){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("is_user_logged",true);
        editor.putString("email",email);
        editor.putString("username",username);
        editor.commit();
    }

    public String getUserName(){
        return preferences.getString("username","");
    }

    public String getUserEmail(){
        return preferences.getString("email","");
    }

    public boolean isUserLogged(){
        return preferences.getBoolean("is_user_logged",false);
    }

    public void logOut(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

    public void  saveUser(int id,String email,String username,String firstname,String lastname,
                          String image){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("is_user_logged",true);
        editor.putInt("id",id);
        editor.putString("email",email);
        editor.putString("username",username);
        editor.putString("firstname",firstname);
        editor.putString("lastname",lastname);
        editor.putString("image_url",image);
        editor.commit();
    }

    public String getFirstName(){
        return preferences.getString("firstname","");
    }

    public String getLastName(){
        return preferences.getString("lastname","");
    }

    public int getId(){
        return preferences.getInt("id",-1);
    }

    public String getImageUrl(){
        return preferences.getString("image_url","");
    }

    public void setUserName(String username){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username",username);
        editor.commit();
    }

    public void setFirstName(String firstname){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("firstname",firstname);
        editor.commit();
    }

    public void setLastName(String lastname){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("lastname",lastname);
        editor.commit();
    }




}
