package zxc.laitooo.sri;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ForgetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpw);


    }

    public void send_reset_password(View view) {
        MyDialog dialogss = new MyDialog(ForgetPasswordActivity.this,8);
        dialogss.show(getFragmentManager(), "My Dialog");
    }
}
