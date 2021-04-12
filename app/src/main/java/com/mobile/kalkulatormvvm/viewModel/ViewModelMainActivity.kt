package com.mobile.kalkulatormvvm.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobile.kalkulatormvvm.model.Hasil
import com.mobile.kalkulatormvvm.repo.Repository

//extend terlebih dahulu dari viewmodel
class ViewModelMainActivity : ViewModel() {

    //inisialisasi repo
    val repository = Repository()

    var isHasil = MutableLiveData<Hasil>()

    var bil1Kosong = MutableLiveData<Boolean>()

    var bil2Kosong = MutableLiveData<Boolean>()

    //fungsi
    fun onTambah(bil1 : String, bil2 : String) {

        if (bil1.isEmpty())
        {
            bil1Kosong.value = true
        }else if (bil2.isEmpty()){
            bil2Kosong.value = true

        }else{
            repository.tambah(bil1,bil2)
            {

                isHasil.value = it

            }
        }

    }

    fun hasilSukses():LiveData<Hasil>{
        return isHasil
    }

    fun bil1Kosong ():LiveData<Boolean>{
        return bil1Kosong
    }

    fun bil2Kosong ():LiveData<Boolean>{
        return bil2Kosong
    }
}