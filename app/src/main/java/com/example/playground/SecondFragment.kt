package com.example.playground

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer

import com.example.playground.databinding.FragmentSecondBinding
import com.example.playground.viewmodels.DeliveryVM
import com.example.playground.viewmodels.ItemViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val deliveryViewModel : DeliveryVM by activityViewModels()

    private val testVM : ItemViewModel by activityViewModels()
    private var _binding: FragmentSecondBinding? = null
    private var counter : Int =0

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        deliveryViewModel.orderFlowDomain?.orderFlowState()?.observe(this.viewLifecycleOwner, Observer {
            Log.d("Orders2.0","order state in fragment : ${it?.orderState()?.value}")
            Toast.makeText(requireActivity(), "Current State : ${(it?.orderState()?.value)}", 2).show()
        })

        binding.buttonSecond.setOnClickListener {
           // findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

           //ItemClicked(counter++)
            triggerDeliveryFlow()
        }
    }

    fun ItemClicked(count:Int){
        testVM.selectItem(count.toString())
    }

    fun triggerDeliveryFlow(){

        deliveryViewModel.handlePlaceOrder(this)
    }
    override fun onDestroyView() {
        Log.d("Orders2.0", "second fragment is destroying")
        super.onDestroyView()
        _binding = null
    }

}