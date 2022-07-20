package com.example.nav_recycler_task.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nav_recycler_task.R
import com.example.nav_recycler_task.adapters.ChildAdopter
import com.example.nav_recycler_task.adapters.ParentAdopter
import com.example.nav_recycler_task.databinding.FragmentTab1Binding
import com.example.nav_recycler_task.models.ItemDetails


class Tab1Fragment : Fragment(), ChildAdopter.OnItemClickListener {

    private var _binding : FragmentTab1Binding? = null
    private val binding get() = _binding!!
    private var itemDetails = ArrayList<ItemDetails>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
            _binding = DataBindingUtil.inflate(inflater ,R.layout.fragment_tab1, container, false)

        itemDetails = arrayListOf(
            ItemDetails("https://images.pexels.com/photos/302743/pexels-photo-302743.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1","Sunset","Sunset, also known as sundown, is the daily disappearance of the Sun below the horizon due to Earth's rotation. As viewed from everywhere on Earth (except the North and South poles), the equinox Sun sets due west at the moment of both the Spring and Autumn equinox. As viewed from the Northern Hemisphere, the sun sets to the northwest (or not at all) in the Northern hemisphere's spring and summer, and to the southwest in the autumn and winter; these seasons are reversed for the Southern Hemisphere."),
            ItemDetails("https://s-media-cache-ak0.pinimg.com/originals/f2/b5/f2/f2b5f2aeb31e079f7e48ac0c338a8507.jpg","BasketBall","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by"),
            ItemDetails("https://i.dailymail.co.uk/i/pix/2015/09/24/17/2CB89DDF00000578-0-image-a-1_1443111464150.jpg","Kobe","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by"),
            ItemDetails("https://cdn-s3.si.com/s3fs-public/si/dam/assets/13/02/13/130213172915-michael-jordan-05717484-single-image-cut.jpg","Kobe","There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200"),
            ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","Kobe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","Kobe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","Kobe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","Kobe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","Kobe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","Kobe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","Kobe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","Kobe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","Kobe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","Kobe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
            ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","Kobe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")

            )



        val parentAdopter = ParentAdopter(itemDetails,this)
        binding.tab1RecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.tab1RecyclerView.adapter = parentAdopter

        return binding.root
    }

    override fun onItemClickDetails(position: Int) {
        Toast.makeText(requireContext(), "Clicked on $position", Toast.LENGTH_SHORT).show()
        val fragmentManger = parentFragment?.childFragmentManager
        val fragmentTransaction = fragmentManger?.beginTransaction()
        val detailsFragment = DetailsFragment()
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.add(R.id.tab1Id,detailsFragment)?.commit()

        val bundles = Bundle()
//        bundles.putString("Image",itemDetails[position].imageUrl)
//        bundles.putString("Title",itemDetails[position].Title)
//        bundles.putString("Desc",itemDetails[position].Description)

        val details = itemDetails[position]
        Log.e("Details",details.toString())
            //ItemDetails("https://www.researchgate.net/profile/Pablo-Caballero-2/publication/328101815/figure/fig18/AS:678371704987657@1538747826575/The-sample-clean-image-200X200-pixels.ppm","KOBY"," kjv wkav ckjascjkqasv kenas wjkvs halbscasw jw fwhe is cweufweiwfgwfgiwea nwkfwpsgxwAOVuasncwn WA")
        bundles.putSerializable("key",details)
        detailsFragment.arguments = bundles
    }


}