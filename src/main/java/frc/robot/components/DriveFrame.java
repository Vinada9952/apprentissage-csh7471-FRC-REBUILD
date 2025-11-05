package frc.robot.components;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkFlex;
import frc.robot.data.StickPosition;

public class DriveFrame {
    private final DifferentialDrive differentialDrive;

    public DriveFrame() {
        var leftController = new PWMSparkFlex(1);
        leftController.setInverted(false);

        var rightController = new PWMSparkFlex(0);
        rightController.setInverted(true);

        differentialDrive = new DifferentialDrive(leftController, rightController);

    }

    public void poll() {}

    
    public void singleStickDrive(final StickPosition stickPosition) {
        // FIXME: Use PID
        differentialDrive.arcadeDrive(stickPosition.y(), stickPosition.x());
    }

    public void dualStickDrive( final StickPosition leftStickPosition, final StickPosition rightStickPosition ) {

        StickPosition both_sticks = new StickPosition(rightStickPosition.x(),leftStickPosition.y());
        differentialDrive.arcadeDrive(both_sticks.x(),both_sticks.y());
        // TODO: faire la même chose qu'au dernier cours, mais dans cette fonction
        // pour envoyer une donnée au moteurs, on va utiliser la fonction arcadeDrive du differentialDrive
        // differentialDrive est une variable qui contient en données les 2 moteurs, donc on fait juste lui envoyer un joystick et elle s'occupe du reste
    }
}
