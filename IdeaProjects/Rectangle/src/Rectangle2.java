public class Rectangle2 {
    double length;
    double breadth;

    public void setParameters(double length, double breadth){
        this.length = length;
        this.breadth = breadth;
    }

    public void setLength(double length){
        this.length=length;
    }

    public void setBreadth(double breadth){
        this.breadth=breadth;
    }

    public double area() {
        return this.length+this.breadth;
    }

    public double getLength() {
        return this.length;
    }

    public double getBreath(){
        return this.breadth;
    }
}
