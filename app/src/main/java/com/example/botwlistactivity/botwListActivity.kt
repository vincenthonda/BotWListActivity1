package com.example.botwlistactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.botwlistactivity.databinding.ActivityBotwListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class botwListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBotwListBinding
    lateinit var adapter: botwAdapter

    companion object {
        val TAG = "botwListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBotwListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var botwList = mutableListOf<botwItem>()
        //botwList.add(
        //                Vaccination(
        //                    "Fake 1", sortedMapOf<String, Int>(
        //                        Pair("1/23/22", 100),
        //                        Pair("1/24/22", 105),
        //            Pair("1/25/22", 110)
        //        )
        //    )
        //)
        //botwList.add(
        //    Vaccination(
        //        "Fake 2", sortedMapOf<String, Int>(
        //            Pair("1/23/22", 500000),
        //            Pair("1/24/22", 600000),
        //            Pair("1/25/22", 700000),
        //)
        //            Pair("1/20/22", 600000),
        //        )
        //    )

        val botwApi = RetrofitHelper.getInstance().create(BotwService::class.java)
        val botwCall = botwApi.get(10)jjjj

        botwCall.enqueue(object : Callback<List<botwItem>> {
            override fun onResponse(
                call: Call<List<botwItem>>,
                response: Response<List<botwItem>>
            ) {
                Log.d(TAG, "onResponse: ${response.body()}")
                botwList = (response.body()
                    ?: mutableListOf<botwDetailActivity>()) as MutableList<botwItem>
                adapter = botwAdapter(botwList)
                binding.recyclerViewBotwLIst.adapter = adapter
                binding.recyclerViewBotwLIst.layoutManager =
                    LinearLayoutManager(this@botwListActivity)
            }

            override fun onFailure(call: Call<List<botwItem>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        }
        )
    }
    //override fun onOptionsItemSelected(item: MenuItem): Boolean {
    //    // Handle item selection
    //    return when (item.itemId) {
    //        R.id.sortby_name -> {
    //            adapter.dataSet = adapter.dataSet.sortedBy {
    //                it.country.compareTo("test")
    //            }
    //            adapter.notifyDataSetChanged()
    //            true
    //        }
    //        R.id.sortby_lastTen -> {
    //            adapter.dataSet = adapter.dataSet.sortedBy {
    //                (it.timeline.get(it.timeline.lastKey()?:0L))?.minus(it.timeline.get(it.timeline.firstKey())?: 0L)
    //            }
    //            adapter.notifyDataSetChanged()
    //            true
    //        }
    //        R.id.sortby_total -> {
    //            adapter.dataSet = adapter.dataSet.sortedByDescending {
    //                it.timeline.get(it.timeline.lastKey()?: 0L)
    //            }
    //            adapter.notifyDataSetChanged()
    //            true
    //        }
    //        else -> super.onOptionsItemSelected(item)
    //    }
    //}
}