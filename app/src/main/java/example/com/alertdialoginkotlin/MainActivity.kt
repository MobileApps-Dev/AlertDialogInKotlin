package example.com.alertdialoginkotlin

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var alert_simple: Button
    lateinit var alert_custom: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialization views ID´s
        alert_simple = findViewById(R.id.alert_simple) as Button
        alert_custom = findViewById(R.id.alert_custom) as Button

        // onClick on Button
        alert_simple.setOnClickListener({

            // Display Default alert dialog
            val builder = AlertDialog.Builder(this) // Declare alert dialog
            builder.setTitle("Are You Sure") // set title
            builder.setMessage("Do you want to close the app") //set message
            // set positive button
            builder.setPositiveButton("Yes", { dialogInterface: DialogInterface, i: Int ->
                finish()
            })
            // set negative button
            builder.setNegativeButton("No", { dialogInterface: DialogInterface, i: Int -> })
            // show dialog
            builder.show()
        })

        // on click on button
        alert_custom.setOnClickListener({

            // Display custom  alertdialog
            val dialog = AlertDialog.Builder(this@MainActivity) // declare alert dialog
            val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null) // add custom xml to dialog
            var edt_data = dialogView.findViewById<EditText>(R.id.edt_data) // declare view
            dialog.setView(dialogView) // set custom view to alert dialog
            dialog.setCancelable(false)
            // set button
            dialog.setPositiveButton("Validation", { dialogInterface: DialogInterface, i: Int -> })
            //    dialog.show()
            //create custom dialog
            val customDialog = dialog.create()
            // show custom dialog
            customDialog.show()
            // click on button
            customDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener({
                // check validation
                if (edt_data.text.length > 5) {
                    customDialog.dismiss() // dismiss dialog
                } else {
                    Toast.makeText(this@MainActivity, "Enter value", Toast.LENGTH_SHORT).show()
                }
            })
        })
    }
}
