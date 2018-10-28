package ru.yandex.dunaev.mick.githubusers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.yandex.dunaev.mick.githubusers.databinding.CardModelBinding

class ModelAdapter : RecyclerView.Adapter<ModelHolder>() {

    private val users = mutableListOf<User>()

    fun setUsers(u : List<User>) {
        with(users){
            clear()
            addAll(u)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<CardModelBinding>(inflater,R.layout.card_model,parent,false)
        return ModelHolder(binding)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ModelHolder, position: Int) {
        holder.bind(users[position])
    }

}

class ModelHolder(val cardUser: CardModelBinding) : RecyclerView.ViewHolder(cardUser.root) {
    fun bind(user: User) = with(cardUser) {
        setUser(user)
        executePendingBindings()
    }
}
