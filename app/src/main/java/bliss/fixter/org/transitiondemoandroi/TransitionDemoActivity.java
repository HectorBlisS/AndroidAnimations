package bliss.fixter.org.transitiondemoandroi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.RelativeLayout;

public class TransitionDemoActivity extends AppCompatActivity {

    ViewGroup myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_demo);

        // seteamos el observador
        myLayout = (ViewGroup) findViewById(R.id.activity_transition_demo);
        myLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){
                    public boolean onTouch(View v, MotionEvent m){
                        handleTouch();
                        return true;
                    }
                }
        ); // aqui termina el observador
    } //el metodo onCreate

    public void handleTouch(){
        // traemos el boton (lo usamos despues)
        View view = findViewById(R.id.myButton);
        // Customizamos la animacion
        Transition changeBounds = new ChangeBounds();
        changeBounds.setDuration(3000);
        changeBounds.setInterpolator(new BounceInterpolator());
        TransitionManager.beginDelayedTransition(myLayout, changeBounds);
        // seteamos los cambios en el layout
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        //Le pasamos los parametros al boton
        view.setLayoutParams(params);

        ViewGroup.LayoutParams lparams = view.getLayoutParams();
        lparams.width = 500;
        lparams.height = 350;
        view.setLayoutParams(lparams);
    } // handleTouch

} // esta es la clase
