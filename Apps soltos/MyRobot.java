package nycdev;
import robocode.*;
import java.awt.Color;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * MyRobot - a robot by (your name here)
 */
public class MyRobot extends Robot {

	int moveDirection;
	int turnDirection;
	int aimX, aimY;
	int firePower;
	/**
	 * run: MyRobot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop

		setBodyColor(new Color(0, 148, 186));
		setBulletColor(new Color(105, 79, 186));
		setRadarColor(new Color(0, 79, 186));

		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(2);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(160);
		back(20);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		ahead(40);
		turnRight(160);
		back(20);	
	}
	
	public void onRoundEnded(RoundEndedEvent event) {
		turnRadarRight(800);
	}
}
