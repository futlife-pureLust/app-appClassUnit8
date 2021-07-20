package com.example.appclassunit8

//顯示RecyclerView之客製化頁面。因RecyclerView須搭配ViewHolder，因此須建一個繼承ViewHolder類別的Holder。


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
//手動import
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
/*
class MyAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adapter_row)
    }
}*/
//class MyAdapter(private val contacts:ArrayList<Content>) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){ <- <Content>是錯的，正確的是<Contact>
  class MyAdapter(private val contacts:ArrayList<Contact>) : RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    //ViewHolder類別，用來緩存畫面中的元件
    class ViewHolder(v:View):RecyclerView.ViewHolder(v){
        //宣告並連結畫面元件
        val tv_name: TextView = v.findViewById(R.id.tv_name)
        val tv_phone: TextView = v.findViewById(R.id.tv_phone)
        val img_delete: ImageView = v.findViewById(R.id.img_delete)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.adapter_row,viewGroup,false)
        return ViewHolder(v)
    }
    //回傳項目筆數
    override fun getItemCount() = contacts.size
    //連結項目資料與元件
    override fun onBindViewHolder(holder:ViewHolder,position:Int){
        holder.tv_name.text=contacts[position].name
        holder.tv_phone.text = contacts[position].phone

        holder.img_delete.setOnClickListener{
            //移除聯絡人
            contacts.removeAt(position)
            //更新列表資料
            notifyDataSetChanged()
        }
    }
}