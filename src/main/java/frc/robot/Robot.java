// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.components.Controller;
import frc.robot.components.DriveFrame;
import frc.robot.data.StickPosition;

public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private final Controller controller;
  private final DriveFrame driveFrame;

  public Robot() {
    controller = new Controller();
    driveFrame = new DriveFrame();
  }

  @Override
  public void robotPeriodic() {}


  @Override
  public void autonomousInit() {}

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    StickPosition left_joystick = controller.getLeftStickPosition(); // Ici, le code va chercher la position du joystick gauche de la manette et va le stocker dans une variable
    StickPosition right_Joystick = controller.getRightStickPosition();
    // TODO: Créer une variable right_joystick de type StickPosition pour le joystick droit
    // TODO: Créer une variable both_sticks de type Stickposition qui contient la donnée x tu stick droit et x du stick gauche
    StickPosition both_sticks = new StickPosition(right_Joystick.x(),left_joystick.y());
    driveFrame.singleStickDrive( both_sticks ); // Le code veut envoyer la variable both_sticks au drive frame, mais elle n'existe pas, vous devez donc la créer
  }
  

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {
  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
