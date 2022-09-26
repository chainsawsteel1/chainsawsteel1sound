package jp.chainsawsteel1.chainsawsteel1sound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int sound1, sound2, sound3;
    private Button button1, button2, button3, button4;
    private ImageView imageView1;
    private final String accessUri = "https://twitter.com/chainsawsteel1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(100)
                .build();

        sound1  = soundPool.load(this, R.raw.one, 1);
        sound2  = soundPool.load(this, R.raw.two, 1);
        sound3  = soundPool.load(this, R.raw.three, 1);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        imageView1 = findViewById(R.id.imageView1);

        button1.setOnClickListener( v -> {
            soundPool.play(sound1, 1f, 1f, 0, 0, 1);

        });

        button3.setOnClickListener( v -> {
            soundPool.play(sound2, 1f, 1f, 0, 0, 1);
        });

        button4.setOnClickListener( v -> {
            soundPool.play(sound3, 1f, 1f, 0, 0, 1);
        });

        button2.setOnClickListener( v -> {
            RotateAnimation imgRotate = new RotateAnimation(
                    0, 360, (float) (imageView1.getWidth()/2), (float) (imageView1.getHeight()/2));
            imgRotate.setDuration(300);
            imageView1.startAnimation(imgRotate);
            Uri uri = Uri.parse(accessUri);
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        });
    }
}