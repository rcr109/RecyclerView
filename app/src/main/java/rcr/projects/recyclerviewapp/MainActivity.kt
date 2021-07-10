package rcr.projects.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import rcr.projects.recyclerviewapp.adapter.Contact
import rcr.projects.recyclerviewapp.adapter.ContactAdapter

class MainActivity : AppCompatActivity() {
    private val rvList: RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        updateList()
    }

    private fun bindView(){
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
                    fone = "11-98585885",
                    photograph = "foto"
                ),
                Contact(
                    name = "Maria",
                    fone = "19-965325322",
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
}
