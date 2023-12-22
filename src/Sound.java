
/**
 * Name: K M Ashfak Alam Siam

 * 
 * Section: c
 * 
 * Project 4
 * 
 * 
 */

import java.io.File;

import java.net.URL;

import javax.sound.sampled.*;

/**
 * 
 * This class creates background sound and sound effects
 *
 */

public class Sound {

	private Clip clip;
	private File[] soundURL = new File[30];
	File file = new File("ThemAudio.wav");
	File file2 = new File("Shooting.wav");
	File file3 = new File("Points.wav");

	/**
	 * 
	 * This class puts value in the soundURL array
	 * 
	 */

	public Sound() {
		soundURL[0] = file;
		soundURL[1] = file2;
		soundURL[2] = file3;

	}

	/**
	 * Sets the sound Files.
	 * 
	 * @param Integer Index of array.
	 */

	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Starts the Music
	 * 
	 */

	public void play() {
		if (clip == null) {
			setFile(0);
		}
		clip.start();
	}

	/**
	 * Creats a loop to continue the Music
	 * 
	 */

	public void loop() {
		if (clip == null) {
			setFile(0);
		}
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	/**
	 * Stops the Music
	 * 
	 */

	public void stop() {
		if (clip != null) {
			clip.stop();
		}
	}
}
