package com.example.mar15_tabhost

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), ActionBar.TabListener{//TabLister를 장착한다는 의미: 나(mainactivity)자체가 리스너를 가진다. 인터페이스로 구현
//1. 멤버변수로 탭(=메뉴)
lateinit var tabSong : ActionBar.Tab
    lateinit var tabArtist : ActionBar.Tab
    lateinit var tabAlbum : ActionBar.Tab
    //프래그먼트 객체를 만든다.3개니까 객체배열로 만듬.널값세마리들어있는
    var myFrags = arrayOfNulls<MyTabFragment>(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //액션바 변수를 만든다.(연결한다. 새로만드는게 아니고, 액티비티에 있는것을 불러온다.)
        var bar = this.supportActionBar
        bar!!.navigationMode = ActionBar.NAVIGATION_MODE_TABS

        //2.액션바에 탭을 장착한다. (3개의 탭을 액션바에)
        tabSong = bar.newTab()
        tabSong.text = "음악별"
        tabSong.setTabListener(this)
        bar.addTab(tabSong)

        //2.액션바에 탭을 장착한다. (3개의 탭을 액션바에)
        tabArtist = bar.newTab()
        tabArtist.text = "가수별"
        tabArtist.setTabListener(this)
        bar.addTab(tabArtist)

        //2.액션바에 탭을 장착한다. (3개의 탭을 액션바에)
        tabAlbum = bar.newTab()
        tabAlbum.text = "앨범별"
        tabAlbum.setTabListener(this)
        bar.addTab(tabAlbum)
    }
    //내부(inner)클래스 자리에 프래그먼트를 만든다.
    class MyTabFragment : Fragment()  //Fragment라는 상속을 받아서 클래스를 만들어야 한다.
    {
        var tabName : String? = null

        //2가지 메소드를 재정의(override): onCreate()와 onCreateView() 이렇게 두가지
        //Bundle을 쓰는 것은 연결하기 위
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState) //super는 제일 윗쪽에 위치

            var data = arguments //부모인 Fragment클래스의 멤버
            //data를 통해서 os로 부터 탭의 이름을 알아낸다.(가져온다.)
            tabName = data!!.getString("tabName")
        }

        //onCreateView가 리니어레이아웃에 해당하는 부분
        //프래그먼트 안의 view를 만든다. => 프래그먼트 소속 layout을 만든다.
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            var params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT)
            var baseLayout = LinearLayout(super.getActivity())
            baseLayout.orientation = LinearLayout.VERTICAL
            baseLayout.layoutParams = params

            if(tabName === "음악별")
                baseLayout.setBackgroundColor(Color.RED)
            if(tabName === "가수별")
                baseLayout.setBackgroundColor(Color.GREEN)
            if(tabName === "앨범별")
                baseLayout.setBackgroundColor(Color.BLUE)
            //내가만든 레이아웃을 리턴
            return baseLayout
        }
    }

    override fun onTabReselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
    }

    override fun onTabUnselected(tab: ActionBar.Tab?, ft: FragmentTransaction?) {
    }

    override fun onTabSelected(tab: ActionBar.Tab?, ft: FragmentTransaction) {
        //탭을 클릭했을 때
        // //1)액티비티 안에 2)프래그먼트 안에 3)리니어레이아웃(뷰) 설정
        //사전 작업으로 프래그먼트를 준비한다.(미리 프래그먼트 객체를 만들어 놓는다)
        //프래그먼트배열(myFrags[]에 넣음, 1개짜리 프래그먼트객체(myTabFrag)만들기
        var myTabFrag : MyTabFragment? = null  //1개짜리

        if(myFrags[tab!!.position] == null)
        {
            //프래그먼트 배열안에 아무것도 없으면(프래그먼트객체가 없으면), 객체만들어서 넣는다.
            //반대로 있으면, 배열안에 있는 객체를 꺼낸다.
            myTabFrag = MyTabFragment()
            var data = Bundle()
            data.putString("tabName", tab.text.toString())
            myTabFrag.arguments = data
            //재사용을 위해서 frags배열에 넣는다.
            myFrags[tab.position] = myTabFrag
        }
        else //만약에frags배열이 null이 아니면, 이미 한번 사용을 했다면, 탭을 눌렀다면,
        {
            //frags배열에 있는 것을 꺼내서 사용
            myTabFrag = myFrags[tab.position]
        }
        ft.replace(android.R.id.content, myTabFrag!!) //null이 되면 안되어서 !!넣음


    }

}