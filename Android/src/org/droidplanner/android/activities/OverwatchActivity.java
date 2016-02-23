package org.droidplanner.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.droidplanner.android.R;

/**
 * Created by Daryl on 2/22/2016.
 */
public class OverwatchActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overwatch);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_overwatch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //On whichever click from the menu do one of the following
        switch ((id)) {
            case R.id.menu_bluetooth:
                try {
                    bluetoothSetupSwitchScreensClick();
                    break;
                } catch (Exception e) {
                    showMessage("bluetoothSetupSwitchScreensClick() E ERROR");
                }

                break;
            case R.id.menu_btcontroller:
                try {
                    bluetoothRemoteControlSwitchScreensClick();
                    break;
                } catch (Exception e) {
                    showMessage("bluetoothSerialCommunicationsSwi...() E ERROR");
                }
            default:
                ;
        }

        return super.onOptionsItemSelected(item);
    }

    //Method which prints a message in the form of a toast (Black Message Box) to the screen
    private void showMessage(String theMsg) {
        Toast msg = Toast.makeText(getBaseContext(),
                theMsg, (Toast.LENGTH_SHORT));
        msg.show();
    }

    //Method which creates the link to and start the Bluetooth Setup screen/activity
    public void bluetoothSetupSwitchScreensClick() throws Exception {
        Intent bluetoothSetupIntent = new Intent(OverwatchActivity.this, BluetoothSetup.class);
        startActivity(bluetoothSetupIntent);
    }

    //Method which creates the link to and start the Bluetooth Remote Control screen/activity
    public void bluetoothRemoteControlSwitchScreensClick() throws Exception{
        Intent bluetoothRemoteControlIntent = new Intent(OverwatchActivity.this, BluetoothRemoteControl.class);
        startActivity(bluetoothRemoteControlIntent);
    }
}
