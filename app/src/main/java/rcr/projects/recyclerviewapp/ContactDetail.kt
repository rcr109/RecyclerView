package rcr.projects.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_contact_detail.*

class ContactDetail : AppCompatActivity() {
    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

       // initToolbar()
       // getExtras()
       // bindViews()
    }

    private fun initToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    private fun bindViews(){
        tv_name.text = contact?.name
        findViewById<TextView>(R.id.tv_phone).text = contact?.fone

    }

    companion object{
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}