/*********************
 * Adam Pape
 * 2/3/13
 * Computer Science III
 * Satellite class
 *********************/

//This class creates and tracks the orbit of a satellite
public class Satellite
{
      //Variables

        // Satellite's X position
        private double x;

        // Satellite's Y position
        private double y;

        // Satellite's X velocity
        private double vx;

        // Satellite's Y velocity
        private double vy;


      //Constants

        // Gravity
        final double G = 6.67 * Math.pow(10,-11);

        // Mass of the Earth
        final double M = 5.97 * Math.pow(10,24);

        // Radius of the Earth
        final int earthRadius = 12756300;

        //Constructor accepts the satellite's initial x and y positions and velocities
        public Satellite(double x, double y, double vx, double vy)
        {

              //Set initial location

                // X axis
                this.x = x;

                // Y axis
                this.y = y;


              //Set initial velocity

                // X axis
                this.vx = vx;
                // Y axis
                this.vy = vy;

        }

        //Setter for the X position
        public void setX(double x)
        {

                this.x = x;
        }

        //Setter for the Y position
        public void setY(double y)
        {

                this.y = y;

        }

        //Setter for the X velocity
        public void setVX(double vx)
        {

                this.vx = vx;

        }


        //Setter for the Y velocity
        public void setVY(double vy)
        {

                this.vy = vy;

        }

        //Getter for the X position
        public double getX()
        {

                return x;

        }

        //Getter for the Y position
        public double getY()
        {

                return y;

        }

        //Getter for the X velocity
        public double getVX()
        {

                return vx;

        }

        //Getter for the Y velocity
        public double getVY()
        {

                return vy;

        }

        //Calculates the X and Y positions and velocities after the specified number of seconds has elapsed
        public void secondsElapsed(int t)
        {

                //Gets the X axis acceleration and stores it in the variable ax
                double ax = this.getAX();

                //Gets the Y axis acceleration and stores it in the variable ay
                double ay = this.getAY();

                //Sets the new X position after t seconds
                x = x + vx * t;

                //Sets the new Y position after t seconds
                y = y + vy * t;

                //Sets the new X velocity after t seconds
                vx = vx + ax * t;

                //Sets the new Y velocity after t seconds
                vy = vy + ay * t;

                //Checks to see if the satellite has crashed and, if so, sets the x and y velocities to zero
                if ( this.hasCrashed() )
                {

                        vx = 0;
                        vy = 0;

                }

        }

        //Calculates the X axis acceleration
        public double getAX()
        {

                //Gets the satellite's distance from the center of the earth and stores it in the variable d
                double d = this.getD();

                //Calculates and returns the X axis acceleration
                return -G * M * x / Math.pow(d,3);

        }

        //Calculates the Y axis acceleration
        public double getAY()
        {

                //Gets the satellite's distance from the center of the earth and stores it in the variable d
                double d = this.getD();

                //Calculates and returns the Y axis acceleration
                return -G * M * y / Math.pow(d,3);

        }

        //Calculates the distance of the satellite from the center of the earth
        public double getD()
        {

                return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

        }

        //Calculates the altitude of the satellite
        public double getAltitude()
        {

                return this.getD() - earthRadius;

        }

        //Determines if the satellite has crashed into the Earth
        public boolean hasCrashed()
        {

                //If the satellite's altitude is zero or less, then it has crashed
                if ( this.getAltitude() <= 0 )
                {

                        return true;

                }

                //If not, it hasn't
                else
                {

                        return false;

                }

        }

}
