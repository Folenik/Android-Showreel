[33mcommit 2c1a5eb085fc2326a898ae3d005f19a36d8931ff[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m)[m
Author: Folenik <kamil.mosz12@gmail.com>
Date:   Fri Feb 28 15:18:02 2020 +0100

    Everything works. Waiting for fixes

[1mdiff --git a/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterEmailFragment.kt b/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterEmailFragment.kt[m
[1mindex bdc3181..c161f57 100644[m
[1m--- a/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterEmailFragment.kt[m
[1m+++ b/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterEmailFragment.kt[m
[36m@@ -1,11 +1,16 @@[m
 package com.folen.androidshowreel.fragment.registration[m
 [m
[32m+[m[32mimport android.content.Context.MODE_PRIVATE[m
[32m+[m[32mimport android.content.SharedPreferences[m
 import android.os.Bundle[m
 import android.view.LayoutInflater[m
 import android.view.View[m
 import android.view.ViewGroup[m
[32m+[m[32mimport android.widget.Toast[m
[32m+[m[32mimport android.widget.Toast.LENGTH_LONG[m
 import com.folen.androidshowreel.R[m
 import com.folen.androidshowreel.fragment.CustomFragmentWithInterface[m
[32m+[m[32mimport com.folen.androidshowreel.util.Const[m
 import kotlinx.android.synthetic.main.fragment_enter_email.*[m
 [m
 [m
[36m@@ -20,7 +25,23 @@[m [mclass EnterEmailFragment : CustomFragmentWithInterface() {[m
         super.onViewCreated(view, savedInstanceState)[m
 [m
         next_fragment_arrow.setOnClickListener {[m
[32m+[m[32m            checkIfEmailIsProper()[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    private fun checkIfEmailIsProper() {[m
[32m+[m[32m        if (android.util.Patterns.EMAIL_ADDRESS.matcher(enter_email_et.text.toString()).matches()) {[m
             mOnButtonClickListener.onButtonClicked()[m
[32m+[m[32m            putEmailToSharedPref(enter_email_et.text.toString())[m
[32m+[m[32m        } else if (enter_email_et.text.isNullOrEmpty()) {[m
[32m+[m[32m            Toast.makeText(context, getString(R.string.put_email), LENGTH_LONG).show()[m
[32m+[m[32m        } else {[m
[32m+[m[32m            Toast.makeText(context, getString(R.string.wrong_email), LENGTH_LONG).show()[m
         }[m
     }[m
[32m+[m
[32m+[m[32m    private fun putEmailToSharedPref(email: String) {[m
[32m+[m[32m        val prefs: SharedPreferences = activity!!.getSharedPreferences(Const.REGISTER_SHARED_PREF, MODE_PRIVATE)[m
[32m+[m[32m        prefs.edit().putString("email",email).commit()[m
[32m+[m[32m    }[m
 }[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterNicknameFragment.kt b/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterNicknameFragment.kt[m
[1mindex 218e0ea..7d8bb8c 100644[m
[1m--- a/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterNicknameFragment.kt[m
[1m+++ b/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterNicknameFragment.kt[m
[36m@@ -1,15 +1,20 @@[m
 package com.folen.androidshowreel.fragment.registration[m
 [m
[32m+[m[32mimport android.content.Context[m
[32m+[m[32mimport android.content.SharedPreferences[m
 import android.os.Bundle[m
 import android.view.LayoutInflater[m
 import android.view.View[m
 import android.view.ViewGroup[m
[32m+[m[32mimport android.widget.Toast[m
 import androidx.fragment.app.Fragment[m
 import com.folen.androidshowreel.R[m
 import com.folen.androidshowreel.fragment.CustomFragmentWithInterface[m
[32m+[m[32mimport com.folen.androidshowreel.util.Const[m
 import kotlinx.android.synthetic.main.fragment_choose_nickname.*[m
 import kotlinx.android.synthetic.main.fragment_enter_email.*[m
 import kotlinx.android.synthetic.main.fragment_enter_email.next_fragment_arrow[m
[32m+[m[32mimport kotlinx.android.synthetic.main.fragment_enter_password.*[m
 import kotlinx.android.synthetic.main.fragment_first.*[m
 [m
 class EnterNicknameFragment : CustomFragmentWithInterface() {[m
[36m@@ -21,10 +26,18 @@[m [mclass EnterNicknameFragment : CustomFragmentWithInterface() {[m
         super.onViewCreated(view, savedInstanceState)[m
 [m
         next_fragment_arrow.setOnClickListener {[m
[31m-            mOnButtonClickListener.onButtonClicked()[m
[32m+[m[32m            putNicknameToSharedPref(enter_nickname_et.text.toString())[m
         }[m
[31m-[m
     }[m
 [m
[31m-[m
[31m-}[m
\ No newline at end of file[m
[32m+[m[32m    private fun putNicknameToSharedPref(nickname: String) {[m
[32m+[m[32m        if(enter_nickname_et.text.isNullOrEmpty()) {[m
[32m+[m[32m            Toast.makeText(context, getString(R.string.put_nickname), Toast.LENGTH_LONG).show()[m
[32m+[m[32m        }[m
[32m+[m[32m        else {[m
[32m+[m[32m            val prefs: SharedPreferences = activity!!.getSharedPreferences(Const.REGISTER_SHARED_PREF, Context.MODE_PRIVATE)[m
[32m+[m[32m            prefs.edit().putString("nickname",nickname).commit()[m
[32m+[m[32m            mOnButtonClickListener.onButtonClicked()[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[1mdiff --git a/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterPasswordFragment.kt b/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterPasswordFragment.kt[m
[1mindex 61b97a5..f7eaf02 100644[m
[1m--- a/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterPasswordFragment.kt[m
[1m+++ b/app/src/main/java/com/folen/androidshowreel/fragment/registration/EnterPasswordFragment.kt[m
[36m@@ -1,14 +1,17 @@[m
 package com.folen.androidshowreel.fragment.registration[m
 [m
[32m+[m[32mimport android.content.Context[m
[32m+[m[32mimport android.content.SharedPreferences[m
 import android.os.Bundle[m
 import android.view.LayoutInflater[m
 import android.view.View[m
 import android.view.ViewGroup[m
[31m-import androidx.fragment.app.Fragment[m
[32m+[m[32mimport android.widget.Toast[m
 import com.folen.androidshowreel.R[m
 import com.folen.androidshowreel.fragment.CustomFragmentWithInterface[m
[32m+[m[32mimport com.folen.androidshowreel.util.Const[m
 import kotlinx.android.synthetic.main.fragment_enter_password.*[m
[31m-import kotlinx.android.synthetic.main.fragment_first.*[m
[32m+[m
 [m
 class EnterPasswordFragment : CustomFragmentWithInterface() {[m
     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {[m
[36m@@ -18,11 +21,24 @@[m [mclass EnterPasswordFragment : CustomFragmentWithInterface() {[m
     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {[m
         super.onViewCreated(view, savedInstanceState)[m
 [m
[31m-[m
         next_fragment_arrow.setOnClickListener {[m
[32m+[m[32m            checkIfPasswordIsProper()[m
[32m+[m[32m        }[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    private fun checkIfPasswordIsProper() {[m
[32m+[m[32m        if (enter_password_et.text.isNullOrEmpty()) {[m
[32m+[m[32m            Toast.makeText(context, getString(R.string.put_password), Toast.LENGTH_LONG).show()[m
[32m+[m[32m        } else {[m
             mOnButtonClickListener.onButtonClicked()[m
[32m+[m[32m            putPasswordToSharedPref(enter_password_et.text.toString())[m
         }[m
     }[m
 [m
[32m+[m[32m    private fun putPasswordToSharedPref(password: String) {[m
[32m+[m[32m        val prefs: SharedPreferences = activity!!.getSharedPreferences(Const.REGISTER_SHARED_PREF, Context.MODE_PRIVATE)[m
[32m+[m[32m        prefs.edit().putString("password", password).commit()[m
[32m+[m[32m    }[m
[32m+[m[32m}[m
[32m+[m
 [m
[31m-}[m
\ No newline at end of file[m
[1mdiff --git a/app/src/main/java/com/folen/androidshowreel/fragment/registration/ReEnterPasswordFragment.kt b/app/src/main/java/com/folen/androidshowreel/fragment/registration/ReEnterPasswordFragment.kt[m
[1mindex c3882ce..b653a49 100644[m
[1m--- a/app/src/main/java