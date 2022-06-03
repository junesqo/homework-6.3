package kg.junesqo.m6l3hw

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import kg.junesqo.m6l3hw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY = "key"
    }

    private val imageList = arrayListOf<String>()
    private val list = arrayListOf<String>()
    private lateinit var adapter: Adapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()

    }

    private fun initView() {
        adapter = Adapter(allImages(), this::onClicked, this::onRemoved)
//        adapter.setOnClick(this)
        binding.recycler.layoutManager = GridLayoutManager(this, 3)
        binding.recycler.adapter = adapter
    }

    private fun allImages(): ArrayList<String> {
        imageList.add("https://i.pinimg.com/564x/e2/27/ac/e227ac5225346041d088e02b62a78260.jpg")
        imageList.add("https://i.pinimg.com/564x/8c/78/e2/8c78e2952d8c081d00d3dbfb90f3d8ad.jpg")
        imageList.add("https://i.pinimg.com/564x/e7/15/e7/e715e7f25b881399e6faa9bd877ef1be.jpg")
        imageList.add("https://i.pinimg.com/564x/a9/c3/13/a9c3131bc8f19e9066efa1298dc466b4.jpg")
        imageList.add("https://i.pinimg.com/564x/21/50/b9/2150b972c3e9b76d3b0b6480d4793ab5.jpg")
        imageList.add("https://i.pinimg.com/750x/17/82/29/178229094996f60642c5025cb36155e3.jpg")
        imageList.add("https://i.pinimg.com/564x/bf/c0/bc/bfc0bc3345a7e56fdb20af17e3ebaf30.jpg")
        imageList.add("https://i.pinimg.com/564x/1e/b5/d7/1eb5d7af622d44ef1505fac279f85be2.jpg")
        imageList.add("https://i.pinimg.com/564x/9f/c4/a2/9fc4a2f3cd35d07342c4b032d9c72173.jpg")
        imageList.add("https://i.pinimg.com/564x/ff/d6/59/ffd6599f26815fc3acc1e05758d3f28a.jpg")
        imageList.add("https://i.pinimg.com/564x/ad/34/32/ad3432dee6450bcc578d46ade9470fe2.jpg")
        imageList.add("https://i.pinimg.com/564x/bf/c0/bc/bfc0bc3345a7e56fdb20af17e3ebaf30.jpg")
        imageList.add("https://i.pinimg.com/564x/a9/c3/13/a9c3131bc8f19e9066efa1298dc466b4.jpg")
        imageList.add("https://i.pinimg.com/750x/17/82/29/178229094996f60642c5025cb36155e3.jpg")
        imageList.add("https://i.pinimg.com/564x/ad/34/32/ad3432dee6450bcc578d46ade9470fe2.jpg")

        return imageList
    }

    fun onClicked(position: String) {
        binding.cardView.visibility = View.VISIBLE
        binding.finishBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(KEY, list)
            startActivity(intent)
        }
        list.add(position)
    }

    fun onRemoved(position: String) {
        binding.cardView.visibility = View.GONE
        list.remove(position)
    }
}