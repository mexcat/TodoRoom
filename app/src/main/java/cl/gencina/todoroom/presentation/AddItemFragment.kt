package cl.gencina.todoroom.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import cl.gencina.todoroom.R
import cl.gencina.todoroom.databinding.FragmentAddItemBinding

class AddItemFragment : Fragment() {

    private lateinit var binding : FragmentAddItemBinding
    private val viewModel: ItemViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddItemBinding.inflate(inflater, container, false)
        initListener()
        return binding.root
    }

    private fun initListener(){
        binding.btnAddItem.setOnClickListener{
            val nombre = binding.tieName.text.toString()
            val cantidad = binding.tieQuantity.text.toString().toInt()
            val precio = binding.tiePrice.text.toString().toInt()

            viewModel.insertItem(nombre, cantidad, precio)

            findNavController().navigate(R.id.action_addItemFragment_to_listFragment)

        }
    }
}