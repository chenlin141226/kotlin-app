package com.example.user.mykotlin.ui.fragment


import com.example.user.mykotlin.adapter.HomeAdapter
import com.example.user.mykotlin.base.BaseListAdapter
import com.example.user.mykotlin.base.BaseListFragment
import com.example.user.mykotlin.base.BaseListPresenter
import com.example.user.mykotlin.presenter.impl.HomePresenterImpl
import com.example.user.mykotlin.widget.HomeItemView
import com.itheima.player.model.bean.HomeItemBean



class HomeFragment :BaseListFragment<List<HomeItemBean>,HomeItemBean,HomeItemView>(){
    override fun getSpecialAdapter(): BaseListAdapter<HomeItemBean, HomeItemView> {
        return  HomeAdapter()
    }

    override fun getSpecialPresenter(): BaseListPresenter {
        return HomePresenterImpl(this)

    }

    override fun getList(response: List<HomeItemBean>?): List<HomeItemBean>? {
         return  response
    }

    override fun onDestroyView() {
    super.onDestroyView()
    //解绑presenter
    presenter.destoryView()
}

}