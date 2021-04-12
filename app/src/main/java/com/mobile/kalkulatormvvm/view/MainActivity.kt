package com.mobile.kalkulatormvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.mobile.kalkulatormvvm.R
import com.mobile.kalkulatormvvm.model.Hasil
import com.mobile.kalkulatormvvm.viewModel.ViewModelMainActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //inisialisasi
    lateinit var viewModel: ViewModelMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ViewModelMainActivity::class.java)

        //fungsi klik
        btnProses.setOnClickListener {

            //pangil viewmodel
            viewModel.onTambah(etBil1.text.toString(), etBil2.text.toString())
        }

        //membuat fungsi attachobserve
        attachObserve()
    }

    private fun attachObserve() {

        //observe bagian ishasil di viewmodelmainactivity
        viewModel.hasilSukses().observe(this, Observer { showHasil(it) })
        viewModel.bil1Kosong().observe(this, Observer { bil1Kosong(it) })
        viewModel.bil2Kosong().observe(this, Observer { bil2Kosong(it) })

    }

    //memanggil bil1 dan bil2 dari viewmodel
    private fun bil1Kosong(it: Boolean?) {
        if (it == true){
            Toast.makeText(applicationContext,"Harus Diisi di Bilangan 1",Toast.LENGTH_LONG).show()
        }
    }
    private fun bil2Kosong(it: Boolean?) {
        if (it == true){
            Toast.makeText(applicationContext,"Harus Diisi di Bilangan 2",Toast.LENGTH_LONG).show()
        }
    }

    private fun showHasil(it: Hasil?) {

        //memanggil text view untuk menampilkan hasil
        tvHasil.text = it?.result.toString()

    }
}