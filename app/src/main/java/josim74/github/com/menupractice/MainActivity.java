package josim74.github.com.menupractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // override method to attach menu to the main activity...
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;

    }

    //to hide menu item....
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem loginItem = menu.findItem(R.id.menu_item_login);
        MenuItem logoutItem = menu.findItem(R.id.menu_item_logout);
        if (isLogin) {
            loginItem.setVisible(false);
            logoutItem.setVisible(true);
        }else {
            loginItem.setVisible(true);
            logoutItem.setVisible(false);
        }

        return super.onPrepareOptionsMenu(menu);
    }

    //when item selected...
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_login:
                isLogin = true;
                break;
            case R.id.menu_item_logout:
                isLogin=false;
                break;
                default:
                    break;
        }
        return super.onOptionsItemSelected(item);
    }

    // COntext menu Example
    public void selectColor(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.color_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.color_menu_red:
                        Toast.makeText(MainActivity.this, "Red Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.color_menu_green:
                        Toast.makeText(MainActivity.this, "Green Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.color_menu_blue:
                        Toast.makeText(MainActivity.this, "Blue Selected", Toast.LENGTH_SHORT).show();
                        break;
                        default:
                            break;
                }
                return false;
            }
        });
        popupMenu.show();



    }
}
