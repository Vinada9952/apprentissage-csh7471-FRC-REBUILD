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
    StickPosition left_joystick = controller.getLeftStickPosition();
    // pour rendre ton code plus "joli", ne met pas d'espaces ici
    StickPosition right_joystick = controller.getRightStickPosition(); // et met en un juste après cette ligne
    StickPosition both_sticks    = new StickPosition(right_joystick.x(),left_joystick.y()); // fait attention aux espaces devant tes =, c'est mieux et plus lisible de ne pas les mettres
    driveFrame.singleStickDrive( both_sticks );

    /*
     * Pourquoi est ce qu'il faut faire attentions à ces espace :
     * 1. Pour rendre le code plus lisible
     * 2. Pour montrer les différentes parties du code
     * 
     * Les 2 premières lignes doivent être mises ensemble car elle font pas mal la même chose : récolter les données de la manette.
     * Après, la prochaine ligne est à part car elle va récolter les 2 valeurs et les mettre ensemble pour ensuite les envoyer au driveframe
     */
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
