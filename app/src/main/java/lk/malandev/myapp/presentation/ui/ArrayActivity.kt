package lk.malandev.myapp.presentation.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import lk.malandev.myapp.presentation.viewmodels.MainViewModel
import lk.malandev.myapp.databinding.ActivityArrayBinding

@AndroidEntryPoint
class ArrayActivity : AppCompatActivity() {

    private lateinit var binding:ActivityArrayBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityArrayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainViewModel.getData()

//        val items = arrayOf("ABc1","Abc2","Abc3","Abc4","Abc5","Abc6","Abc7")
//
//        val adapter = ArrayAdapter(this,R.layout.simple_item,R.id.textViewItem,items)
//        binding.listView.adapter = adapter
//



        val customAdapter: CustomAdapter = CustomAdapter()

        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = customAdapter


        binding.swipeRefreshLayout.setOnRefreshListener {
            customAdapter.setUserList(emptyList())
            mainViewModel.getData()
        }

        mainViewModel.userListData.observe(this, Observer{user ->
            if(binding.swipeRefreshLayout.isRefreshing){
                binding.swipeRefreshLayout.isRefreshing = false
            }
            user?.let {
                customAdapter.setUserList(user.data)
            }

        })

    }
}