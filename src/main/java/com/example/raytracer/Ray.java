package com.example.raytracer;

public class Ray {

    private CustomPoint3D origin;
    private CustomPoint3D direction;

    public Ray(CustomPoint3D origin, CustomPoint3D direction) {
        this.origin = origin;
        this.direction = direction;
    }

    public CustomPoint3D moveAlongRay(double t) {
        return (CustomPoint3D) origin.add(direction.multiply(t));
    }

}
