package disiiy.khaper.dzikirapp.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import disiiy.khaper.dzikirapp.R
import disiiy.khaper.dzikirapp.adapter.DzikirDoaAdapter
import disiiy.khaper.dzikirapp.databinding.ActivityDzikirHarianBinding
import disiiy.khaper.dzikirapp.model.DataDzikirDoa
import disiiy.khaper.dzikirapp.model.DzikirDoa

class DzikirHarianActivity : AppCompatActivity() {

    private lateinit var dzikirHarianBinding: ActivityDzikirHarianBinding
    private var listDzikirDoaHarian : ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dzikirHarianBinding = ActivityDzikirHarianBinding.inflate(layoutInflater)
        setContentView(dzikirHarianBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        showRecyclerList()
        initData()
    }

    private fun initData() {
        val desc = resources.getStringArray(R.array.dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.terjemah_dzikir_doa_harian)

        listDzikirDoaHarian.clear()
        for (data in desc.indices){
            listDzikirDoaHarian.add(
                DzikirDoa(desc[data], lafaz[data], terjemah[data])
            )
        }
    }

    private fun showRecyclerList() {
        dzikirHarianBinding.rvDzikirHarian.setHasFixedSize(true)
        dzikirHarianBinding.rvDzikirHarian.layoutManager = LinearLayoutManager(this)
        dzikirHarianBinding.rvDzikirHarian.adapter = DzikirDoaAdapter(listDzikirDoaHarian)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    companion object{
        fun getLaunchService(from : Context) = Intent(from, DzikirHarianActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }

}