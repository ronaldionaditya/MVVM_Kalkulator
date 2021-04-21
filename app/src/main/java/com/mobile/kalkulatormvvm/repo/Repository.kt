package com.mobile.kalkulatormvvm.repo

import com.mobile.kalkulatormvvm.model.Hasil

class Repository {

    //inisialisasi
    val model = Hasil()

    //bisnis logic
    //dengan 2 parameter dan objek result dari jumlah 2 parameter tersebut
    fun tambah(bil1: String, bil2: String, result: (Hasil) -> Unit){

        var bebas1 = bil1.toInt()
        var bebas2 = bil2.toInt()

        //operasi
        model.result = bebas1.plus(bebas2)
        result(model)
    }

    fun kurang(bil1: String, bil2: String, result: (Hasil) -> Unit){
        var bebas1 = bil1.toInt()
        var bebas2 = bil2.toInt()

        model.result = bebas1.minus(bebas2)
        result(model)
    }

    fun kali(bil1: String, bil2: String, result: (Hasil) -> Unit){
        var bebas1 = bil1.toInt()
        var bebas2 = bil2.toInt()

        model.result = bebas1.times(bebas2)
        result(model)
    }

    fun bagi(bil1: String, bil2: String, result: (Hasil) -> Unit){
        var bebas1 = bil1.toInt()
        var bebas2 = bil2.toInt()

        model.result = bebas1.div(bebas2)
        result(model)
    }
}