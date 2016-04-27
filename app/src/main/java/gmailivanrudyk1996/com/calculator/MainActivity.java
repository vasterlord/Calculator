package gmailivanrudyk1996.com.calculator;



import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
    FragmentCalc fragment;
    FragmentTransaction fTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new FragmentCalc();
        fTrans = getFragmentManager().beginTransaction();
        fTrans.replace(R.id.fr, fragment);
        fTrans.commit();
    }
}
