package com.example.intentandvote

import android.media.Rating
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        title = "투표 결과"
        //앞 화면에서 보낸 투표 결과 값을 받는다.
        var intent = intent
        var voteResult = intent.getIntArrayExtra("VoteCount")
        var imageName = intent.getStringArrayExtra("ImageName")
        //9개의 열tv, ratingbar객체배
        //텍스트뷰의 id를 저장한 배열 변수, 레이팅바의 id를 저장한 배열 변수를 선언
        var tv = arrayOfNulls<TextView>(imageName!!.size)
        var rbar = arrayOfNulls<RatingBar>(imageName!!.size)
        //객체 만들고, 바인딩
        val tvMax = findViewById<TextView>(R.id.tvMax)
        val ivMax = findViewById<ImageView>(R.id.ivMax)
        //최다 득표수의 그림명과 그림을 구하기 위해서 , voteresult의 최다득표수위치(인덱스)를 찾는다.
// 방법1. max변수를 사용
//        var max = 0;
//        var maxIndex = 0;
//        for(i in 0..voteResult!!.size-1)
//        {
//            if(voteResult[i] > max)
//            {
//                max = voteResult[i]
//                maxIndex = i
//            }
//        }
        //방법2. maxIndex사용
        var maxIndex = 0
        for(i in 0..voteResult!!.size-1)
            if(voteResult[i]>voteResult[maxIndex])
                maxIndex = i

        var ImageField = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                                            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                                            R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)
        tvMax.text = imageName[maxIndex]
        ivMax.setImageResource(ImageField[maxIndex])
        //XML 파일의 텍스트뷰와 레이팅바를 위젯 변수에 대입
        var tvID = arrayOf(R.id.iv1, R.id.iv2, R.id.iv3,
                            R.id.iv4, R.id.iv5, R.id.iv6,
                            R.id.iv7, R.id.iv8, R.id.iv9)
        var rbarID = arrayOf(R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                      R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9)
        //텍스트뷰 위젯 변수에 넘겨받은 그림 파일 이름을 적용, 레이팅바에는 넘겨받은 투표 결과를 적용
        for (i in voteResult!!.indices) {
            tv[i] = findViewById<TextView>(tvID[i])
            rbar[i] = findViewById<RatingBar>(rbarID[i])
        }
        for (i in voteResult.indices) {
            tv[i]!!.setText(imageName[i])
            rbar[i]!!.setRating(voteResult[i].toFloat())
        }
        //버튼을 클릭하면 서브 액티비티 종료
        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }
    }
}
