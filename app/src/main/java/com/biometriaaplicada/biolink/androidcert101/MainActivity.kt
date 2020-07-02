package com.biometriaaplicada.biolink.androidcert101

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.biometriaaplicada.biolink.androidcert101.databinding.ActivityMainBinding
import com.biometriaaplicada.biolink.androidcert101.databinding.ToastCustomBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { VersionAdapter() }

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recycler.adapter = adapter
        setData()

        binding.btnMainAdd.setOnClickListener { addMore() }
        binding.btnMainShow.setOnClickListener { showDetails() }

//        binding.button.setOnClickListener { showToast() }
    }

    private fun showDetails() {
        val total = binding.recycler.adapter?.itemCount ?: 0
        val last = adapter.dataSource.lastOrNull()
        val toastBinding = ToastCustomBinding.inflate(layoutInflater)
        toastBinding.tvToastTitle.text = "Total de elementos $total"
        last?.let {
            toastBinding.tvToastContent.text = "Último: Android ${last.number} - ${last.name}"
        }

        Toast(this).apply {
            view = toastBinding.root
            duration = Toast.LENGTH_LONG
            setGravity(Gravity.BOTTOM or Gravity.START, 64, 64)
            show()
        }
    }

    private fun setData() {
        val data = mutableListOf(
            Version(Color.WHITE, "Android 1", 1f),
            Version(Color.WHITE, "Android 1.1", 1.1f),
            Version(Color.WHITE, "Cupcake", 1.5f),
            Version(Color.WHITE, "Donut", 1.6f),
            Version(Color.WHITE, "Eclair", 2f),
            Version(Color.WHITE, "Froyo", 2.2f),
            Version(Color.WHITE, "Gingerbread", 2.3f),
            Version(Color.WHITE, "Honeycomb", 3.0f),
            Version(Color.WHITE, "Ice Cream Sandwich", 4.0f),
            Version(Color.WHITE, "Jelly Bean", 4.1f),
            Version(Color.WHITE, "Kit Kat", 4.4f),
            Version(Color.WHITE, "Lollipop", 5f),
            Version(Color.WHITE, "Marshmallow", 6f),
            Version(Color.WHITE, "Nougat", 7f),
            Version(Color.WHITE, "Oreo", 8f),
            Version(Color.WHITE, "Pie", 9f),
            Version(Color.WHITE, "Q", 10f)
        )
        adapter.dataSource = data.toMutableList()

    }

    private fun addMore() {
        val last = adapter.dataSource.lastOrNull()
        last?.let {
            val version = it.number + 1
            adapter.dataSource.add(Version(Color.LTGRAY, "Android $version", version))
            adapter.notifyDataSetChanged()
        }
    }

    private fun showToast() {
        /*Toast.makeText(this, "Hi buddy", Toast.LENGTH_LONG).apply {
            setGravity(Gravity.BOTTOM or Gravity.START, 0, 0)
            show()
        }*/

        /*val layout = layoutInflater.inflate(R.layout.toast_custom, clMainRoot, false)
        val toastTitle = layout.findViewById<TextView>(R.id.tvToastTitle)
        val toastContent = layout.findViewById<TextView>(R.id.tvToastContent)
        toastTitle.text = "Welcome"
        toastContent.text = "Have a nice day "*/

        val toastBinding = ToastCustomBinding.inflate(layoutInflater)
        toastBinding.tvToastTitle.text = "Welcome"
        toastBinding.tvToastContent.text = "Have a nice day"

        Toast(this).apply {
            view = toastBinding.root
            duration = Toast.LENGTH_LONG
            show()
        }

    }

}
