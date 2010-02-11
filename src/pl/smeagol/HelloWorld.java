package pl.smeagol;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HelloWorld extends Activity {
    /** Called when the activity is first created. */
	
	private NotificationManager mManager = null;
	private EditText mText = null;
	private static int mId = 8888;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
   
        mText = (EditText)findViewById(R.id.edtTekst);
        mManager = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
    }
    @Override
    protected void onDestroy() {
    	mManager.cancel(mId);
    	super.onDestroy();
    }
    public void przycisk1(View zal) {
    	String sText = mText.getText().toString();
    	long lTime = System.currentTimeMillis();
    	Notification n = new Notification(R.drawable.icon, sText, lTime);
    	PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, HelloWorld.class), 0);
    	n.setLatestEventInfo(this, getText(R.string.app_name),sText,contentIntent);
    	mManager.notify(mId, n);
    }
    public void wywal(View pozdro) {
    	mManager.cancel(mId);
    }

    
    /*public void onClick(View v) {
    	String sText = mText.getText().toString();
    	long lTime = System.currentTimeMillis();
    	Notification n = new Notification(R.drawable.icon, sText, lTime);
    	PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, HelloWorld.class), 0);
    	n.setLatestEventInfo(this, getText(R.string.app_name),sText,contentIntent);
    	mManager.notify(mId, n);
    }
    */
}