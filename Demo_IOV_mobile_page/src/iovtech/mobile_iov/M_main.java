package iovtech.mobile_iov;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class M_main extends Activity {


	public static int flag_lang = 0;
	//public static int flag_temp; //
	
	ImageView lang;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.m_loading);
		
		Animation ani01 = new AlphaAnimation(0.0f, 1.0f);
		Animation ani02 = new AlphaAnimation(0.0f, 1.0f);
		
		ani01.setDuration(5000);
		ani02.setDuration(6000);
		
		ImageView symbol = (ImageView) findViewById(R.id.symbol_0);
		Button entr = (Button) findViewById(R.id.entr_btn);

		symbol.setAnimation(ani01);
		entr.setAnimation(ani02);
		
		//setContentView(R.layout.m_main);
	}
	
    public boolean onTouchEvent(MotionEvent event){
    	
        if(event.getAction() == MotionEvent.ACTION_DOWN){
        	setContentView(R.layout.m_main_kor);
        }
        return false;
    }
    

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.m_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
    public void mOnclick(View v){
        switch(v.getId()){
        
        case R.id.kor_btn:
        	
        	flag_lang = 0;
        	setContentView(R.layout.m_main_kor);
        	//Intent kor = new Intent(this, M_main.class);
        	//startActivity(kor);
        	
        	break;
        	
        case R.id.lang_btn:
            
            lang = (ImageView)findViewById(R.id.lang_btn);
        	
        	if(flag_lang == 0){
        		//flag_temp = flag_lang;
        		//lang.setBackgroundResource(R.drawable.kor_btn);
        		setContentView(R.layout.m_main_eng);
        		flag_lang = 1;
        	}
        	else if(flag_lang == 1){
        		//flag_temp = flag_lang;
        		//lang.setBackgroundResource(R.drawable.eng_btn);
        		setContentView(R.layout.m_main_kor);
        		flag_lang = 0;
        	}
        	//Intent eng = new Intent(this, M_main.class);
        	//startActivity(eng);
        	
        	break;

        }
    }
    
    public static int out(){
        int out = 0;
        
        if(flag_lang == 0){
        	out = flag_lang + 1;
        }
        else if(flag_lang == 1){
        	out = flag_lang - 1;
        }
        //out = flag_temp;
       
        return out;
    }
	
}
