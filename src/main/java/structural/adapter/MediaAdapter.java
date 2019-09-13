package structural.adapter;

public class MediaAdapter implements MediaPlayer {
    private AdvanceMediaPlayer advanceMediaPlayer;
    @Override
    public void play(String audioType, String fileName) {
        //播放 mp3 音乐文件的内置支持
        if(audioType.equalsIgnoreCase("mp4")){
            advanceMediaPlayer.playMp4(fileName);
        } else {
            advanceMediaPlayer.playVlc(fileName);        }
    }

    public MediaAdapter(String audioType) {
        switch (audioType) {
            default:
                this.advanceMediaPlayer = null;
        }
    }
}
