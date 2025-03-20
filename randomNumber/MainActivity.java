package com.example.ramdomnum;  // 패키지명 철자 수정

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;  // Random 클래스 import 추가

public class MainActivity extends AppCompatActivity {

    private TextView textViewRandomNumber;  // TextView 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // TextView 연결
        textViewRandomNumber = findViewById(R.id.textViewRandomNumber);

        // 레이아웃 패딩 조정 (ID가 있는지 확인 필요)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // 난수를 생성하는 메서드는 onCreate 바깥에 선언해야 함
    public void generateRandomNumber(View view) {
        Random random = new Random();
        int randomNumber = random.nextInt(100); // 0부터 99까지의 난수 생성

        // 텍스트 뷰에 난수 표시
        textViewRandomNumber.setText("난수: " + randomNumber);
    }
}
