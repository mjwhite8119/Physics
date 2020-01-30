package dynamics;

/**
 * Code to calculate maximum height, horizontal range and time of flight for a projectile
 * Author  : 
 * Version : 0.3
 * Bugs    : Unknown
 * Sample input:
v=5
a=30
or
a=30
v=5
 * here u is projection velocity and a is angle of projection. u is taken in metres per second and a is taken in degrees.
 * Please don't put space between v or a, equal and value. 
*******************************************/

import java.io.*;
import java.text.DecimalFormat;

import objects.Point;
import objects.Projectile;

public class ProjectileMotion
{
    static double velocity, angle, rangeX, heightY;
    static double range1, time, maxh1, range2, range3, maxh2;
    public static void main(String[] args) throws IOException{
        Input();

        // Given velocity and angle
        if (velocity > 0.0 && angle > 0.0) {
            // Print all values that can be computed
            calculateAll();
        } else if (rangeX > 0.0) {
            // define the shape of the projectile trajectory
            Point parabolaShape = new Point(rangeX, heightY);
            Projectile p1=new Projectile(parabolaShape);
            if (velocity > 0.0) {
                angle = p1.calculateAngle(velocity);
                System.out.println("Angle calculated using shape and velocity is : " + new DecimalFormat("#.###").format(angle) + " degrees");            
            } else {
                velocity = p1.calculateVelocity(angle);
                System.out.println("Initial velocity calculated using shape and angle is : " + new DecimalFormat("#.###").format(velocity) + " metres/second");
            }
            // Print all values that can be computed
            calculateAll();
        } 
        
    }

    public static void Input() throws IOException{
        String helper="";
        BufferedReader k = new BufferedReader(new InputStreamReader(System.in));
        String[] s=new String[3];
        System.out.println("Enter any of the following parameters. We calculate when you have enough information");
        System.out.println("a=<value> Angle of projectile");
        System.out.println("v=<value> Initial velocity of projectile");
        System.out.println("x=<value> Range of projectile");
        System.out.println("y=<value> Maximum height of projectile");
        double parameterCount = 0;

        for(int c1=0;c1<3;c1++){
            s[c1]=k.readLine();
            if(s[c1].charAt(0) == 'v'){
                for(int c2=2; c2<s[c1].length(); c2++)
                    helper+=s[c1].charAt(c2);
    
                velocity = Double.parseDouble(helper);
                helper="";
                parameterCount++;
            }
            else if(s[c1].charAt(0) == 'a'){
                for(int c3=2; c3<s[c1].length(); c3++)
                    helper+=s[c1].charAt(c3);
    
                angle = Double.parseDouble(helper);
                helper="";
                if(Math.abs(angle)>90){
                    System.out.print("Invalid angle");
                    System.exit(0);
                }
                parameterCount++;
            }
            else if(s[c1].charAt(0) == 'x'){
                for(int c3=2; c3<s[c1].length(); c3++)
                    helper+=s[c1].charAt(c3);
    
                rangeX = Double.parseDouble(helper);
                helper="";            
                parameterCount++;      
            }
            else if(s[c1].charAt(0) == 'y'){
                for(int c3=2; c3<s[c1].length(); c3++)
                    helper+=s[c1].charAt(c3);
    
                heightY = Double.parseDouble(helper);
                helper="";  
                parameterCount += 0.5;             
            }
            else{
                System.out.print("Invalid input.");
                System.exit(0);
            }

            // Exit for loop if we have enough parameters
            if (parameterCount >= 2.0) {
                break;
            }
        }
    }
    
    public static void calculateAll() {
        Projectile p1=new Projectile(velocity,angle);
        range1=p1.MaxHorRange();
        time=p1.TimeOfFlight();
        maxh1=p1.MaxHeight();
        range2=p1.RusingHandu();
        range3=p1.Rusingtandu();
        maxh2=p1.HusingT();
        System.out.println("Horizontal range is : " + new DecimalFormat("#.###").format(range1) + " metres");
        System.out.println("Maximum height is : " + new DecimalFormat("#.###").format(maxh1) + " metres");
        System.out.println("Time of flight is : " + new DecimalFormat("#.###").format(time) + " seconds");
        System.out.println("Horizontal range calculated using only velocity and maximum height is " + new DecimalFormat("#.###").format(range2) + " metres");
        System.out.println("Horizontal range calculated using only time of flight and velocity is " + new DecimalFormat("#.###").format(range3) + " metres");
        System.out.println("Maximum height calculated using only time of flight is " + new DecimalFormat("#.###").format(maxh2) + " metres");
    }
}