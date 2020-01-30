package objects;

public class Projectile{

    double u; // initial velocity
    double T; // angle theta
    double R; // range of projectile
    double H; // height of projectile
    double t; // time of flight
    final double g = 9.80665; // gravity

    public Projectile(double u, double T){
        this.u = u;
        this.T = Math.abs((3.1416/180)*T);
    }

    public Projectile(Point shape){
        this.R = shape.getX();
        this.H = shape.getY();
    }

    public void set(){
        // Horizonal range of projectile
        this.R = u*u*Math.sin(2*T)/g;
        
        // Total time of flight
        this.t = 2*u*Math.sin(T)/g;

        // Maximum height of projectile
        this.H = u*u*Math.pow(Math.sin(T),2)/(2*g);
    }

    // Return max horizonal range
    public double MaxHorRange(){
        set();
        return this.R;
    }

    // Return total time of flight
    public double TimeOfFlight(){
        set();
        return this.t;
    }

    // Return max height of parabola
    public double MaxHeight(){
        set();
        return this.H;
    }

    public double RusingHandu(){
        set();
        return 4*Math.sqrt(H*(u*u/(2*g)-H));
    }
    public double HusingT(){
        set();
        return g*t*t*0.125;
    }
    public double Rusingtandu(){
        set();
        return 0.5*t*Math.sqrt(4*u*u-g*t*g*t);
    }

    // Return horizonal distance at a specific time
    public double HorDistanceAtTime(double time){
        return u*Math.cos(T)*time;
    }

    // Return height at specific time
    public double HeightAtTime(double time){
        return (u*Math.sin(T)*time-0.5*g*time*time);
    }

    // Return height at a specific distance
    public double HeightAtDistance(double x){
        return (x*Math.tan(T)-(g*x*x/(2*Math.pow(u*Math.cos(T),2))));
    }

    // Calculate velocity given distance and angle
    public double calculateVelocity(double angleDegrees) {
        // Convert to radians since that's what the Math functions use
        double theta = Math.abs(Math.toRadians(angleDegrees));

        double part1 = g*R; // gravity * distance
        double part2 = 2*(Math.cos(theta) * Math.sin(theta)); 
        double velocity = Math.sqrt(part1/part2);
        
        return velocity;
    }

    // Calculate angle given distance and velocity
    public double calculateAngle(double velocity) {

        double angleDegrees = 0.0;
        // Distance y is the height of the target
        double result = (R*g)/(velocity*velocity);
        if (result > 1.0) {
            System.out.println("Velocity is to small to reach range target.");
            System.out.println("Increase velocity or decrease range.");       
        } else {
            double theta = Math.asin(result)/2;
            angleDegrees = Math.toDegrees(theta);
        }   
        return angleDegrees;
    }

    // Calculate angle given trajectory and velocity
    public double angleFromTrajectory(double velocity) {
        double angleDegrees = 0.0;
        return angleDegrees;
    }

    // Calculate velocity given trajectory and angle
    public double velocityFromTrajectory(double angleDegrees) {

        // Convert to radians since that's what the Math functions use
        double theta = Math.abs(Math.toRadians(angleDegrees));

        // Now run the magic formular to get velocity
        double part1 = g*R*R; // gravity * x^2
        double part2 = 2*(H - Math.tan(theta)); // 2*(max height - tan(theta)) 
        double velocity = Math.sqrt(part1/part2) / Math.cos(theta);
        return velocity;
    }
}