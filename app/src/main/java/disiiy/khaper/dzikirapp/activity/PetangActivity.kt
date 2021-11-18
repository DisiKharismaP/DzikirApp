package disiiy.khaper.dzikirapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import disiiy.khaper.dzikirapp.R
import disiiy.khaper.dzikirapp.adapter.DzikirDoaAdapter
import disiiy.khaper.dzikirapp.databinding.ActivityPetangBinding
import disiiy.khaper.dzikirapp.model.DataDzikirDoa
import disiiy.khaper.dzikirapp.model.DzikirDoa

class PetangActivity : AppCompatActivity() {
    private lateinit var petangBinding: ActivityPetangBinding
    private var listDzikirDoa : ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        petangBinding = ActivityPetangBinding.inflate(layoutInflater)
        setContentView(petangBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        listDzikirDoa.clear()
        listDzikirDoa.addAll(DataDzikirDoa.listDzikirPetang)
        petangBinding.rvDzikirPetang.setHasFixedSize(true)
        petangBinding.rvDzikirPetang.layoutManager = LinearLayoutManager(this)
        petangBinding.rvDzikirPetang.adapter = DzikirDoaAdapter(listDzikirDoa)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object{
        fun getLaunchService(from : Context) = Intent(from, PetangActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
}