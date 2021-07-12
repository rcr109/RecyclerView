package rcr.projects.recyclerviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rcr.projects.recyclerviewapp.ContactDetail.Companion.EXTRA_CONTACT

class MainActivity : AppCompatActivity(), ClickItemContactListener {
    private val rvList: RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }

    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)
        initDrawer()
        bindViews()
        updateList()

    }

    private fun initDrawer(){
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun bindViews(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adapter.updateList(
            arrayListOf(
                Contact(
                    name = "Ricardo",
                    fone = "85-965325885",
                    photograph = "foto"
                ),
                Contact(
                    name = "José",
                    fone = "11-989585885",
                    photograph = "foto"
                ),
                Contact(
                    name = "Maria",
                    fone = "19-965325322",
                    photograph = "foto"
                ),
                Contact(
                    name = "Manoel",
                    fone = "14-655898532",
                    photograph = "foto"
                ),
                Contact(
                    name = "Julia",
                    fone = "71-863256324",
                    photograph = "foto"
                ),
                Contact(
                    name = "Marta",
                    fone = "21-536593222",
                    photograph = "foto"
                ),
                Contact(
                    name = "Roberta",
                    fone = "88-400056324",
                    photograph = "foto"
                ),
                Contact(
                    name = "Joana",
                    fone = "21-253636922",
                    photograph = "foto"
                )
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_menu_1 -> {
                showToast("Item 1 selecionado")
                return true
            }
            R.id.item_menu_2 -> {
                showToast("Item 2 selecionado")
                return true
            }
            R.id.item_menu_3 -> {
                showToast("Item 3 selecionado")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun clickItemContact(contact: Contact) {
        var intent = Intent(this, ContactDetail::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }
}
