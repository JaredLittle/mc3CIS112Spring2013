/*********************
* Adam Pape
* 2/3/13
* Computer Science III
* Satellite class
* page 101, problem 18
*********************/

/**
* This class creates and tracks the orbit of a satellite.
*/
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
        final double GRAVITY = 6.67 * Math.pow(10,-11);

        // Mass of the Earth
        final double EARTH_MASS = 5.97 * Math.pow(10,24);

        // Radius of the Earth
        final int EARTH_RADIUS = 12756300;

        /**
* This constructor sets the satellite's starting position and velocity
* @param x the satellite's position on the x-axis
* @param y the satellite's position on the y-axis
* @param vx the satellite's velocity along the x-axis
* @param vy the satellite's vertical velocity along the y-axis
*/
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

        /**
* @param x the satellite's location along the x-axis
*/
        public void setX(double x)
        {

                this.x = x;
        }

        /**
* @param y the satellite's location along the y-axis
*/
        public void setY(double y)
        {

                this.y = y;

        }


        /**
* @param vx the satellite's velocity along the x-axis
*/
        public void setVX(double vx)
        {

                this.vx = vx;

        }


        /**
* @param vy the satellite's velocity along the y-axis
*/
        public void setVY(double vy)
        {

                this.vy = vy;

        }

        /**
* @return the current location along the x-axis
*/
        public double getX()
        {

                return x;

        }

        /**
* @return the current location along the y-axis
*/
        public double getY()
        {

                return y;

        }

        /**
* @return the current velocity along the x-axis
*/
        public double getVX()
        {

                return vx;

        }

        /**
* @return the current velocity along the y-axis
*/
        public double getVY()
        {

                return vy;

        }

        /**
* Calculates the X and Y positions and velocities after the specified number of seconds has elapsed
* @param t the time in seconds between data updates
*/
        public void secondsElapsed(int t)
        {

                //Gets the X axis acceleration and stores it in the variable ax
                double ax = this.getAX();

                //Gets the Y axis acceleration and stores it in the variable ay
                double ay = this.getAY();

                //Sets the new X position after t seconds
                x = x + (vx * t);

                //Sets the new Y position after t seconds
                y = y + (vy * t);

                //Sets the new X velocity after t seconds
                vx = vx + (ax * t);

                //Sets the new Y velocity after t seconds
                vy = vy + (ay * t);

                //Checks to see if the satellite has crashed and, if so, sets the x and y velocities to zero
                if ( this.hasCrashed() )
                {

                        vx = 0;
                        vy = 0;

                }
        }

        /**
* Calculates the x-axis acceleration
* @return the x-axis acceleration
*/
        //Calculates the X axis acceleration
        public double getAX()
        {
                //Gets the satellite's distance from the center of the earth and stores it in the variable d
                double d = this.getDistance();

                //Calculates and returns the X axis acceleration
                return (-GRAVITY * EARTH_MASS * x) / Math.pow(d,3);
        }

        /**
* Calculates the Y axis acceleration
* @return the y-axis acceleration
*/
        public double getAY()
        {

                //Gets the satellite's distance from the center of the earth and stores it in the variable d
                double d = this.getDistance();

                //Calculates and returns the Y axis acceleration
                return (-GRAVITY * EARTH_MASS * y) / Math.pow(d,3);

        }

        /**
* Calculates the distance of the satellite from the center of the earth in meters
* @return the distance of the satellite from the center of the earth in meters
*/
        public double getDistance()
        {
           			//a^2 + b^2 = c^2 formula        
				    return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        }

        /**
* Calculates the altitude of the satellite
* @return the altitude of the satellite in meters
*/
        public double getAltitude()
        {
               return this.getDistance() - EARTH_RADIUS;
        }

        /**
* Determines if the satellite has crashed into the Earth
* @return returns <code>true</code> is the satellite has crashed into the earth and <code>false</code> if
* it has not.
*/
        public boolean hasCrashed()
        {
				return ( this.getAltitude() <= 0 );
        }
}
