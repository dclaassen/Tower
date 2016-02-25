package org.droidplanner.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import org.droidplanner.android.R;

public class OverwatchActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overwatch);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_overwatch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        //On whichever click from the menu do one of the following
        switch ((id)) {
            case R.id.select_bluetooth_setup_activity:
                try {
                    bluetoothSetupSwitchScreensClick();
                    break;
                } catch (Exception e) {
                    showMessage("bluetoothSetupSwitchScreensClick() E ERROR");
                }

                break;
            case R.id.select_bluetooth_remote_control_activity:
                try {
                    bluetoothRemoteControlSwitchScreensClick();
                    break;
                } catch (Exception e) {
                    showMessage("bluetoothRemoteControlSwitchScreensClick() E ERROR");
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
