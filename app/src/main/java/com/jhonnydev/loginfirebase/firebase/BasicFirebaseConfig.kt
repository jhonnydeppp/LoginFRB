package com.jhonnydev.loginfirebase.firebase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.jhonnydev.loginfirebase.models.UserResponse
import io.reactivex.Observable as Observable1

class BasicFirebaseConfig {
    private val db = FirebaseFirestore.getInstance()
    private val TAG = javaClass.simpleName
    lateinit var  fbData: FbDataInterface

    var userList:MutableList<UserResponse> = mutableListOf()
    val userTest: UserResponse = UserResponse("Lovelace","12345","Ada","123",
    "direccion")

    fun init(fbData: FbDataInterface){
        this.fbData = fbData
    }

    //fun newUser(userRes: UserResponse){
    fun newUser(){
        val user = hashMapOf(
            "address" to userTest.address,
            "name" to userTest.name,
            "password" to userTest.password,
            "phone" to userTest.phone,
            "user" to userTest.user
        )

        db.collection("MyDb")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    fun getUser(){
        val mList = mutableListOf<UserResponse>()
        db.collection("MyDb")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    mList.add(
                        UserResponse(
                            document.data.getValue("user").toString(),
                        document.data.getValue("password").toString(),
                        document.data.getValue("name").toString(),
                        document.data.getValue("phone").toString(),
                        document.data.getValue("address").toString())
                    )
                    Log.d(TAG, "$mList")
                    Log.d(TAG, "${document.id} => ${document.data.getValue("user")}")
                    fbData.getLogitData(mList)
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }


}

interface FbDataInterface{
    fun getLogitData(list :List<UserResponse>)
}