package kg.junesqo.m6l3hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import kg.junesqo.m6l3hw.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val list = intent.getStringArrayListExtra(MainActivity.KEY)
        binding.recycler.adapter = list?.let { Adapter(it, this::onClicked, this::onRemoved) }
        binding.recycler.layoutManager = GridLayoutManager(this, 3)

    }

    private fun onClicked(position: String) {

    }

    private fun onRemoved(position: String) {

    }
}