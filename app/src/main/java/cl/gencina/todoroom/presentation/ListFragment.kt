package cl.gencina.todoroom.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.gencina.todoroom.R
import cl.gencina.todoroom.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private val viewModel: ItemViewModel by activityViewModels()
    lateinit var binding: FragmentListBinding
    val adapter = ListItemAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container,false)
        initListeners()
        loadData()

        return binding.root
    }
    fun loadData(){
        viewModel.getAllItem().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }

    fun initListeners(){
        binding.rvListItems.adapter = adapter

        binding.fbAddItem.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addItemFragment)
        }
    }
}